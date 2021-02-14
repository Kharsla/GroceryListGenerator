package finalproject.persistence;

import finalproject.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RecipeDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Recipe> getAllRecipes() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        List<Recipe> recipes = session.createQuery(query).getResultList();
        session.close();
        return recipes;
    }

    /**
     * update recipe
     * @param recipe recipe to be updated
     */
    public void update(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * insert recipe
     * @param recipe recipe to be inserted
     * @return id of recipe instered
     */
    public int insert(Recipe recipe) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(recipe);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Recipe
     * @param recipe recipe to be deleted
     */
    public void delete(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipe);
        transaction.commit();
        session.close();
    }
    /**
     * Gets a recipe by id
     * @param id recipe id to search by
     * @return a recipe
     */
    public Recipe getById(int id) {
        Session session = sessionFactory.openSession();
        Recipe recipe = session.get(Recipe.class, id);
        session.close();
        return recipe;
    }
}
