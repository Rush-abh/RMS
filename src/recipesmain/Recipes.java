package recipesmain;

import recipes.controller.RecipeController;
import recipes.model.RecipeModel;
import recipes.model.RecipeQueries;
import recipes.view.RecipeView;
import java.sql.SQLException;

/**
 *Date: 24-08-2019
 * @author Rushabh Pancholi
 * ID: 12096494
 */

public class Recipes {

    //main class
    public static void main(String args[]) {
        try {
            //RecipeQueries object
            RecipeQueries rq = new RecipeQueries();
            //RecipePresenter object
            RecipeModel rm = new RecipeModel(rq);
            //RecipeController object
            RecipeController rc = new RecipeController(rm);
            //RecipeView object
            RecipeView rv = new RecipeView(rc);
            rm.addObserver(rv);
            
            //rc.bind(rv);
            //rv.setEnabled(true);
        
            
            //keep windows location relative
            rv.setLocationRelativeTo(null);
            rv.pack();
            rv.setVisible(true);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
