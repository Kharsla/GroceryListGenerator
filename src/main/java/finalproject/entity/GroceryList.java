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


    public Set<Recipe> getRecipes(Set<GeneratorRecipe> generatorRecipes) {
        Set<Recipe> recipes = new HashSet<>();
        GenericDao recipeDao = new GenericDao(GeneratorRecipe.class);
        Recipe recipe = new Recipe();

        for(GeneratorRecipe generatorRecipe : generatorRecipes){
            recipe = generatorRecipe.getRecipe();
            recipes.add(recipe);
        }
        return recipes;
    }
    /**
     * takes a list of recipes and gets all the ingredients and returns list of ingreidents
     * @param recipes list of recipes
     * @return list of ingredients (grocery list)
     */
    public Set<Ingredient> getIngredientsFromRecipes(Set<Recipe> recipes) {
        Set<Ingredient> groceryList = new HashSet<>();
        for(Recipe nextRecipe: recipes) {
            Set<Ingredient> recipeIngredients = nextRecipe.getIngredients();
            groceryList.addAll(recipeIngredients);
        }
        return groceryList;
    }

    public Set<Ingredient> combineLikeIngredients(Set<Ingredient> groceryList) {
        Set<Ingredient> organizedGroceryList = new HashSet<>();
        for(Ingredient nextIngredient: groceryList) {
            boolean doesExsist = false;
            for(Ingredient ingredient: organizedGroceryList) {
                if (nextIngredient.getIngredientName().equals(ingredient.getIngredientName()) && nextIngredient.getUnitOfMeasure().equals(ingredient.getUnitOfMeasure())) {
                    double newQuantity = ingredient.getQuantity() + nextIngredient.getQuantity();
                    ingredient.setQuantity(newQuantity);
                    doesExsist = true;
                    break;
                }
            }
            if(!doesExsist) {
                organizedGroceryList.add(nextIngredient);
            }

        }
        return organizedGroceryList;
    }


}
