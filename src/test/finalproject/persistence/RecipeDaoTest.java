package finalproject.persistence;

import finalproject.entity.Recipe;
import finalproject.entity.User;
import finalproject.test.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//SET @@global.time_zone = '-05:00';
class RecipeDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
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
        UserDao userDao = new UserDao();
        User user = userDao.getById(1);
        Recipe recipe = new Recipe(user, "sandwich", "lunch");
        int id = dao.insert(recipe);
        assertNotEquals(0,id);
        Recipe insertedrecipe = dao.getById(id);
        assertEquals("sandwich", insertedrecipe.getRecipeName());
        assertEquals("lunch", insertedrecipe.getMealType());
        assertNotNull(insertedrecipe.getUser());
        assertEquals("student", insertedrecipe.getUser().getUserName());
    }

    /**
     * Verify successful delete of recipe
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
    }

    /**
     * Verify successful update of recipe
     */
    @Test
    void updateSuccess() {
        String newRecipeName = "tomato soup";
        Recipe recipeToUpdate = dao.getById(2);
        recipeToUpdate.setRecipeName(newRecipeName);
        dao.update(recipeToUpdate);
        Recipe retrievedRecipe = dao.getById(2);
        assertEquals(newRecipeName, retrievedRecipe.getRecipeName());
    }
    

}