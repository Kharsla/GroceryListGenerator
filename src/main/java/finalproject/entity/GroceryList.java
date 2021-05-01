package finalproject.entity;

import java.util.*;

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

  /** NEED TO CHANGE TO COMBINE ONLY INGREDIENTS WITH LIKE UNITS OF MEASUREMENT
   * public Set<Ingredient> combineLikeIngredients(Set<Ingredient> groceryList) {
        private Map<String, Integer> updatedGroceryList new TreeMap<String, Integer>();

        for(Ingredient nextIngredient: groceryList) {
            if (updatedGroceryList.containsKey(nextIngredient.getIngredientName())) {
                updatedGroceryList.put(nextIngredient.getIngredientName(), updatedGroceryList.get(nextIngredient) + nextIngredient.getQuantity());

            } else {
                updatedGroceryList.put(nextIngredient.getIngredientName(), nextIngredient.getQuantity());
            }
        }

    }
   **/

}
