/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipes.model;

/**
 *
 * @author Rushabh
 */
public class Update {

    String message;
    Recipe recipe;

    public Update(String m, Recipe r) {
        message = m;
        recipe = r;

    }

    public String getMessage() {
        return message;
    }

    public Recipe getRecipe() {
        return recipe;
    }

}
