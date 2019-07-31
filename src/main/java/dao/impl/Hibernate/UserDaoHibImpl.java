package dao.impl.Hibernate;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.List;

public class UserDaoHibImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoHibImpl.class);

    @Override
    public void add(User user) {
        Transaction transaction = null;
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in adding user to db", e);
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User");
            return query.list();
        } catch (Exception e) {
            logger.error("Cannot get list of all users", e);
        }
        throw new HibernateException("Cannot get list of all users");
    }

    @Override
    public User getUserById(Long id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE id = :id");
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            logger.error("Cannot get user by id", e);
        }
        throw new HibernateException("Cannot get user by id");
    }

    @Override
    public User getUserByEmail(String email) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE email = :email");
            query.setParameter("email", email);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error("Cannot get user by email", e);
        }
        throw new HibernateException("Cannot get user by email");
    }

    @Override
    public void removeUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in adding user to db", e);
        }
    }

    @Override
    public void replaceUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error in updating user from db", e);
        }
    }
}
