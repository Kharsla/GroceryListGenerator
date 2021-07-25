package finalproject.entity;

import finalproject.persistence.GenericDao;
import finalproject.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<Recipe> recipes = new HashSet<>();
        Set<Ingredient> ingredients = new HashSet<>();
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