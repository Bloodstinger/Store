package dao.impl;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import utils.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserDAOImpl implements UserDao {

    Logger logger = Logger.getLogger(UserDAOImpl.class);

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                User userFromDB = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role"));
                userList.add(userFromDB);
            }
        } catch (SQLException e) {
            logger.error("Problem with getting all users from DB", e);
        }
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + id);

            while (resultSet.next()) {
                User userFromDb = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
                return userFromDb;
            }
        } catch (SQLException e) {
            logger.error("Problem with getting user by id.", e);
        }
        throw new NoSuchElementException("User does not exist");
    }

    @Override
    public User getUserByEmail(String email) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM users WHERE email='" + email + "'");

            while (resultSet.next()) {
                User userFromDb = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
                return userFromDb;
            }

        } catch (SQLException e) {
            logger.error("Problem with getting user by email.", e);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void removeUser(User user) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = String.format("DELETE FROM users WHERE id=%d", user.getId());
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Problem with removing user", e);
        }
    }

    @Override
    public void replaceUser(User user) {
        try (Connection connection = DbConnector.connect()) {
            Statement statement = connection.createStatement();
            String sql = String.format("UPDATE users SET email = '%s', password ='%s' " +
                    "WHERE id = %d;", user.getEmail(), user.getPassword(), user.getId());
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Problem with updating user");
        }
    }

    @Override
    public void add(User user) {
        try (Connection connection = DbConnector.connect()) {
            String sql = String.format("INSERT INTO users (email, password, role) " +
                            "VALUES ('%s', '%s', '%s')",
                    user.getEmail(), user.getPassword(), user.getRole());
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("Problem with adding user.", e);
        }
    }
}
