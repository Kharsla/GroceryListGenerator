package finalproject.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.*;

import finalproject.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 */
public class GenericDao<T> {

    private final Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Constructior for Generic Dao
     * @param type type of entity
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     * @return all entities
     */
    public List<T> getAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();

        return list;

    }

    /**
     * Deletes the entity.
     * @param entity entity that will be deleted
     */
    public void delete(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Gets an entity by id
     * @param id entity id
     * @return entity
     */
    public <T> T getById(int id) {
        Session session = sessionFactory.openSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }


    /**
     * Inserts the entity.
     * @param entity entity that will be inserted
     */
    public int insert(T entity) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * updates the entity.
     * @param entity entity that will be updated
     */
    public void saveOrUpdate(T entity) {
       Session session = sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();
       session.saveOrUpdate(entity);
       // sessionFactory.getCurrentSession().merge(entity);
       transaction.commit();
        session.close();
    }


    /**
     * Returns results of query based on search or filter criteria
     * @param criteria variable searched by
     * @param value the value of the criteria searched by
     * @return
     */
    public List<T> getByCriteria(String criteria, Object value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(criteria),value));
        List<T> queryResults = session.createQuery(query).getResultList();
        session.close();
        return queryResults;

    }

    /**
     * Finds entities by multiple properties.
     * Inspired by https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
     * This source and some of the idea was recieved from Tim Zschernitz.
     * https://stackoverflow.com/questions/4014390/jpa-criteria-api-like-equal-problem
     * @param criteriaMap property and value pairs
     * @return entities with properties equal to those passed in the map
     *
     */

    public List<T> getByMultipleCriteria(User user, Map<String, Object> criteriaMap) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(builder.equal(root.get("user"), user));
        for (Map.Entry entry: criteriaMap.entrySet()) {
            Expression<String> expression = root.<String>get((String)entry.getKey());
            String value = (String)entry.getValue();
            predicates.add(builder.like(expression, value));
        }
        query.select(root).where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        return session.createQuery(query).getResultList();
    }

}