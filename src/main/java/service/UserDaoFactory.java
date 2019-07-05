package service;

import dao.UserDAO;

public class UserDaoFactory {
    private static UserDAO instance;

    private UserDaoFactory() {
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }
}
