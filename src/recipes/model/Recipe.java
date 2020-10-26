package recipes.model;

/**
 *
 * @author Rushabh
 * Student ID: 12096494
 */

//This class will store and fetch recipe details as required
public class Recipe {
    
    //Variables declaration
    private String category;
    private int cookingTime;
    private int id;
    private String mainIngredient;
    private String name;
    private int preparationTime;

    // no-argument constructor
    public Recipe() {
    }

    // This constructor made to set the input data into variable
    public Recipe(int id, String n, String c, String mi, int pt, int ct) {
        setCategory(c);
        setId(id);
        setName(n);
        setMainIngredient(mi);
        setPreparationTime(pt);
        setCookingTime(ct);
    }
   

    // Get methods are used to read values of variables
    // Set methods are used to set values of variables
    
    public String getCategory() {
        return category;
    }
    
    
    public int getCookingTime() {
        return cookingTime;
    }

    
    public int getId() {
        return id;
    }

    
    public String getMainIngredient() {
        return mainIngredient;
    }

    
    public String getName() {
        return name;
    }

    
    public int getPreparationTime() {
        return preparationTime;
    }

    
    public void setCategory(String category) {
        this.category = category;
    }

    
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    // tostring method will return the recipe details in formatted manner
    @Override
    public String toString() {
        return "Recipe ID: " + id + "\nName: " + name + "\nCategory: " + category + "\nMainIngredient: " + mainIngredient + "\nCooking Time: " + cookingTime + "\nPreparation Time: " + preparationTime + "\n\n";
    }

}
