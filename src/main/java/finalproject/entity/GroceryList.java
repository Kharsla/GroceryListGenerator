package finalproject.entity;

import finalproject.persistence.GenericDao;

import javax.servlet.http.Cookie;
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


    public List<Integer> getRecipeIdsFromCookies(String cookie) {
        String[] StringOfIDs = cookie.split("-");
        List<Integer> recipeIDs = new ArrayList<Integer>();

        for(String id : StringOfIDs) {
            recipeIDs.add(Integer.parseInt(id));
        }
        return recipeIDs;
    }

    public List<Recipe> getRecipes(List<Integer> recipeIds) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = new Recipe();

        for(int id : recipeIds){
            recipe = (Recipe)recipeDao.getById(id);
            recipes.add(recipe);
        }
        return recipes;
    }

    public List<Ingredient> getIngredientsFromRecipes(List<Recipe> recipes) {
        List<Ingredient> groceryList = new ArrayList<Ingredient>();
        for(Recipe nextRecipe: recipes) {
            List<Ingredient> recipeIngredients = nextRecipe.getIngredients();
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
