package finalproject.entity;

import finalproject.persistence.GenericDao;
import finalproject.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroceryListTest {
    GroceryList newList;
    @BeforeEach
    void setUp() {
        newList = new GroceryList();

    }
    /**
     * Verify successful get ingredients from the recipes
     */
    @Test
    void getIngredientsFromRecipesTest() {

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
    /**
     * Verify successful get Recipe Ids from cookie String
     */
    @Test
    void getRecipeIdsFromCookiesTest() {
        String fakeCookie = "1-2";
        List<Integer> recipeIds = newList.getRecipeIdsFromCookies(fakeCookie);
        int recipe1 = recipeIds.get(0);
        int recipe2 = recipeIds.get(1);
        assertEquals(1, recipe1);
        assertEquals(2, recipe2);


    }


}