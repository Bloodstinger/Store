package dao.impl.Hibernate;

import dao.ShoppingCartDao;
import model.Item;
import model.ShoppingCart;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.List;

public class ShoppingCartHibImpl implements ShoppingCartDao {

    private static Logger logger = Logger.getLogger(ShoppingCartHibImpl.class);

    @Override
    public void createShoppingCart(User user) {
        Transaction transaction = null;
        ShoppingCart shoppingCart = new ShoppingCart(user);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in creating shopping cart", e);
        }
    }

    @Override
    public void addItem(User user, Item item) {
        Transaction transaction = null;
        ShoppingCart shoppingCart = getCartByUser(user);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            shoppingCart.setItems(item);
            session.update(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                 transaction.rollback();
            }
            logger.error("Error in adding item to shopping cart", e);
        }
    }

    @Override
    public ShoppingCart getCartByUser(User user) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<ShoppingCart> query =
                    session.createQuery("FROM ShoppingCart WHERE user = :user");
            query.setParameter("user", user);
            return query.getSingleResult();
        } catch (Exception e) {
            logger.error("Cannot get cart by user", e);
        }
        throw new HibernateException("Cannot get cart by user");
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
            logger.error("Error in removing an item from shopping cart", e);
        }
    }

    @Override
    public void clearShoppingCart(User user) {
        Transaction transaction = null;
        ShoppingCart shoppingCart = getCartByUser(user);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(shoppingCart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in clearing shopping cart", e);
        }
    }

    @Override
    public int getSize() {
        try {
            return getAll().size();
        } catch (Exception e) {
            logger.error("Could not get size of items from db", e);
        }
        throw new HibernateException("Could not get size of items from db");
    }

    @Override
    public List<Item> getAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<Item> query = session.createQuery("FROM Item");
            return query.list();
        } catch (Exception e) {
            logger.error("Cannot get list of all item", e);
        }
        throw new HibernateException("Cannot get list of all item");
    }

    @Override
    public User getUserById(Long id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE id = :id");
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error("Cannot get user by id", e);
        }
        throw new HibernateException("Cannot get user by id");    }
}
