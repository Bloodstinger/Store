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
        return new User(userID++, email, password);
    }

    @Override
    public void addUser(String email, String password) {
        User newUser = createUser(email, password);
        userDao.add(newUser);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
