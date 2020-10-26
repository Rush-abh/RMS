package recipes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class RecipeQueries {

    //database connection details
    private static final String URL = "jdbc:derby://localhost:1527/RecipeDatabase"; //please change location to test  with other database
    private static final String USERNAME = "recipe"; //please change username to test with other database
    private static final String PASSWORD = "recipe"; //please change password to test  with other database
    private Connection connection = null; // manages connection
    
    private PreparedStatement countRecipesWithMainIngrdient = null; 
    private PreparedStatement insertNewRecipe = null;
    private PreparedStatement selectRecipesForCategory = null;
    private PreparedStatement selectRecipesForCategoryAndCombinedTime = null;
    private PreparedStatement selectRecipesForCategoryAndPreparationTime = null;
    
    //includes queries for database search 
    public RecipeQueries() throws SQLException {
        
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        // create query that selects recipes with main ingredient
        countRecipesWithMainIngrdient = connection.prepareStatement("SELECT *  FROM recipes WHERE mainingredient = ?");
        // create query that selects recipes with a specific category
        selectRecipesForCategory = connection.prepareStatement("SELECT * FROM recipes WHERE category = ?");
        // create query that selects recipes with a specific category and cooking time
        selectRecipesForCategoryAndCombinedTime = connection.prepareStatement("SELECT * FROM recipes WHERE category = ? AND cookingtime + preparationtime >= ? AND cookingtime + preparationtime <= ? ");
        // create query that selects recipes with a specific category and preparation time
        selectRecipesForCategoryAndPreparationTime = connection.prepareStatement("SELECT * FROM recipes WHERE category = ? AND preparationtime >= ? AND preparationtime <= ?");

        // create insert that adds a new entry into the database
        insertNewRecipe = connection.prepareStatement("INSERT INTO recipes ( RecipeName, Category, MainIngredient, PreparationTime, CookingTime ) VALUES ( ?, ?, ?, ?, ? )");
    }

    private Recipe createRecipe(ResultSet rs) throws SQLException {
        return new Recipe(
                rs.getInt("ID"),
                rs.getString("RECIPENAME"),
                rs.getString("CATEGORY"),
                rs.getString("MAININGREDIENT"),
                rs.getInt("PREPARATIONTIME"),
                rs.getInt("COOKINGTIME")
        );
    }

    // get count of recipes for given main ingredient
    public List< Recipe> getNumberOfRecipesUsingMainIngredient(String mi) throws SQLException {
        countRecipesWithMainIngrdient.setString(1, mi);
        try (ResultSet resultSet = countRecipesWithMainIngrdient.executeQuery()) {
            List <Recipe> results = new ArrayList<>();
            while (resultSet.next()) {
                String m = resultSet.getString(1);
                results.add(createRecipe(resultSet));
            }
            return results;
        }
    }

    // select all of the recipes in the database by category
    public List< Recipe> getRecipesForCategory(String c) throws SQLException {        
        selectRecipesForCategory.setString(1, c);
        try (ResultSet resultSet = selectRecipesForCategory.executeQuery()) {
            int size = 0;        
            List<Recipe> results = new ArrayList<>();
            while (resultSet.next()) {
                String m = resultSet.getString(1);                          
                results.add(createRecipe(resultSet));
            }            
            return results;

        }
    }

    // select all of the recipes in the database by category and combined time
    public List< Recipe> getRecipesForCategoryAndCombinedTime(String c, int ct1, int ct2) throws SQLException {
        selectRecipesForCategoryAndCombinedTime.setString(1, c);
        selectRecipesForCategoryAndCombinedTime.setInt(2, ct1);
        selectRecipesForCategoryAndCombinedTime.setInt(3, ct2);
        try (ResultSet resultSet = selectRecipesForCategoryAndCombinedTime.executeQuery()) {
            List<Recipe> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(createRecipe(resultSet));
            }
            return results;
        }
    }

    // select all of the recipes in the database by category and preparation time
    public List< Recipe> getRecipesForCategoryAndPreparationTime(String c, int pt1, int pt2) throws SQLException {
        selectRecipesForCategoryAndPreparationTime.setString(1, c);
        selectRecipesForCategoryAndPreparationTime.setInt(2, pt1);
        selectRecipesForCategoryAndPreparationTime.setInt(3, pt2);
        try (ResultSet resultSet = selectRecipesForCategoryAndPreparationTime.executeQuery()) {
            List<Recipe> results = new ArrayList<>();
            while (resultSet.next()) {
                results.add(createRecipe(resultSet));
            }
            return results;
        }
    }

    // add an entry
    public int addRecipe(String n, String c, String mi, int pt, int ct) throws SQLException {
        // insert recipe attributes into prepared statement
        insertNewRecipe.setString(1, n);
        insertNewRecipe.setString(2, c);
        insertNewRecipe.setString(3, mi);
        insertNewRecipe.setInt(4, pt);
        insertNewRecipe.setInt(5, ct);
        
        // no closing required as an int is returned, not a result set
        return insertNewRecipe.executeUpdate();
    }

    // close the database connection
    public void close() throws SQLException {
        // In Java 9, we can do try( connection ), but I am running Java 8
        try (Connection c = connection) {
            countRecipesWithMainIngrdient.close();
            insertNewRecipe.close();
            selectRecipesForCategory.close();
            selectRecipesForCategoryAndCombinedTime.close();
            selectRecipesForCategoryAndPreparationTime.close();
        }
        //connection is closed automatically

    }

}
