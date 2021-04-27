package finalproject.entity;

import finalproject.persistence.UserDao;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GroceryListTest {
    @Test
    void getIngredientsFromRecipesTest() {
        GroceryList newList = new GroceryList();
        Set<Recipe> recipes = new HashSet<Recipe>();
        Set<Ingredient> ingredients = new HashSet<Ingredient>();
        User user = new User();
        UserDao userDao = new UserDao();
        user = userDao.getById(1);
        recipes = user.getRecipes();
        ingredients = newList.getIngredientsFromRecipes(recipes);

        for(Ingredient nextIngredient : ingredients) {
            assertEquals(nextIngredient.getIngredientName(), "cheese");
        }

    }

}