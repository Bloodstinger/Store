package service.impl;

import dao.UserDao;
import factory.dao.UserDaoFactory;
import model.User;
import service.IdCounter;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDao userDao = UserDaoFactory.getUserDAO();
    private static long userID = IdCounter.userID;

    private User createUser(String email, String password) {
        if (!checkUser(email)) {
            return new User(userID++, email, password);
        }
        return getUser(email);
    }

    @Override
    public void addUser(String email, String password) {
        User newUser = createUser(email, password);
        if (!checkUser(email)) {
            userDao.add(newUser);
        }
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUser(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    private boolean checkUser(String email) {
        for (User user : userDao.getAll()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
