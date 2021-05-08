package finalproject.entity;

import finalproject.persistence.GenericDao;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroceryListTest {
    @Test
    void getIngredientsFromRecipesTest() {
        GroceryList newList = new GroceryList();
        List<Recipe> recipes = new ArrayList<Recipe>();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        User user = new User();
        GenericDao userDao = new GenericDao(User.class);
        user = (User)userDao.getById(1);
        recipes = user.getRecipes();
        ingredients = newList.getIngredientsFromRecipes(recipes);

        for(Ingredient nextIngredient : ingredients) {
            assertEquals(nextIngredient.getIngredientName(), "cheese");
        }

    }

}