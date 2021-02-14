package finalproject.persistence;

import finalproject.entity.Recipe;
import finalproject.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDaoTest {
    RecipeDao dao;

    @BeforeEach
    void setUp() {
        dao = new RecipeDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllRecipesSuccess() {
        List<Recipe> recipes = dao.getAllRecipes();
        assertEquals(4, recipes.size());
    }

    /**
     * Verify successful insert of a recipe
     */
    @Test
    void insertSuccess() {

        Recipe recipe = new Recipe(1, "sandwich", "lunch");
        int id = dao.insert(recipe);
        assertNotEquals(0,id);
        Recipe insertedrecipe = dao.getById(id);
        assertEquals("sandwich", insertedrecipe.getRecipeName());
        assertEquals("lunch", insertedrecipe.getMealType());
    }

    /**
     * Verify successful delete of recipe
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(16));
        assertNull(dao.getById(16));
    }

    /**
     * Verify successful update of recipe
     */
    @Test
    void updateSuccess() {
        String newRecipeName = "tomato soup";
        Recipe recipeToUpdate = dao.getById(9);
        recipeToUpdate.setRecipeName(newRecipeName);
        dao.update(recipeToUpdate);
        Recipe retrievedRecipe = dao.getById(9);
        assertEquals(newRecipeName, retrievedRecipe.getRecipeName());
    }


}