package recipes.model;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Rushabh Student ID: 12096494
 */
//model class take queries and notifies changes to RecipeView 
public class RecipeModel extends Observable implements IModel {

    RecipeQueries queries;

    List< Recipe> results;
    int results_int;
    int recipe_added;
    int currentEntryIndex;
    int numberOfEntries;
    Recipe currentEntry;

    public RecipeModel(RecipeQueries rq) {

        queries = rq;
        currentEntryIndex = -1;
        numberOfEntries = -1;
        results = null;
        currentEntry = null;
        results_int = -1;
        recipe_added = -1;

    }

    //check the record count and displays appropriate message
    private void setModelState() {
        Update update = null;
        if (numberOfEntries > 0) {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            update = new Update("Record 1 of " + numberOfEntries, currentEntry);
        } else if (numberOfEntries == 0 || results_int == 0) {
            update = new Update("No recipes", null);
        } else if (results_int > 0) {
            update = new Update("Number of recipes with Main Ingredient: " + Integer.toString(results_int), null);
        } else if (recipe_added > 0) {
            update = new Update("Add Succeeded", null);
        }

        System.out.println("#ofEntries" + numberOfEntries);

        setChanged();
        notifyObservers(update);
    }

    @Override
    public void setRecipesForCategory(String c) throws SQLException {
        results = queries.getRecipesForCategory(c);
        numberOfEntries = results.size();
        System.out.println("in::#ofEntries" + numberOfEntries);
        setModelState();
    }

    @Override
    public void setRecipesForCategoryAndPreparationTime(String c, int pt1, int pt2) throws SQLException {
        results = queries.getRecipesForCategoryAndPreparationTime(c, pt1, pt2);
        numberOfEntries = results.size();
        System.out.println("in::#ofEntries" + numberOfEntries);
        setModelState();
    }

    @Override
    public void setRecipesForCategoryAndCombinedTime(String c, int ct1, int ct2) throws SQLException {
        results = queries.getRecipesForCategoryAndCombinedTime(c, ct1, ct2);
        numberOfEntries = results.size();
        setModelState();
    }

    @Override
    public void setNumberOfRecipesUsingMainIngredient(String i) throws SQLException {
        results = queries.getNumberOfRecipesUsingMainIngredient(i);
        numberOfEntries = results.size();
        System.out.println("in::#ofEntries" + numberOfEntries);
        setModelState();
          
    }

    @Override
    public void addRecipe(String n, String c, String i, int pt, int ct) throws SQLException {
        recipe_added = queries.addRecipe(n, c, i, pt, ct);
        numberOfEntries = -1;
        results_int = -1;
        setModelState();
    }
    // changes currenty entry thus changes the recipe output
    @Override
    public void next() {
        currentEntryIndex++;

        if (numberOfEntries == 0) {
            return;
        }
        
        if (currentEntryIndex == numberOfEntries) {
            currentEntryIndex = 0;
        }

        currentEntry = results.get(currentEntryIndex);
        Update update = new Update("Record " + (currentEntryIndex + 1) + " of " + numberOfEntries, results.get(currentEntryIndex));
        setChanged();
        notifyObservers(update);

    }
    // changes currenty entry thus changes the recipe output
    @Override
    public void previous() {
        currentEntryIndex--;

        if (numberOfEntries == 0) {
            return;
        }

        
        if (currentEntryIndex < 0) {
            currentEntryIndex = numberOfEntries - 1;
        }
        currentEntry = results.get(currentEntryIndex);

        Update update = new Update("Record " + (currentEntryIndex + 1) + " of " + numberOfEntries, results.get(currentEntryIndex));

        setChanged();
        notifyObservers(update);
    }

    @Override
    public void close() {
        try {
            queries.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
