package recipes.controller;

import java.sql.SQLException;
import recipes.model.IModel;
import java.util.Observable;
import java.util.Observer;
import recipes.model.Recipe;
import recipes.view.RecipeView;

/**
 *
 * @author Rushabh
 * ID: 12096494
 */

//Controller class will filter the view for user and record user event
public class RecipeController {

    IModel model;
    RecipeView view;

    public RecipeController(IModel m) {
        super();
        model = m;
    }
    //To carry the action of recipeview following methos are made.
    //Calls different methods from model
    public void recipesForCategory(String c) {
        try {
            
            model.setRecipesForCategory(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recipesForCategoryAndPreparationTime(String c, int pt1, int pt2) {
        try {
            model.setRecipesForCategoryAndPreparationTime(c, pt1, pt2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recipesForCategoryAndCombinedTime(String c, int ct1, int ct2) {
        try {
            model.setRecipesForCategoryAndCombinedTime(c, ct1, ct2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void numberOfRecipesUsingMainIngredient(String i) {
        try {
            model.setNumberOfRecipesUsingMainIngredient(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRecipe(String n, String c, String i, int pt, int ct) {
        try {
            model.addRecipe(n, c, i, pt, ct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void next() throws SQLException {
        model.next();
    }
    // calls previous method of model
    public void previous() {
        try {
            model.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // calls close method of model
    public void close() throws SQLException {
        model.close();
    }

}
