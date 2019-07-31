package dao.impl.Hibernate;

import dao.ItemDao;
import model.Item;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.List;

public class ItemDaoHibImpl implements ItemDao {

    private static final Logger logger = Logger.getLogger(ItemDaoHibImpl.class);

    @Override
    public void add(Item item) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in adding item to db", e);
        }
    }

    @Override
    public List<Item> getAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<Item> query = session.createQuery("FROM Item");
            return query.list();
        } catch (Exception e) {
            logger.error("Could not get all items from db", e);
        }
        throw new HibernateException("Could not get all items from db");
    }

    @Override
    public Item getItem(Long id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<Item> query = session.createQuery("FROM Item WHERE id = :id");
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            logger.error("Could not get item from db", e);
        }
        throw new HibernateException("Could not get item from db");
    }

    @Override
    public void removeItem(Item item) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in removing item from db", e);
        }
    }

    @Override
    public void replaceItem(Item item) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in updating item on db", e);
        }
    }
}
