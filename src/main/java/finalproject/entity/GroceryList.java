package finalproject.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroceryList {
    private Set<Recipe> recipes = new HashSet<Recipe>();
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    public GroceryList() {
    }

    public GroceryList(Set<Recipe> recipes, Set<Ingredient> ingredients) {
        this.recipes = recipes;
        this.ingredients = ingredients;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
