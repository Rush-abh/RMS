package recipes.model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rushabh
 * ID: 12096494
 */

public interface IModel {
   
    void setRecipesForCategory(String c) throws SQLException;
    
    void setRecipesForCategoryAndPreparationTime(String c, int pt1, int pt2) throws SQLException;

    void setRecipesForCategoryAndCombinedTime(String c, int ct1, int ct2) throws SQLException;

    void setNumberOfRecipesUsingMainIngredient(String i) throws SQLException;   

    void addRecipe(String n, String c, String i, int pt, int ct) throws SQLException;

    void next() throws SQLException;
    void previous() throws SQLException;
    void close() throws SQLException;
}
