package finalproject.persistence;

import finalproject.entity.Ingredient;
import finalproject.entity.Recipe;
import finalproject.entity.Role;
import finalproject.entity.User;
import finalproject.test.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {
    GenericDao recipeDao;
    GenericDao userDao;
    GenericDao ingredientDao;
    GenericDao roleDao;

    @BeforeEach
    void setUp() {
        recipeDao = new GenericDao(Recipe.class);
        userDao = new GenericDao(User.class);
        ingredientDao = new GenericDao(Ingredient.class);
        roleDao = new GenericDao(Role.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllSuccess() {

        List<Recipe> recipes = recipeDao.getAll();
        assertEquals(4, recipes.size());

        List<User> users = userDao.getAll();
        assertEquals(3, users.size());

        List<Ingredient> ingredients = ingredientDao.getAll();
        assertEquals(2, ingredients.size());

        List<Role> roles = roleDao.getAll();
        assertEquals(2, roles.size());
    }

    /**
     * Verify successful delete
     */
    @Test
    void deleteSuccess() {
       userDao.delete(userDao.getById(3));
        assertNull(userDao.getById(3));

        recipeDao.delete(recipeDao.getById(4));
        assertNull(recipeDao.getById(4));

        ingredientDao.delete(ingredientDao.getById(1));
        assertNull(ingredientDao.getById(1));

        roleDao.delete(roleDao.getById(1));
        assertNull(roleDao.getById(1));
    }

    @Test
    void getByIdSuccess() {
        User user = (User)userDao.getById(1);
        assertEquals("student", user.getUserName());

        Recipe recipe = (Recipe)recipeDao.getById(1);
        assertEquals("grilled cheese", recipe.getRecipeName());

        Ingredient ingredient = (Ingredient)ingredientDao.getById(1);
        assertEquals("cheese", ingredient.getIngredientName());

        Role role = (Role)roleDao.getById(1);
        assertEquals("admin", role.getRoleName());
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {
        User user = (User)userDao.getById(1);
        Recipe recipe = new Recipe(user, "sandwich", "lunch");
        int id = recipeDao.insert(recipe);
        assertNotEquals(0,id);
        Recipe insertedRecipe = (Recipe)recipeDao.getById(id);
        assertEquals("sandwich", insertedRecipe.getRecipeName());
        assertEquals("lunch", insertedRecipe.getMealType());
        assertNotNull(insertedRecipe.getUser());
        assertEquals("student", insertedRecipe.getUser().getUserName());
    }

    /**
     * Verify successful update
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "did it work?";
        User userToUpdate = (User)userDao.getById(2);
        userToUpdate.setUserName(newUserName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(2);
        assertEquals(newUserName, retrievedUser.getUserName());
    }

    @Test
    void getByCriteriaSuccess() {
        String criteria = "mealType";
        String value = "lunch";
        List<Recipe> recipes = recipeDao.getByCriteria(criteria, value);
        assertEquals(2, recipes.size());

    }

    @Test
    void getByMultipleCriteriaSuccess() {
        HashMap<String,String> searchCriteria = new HashMap<>();
        User user = (User)userDao.getById(2);
        searchCriteria.put("mealType", "dinner");
        searchCriteria.put("recipeName", "tacos");

        List<Recipe> recipes = recipeDao.getByMultipleCriteria(user, searchCriteria);

        assertEquals(1, recipes.size());
        assertEquals("tacos", recipes.get(0).getRecipeName() );
    }

}