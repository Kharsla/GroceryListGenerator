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

    /**
     * Gets the cookie with recipeIDs as a string and converts and returns to list of recipeIDs
     * @param cookie recipes cookie
     * @return list of recipe IDs
     */
    public List<Integer> getRecipeIdsFromCookies(String cookie) {
        String[] StringOfIDs = cookie.split("-");
        List<Integer> recipeIDs = new ArrayList<Integer>();

        for(String id : StringOfIDs) {
            recipeIDs.add(Integer.parseInt(id));
        }
        return recipeIDs;
    }
    /**
     * takes a list of recipeIDs, gets the recipes by their ID, and returns a list of recipes
     * @param recipeIds list of recipeIDs
     * @return list of recipes
     */
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
    /**
     * takes a list of recipes and gets all the ingredients and returns list of ingreidents
     * @param recipes list of recipes
     * @return list of ingredients (grocery list)
     */
    public List<Ingredient> getIngredientsFromRecipes(List<Recipe> recipes) {
        List<Ingredient> groceryList = new ArrayList<Ingredient>();
        for(Recipe nextRecipe: recipes) {
            List<Ingredient> recipeIngredients = nextRecipe.getIngredients();
            groceryList.addAll(recipeIngredients);
        }
        return groceryList;
    }


}
