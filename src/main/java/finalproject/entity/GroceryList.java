package finalproject.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroceryList {
    private Set<Recipe> recipes = new HashSet<Recipe>();
    

    public GroceryList() {
    }

    public GroceryList(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
    

    public Set<Ingredient> getIngredientsFromRecipes(Set<Recipe> recipes) {
        Set<Ingredient> groceryList = new HashSet<Ingredient>();
        for(Recipe nextRecipe: recipes) {
            Set<Ingredient> recipeIngredients = nextRecipe.getIngredients();
            groceryList.addAll(recipeIngredients);
        }
        return groceryList;
    }

}
