package service.impl;

import dao.UserDao;
import factory.dao.UserDaoFactory;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDao userDao = UserDaoFactory.getUserDAO();

    @Override
    public boolean inDatabase(String email, String password) {
        for (User user : userDao.getAll()) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(String email, String password, String role) {
        userDao.add(new User(email, password, role));
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

    @Override
    public void update(User oldUser, User newUser) {
        userDao.replaceUser(oldUser, newUser);
    }

}
