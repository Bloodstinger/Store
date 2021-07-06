package service;

import dao.UserDAO;

public class UserDaoFactory {

    private static volatile UserDAO userDAO;

    private UserDaoFactory() {
    }

    public static UserDAO getUserDAO() {
        UserDAO localUserDao = userDAO;
        if (localUserDao == null) {
            synchronized (UserDAO.class) {
                localUserDao = userDAO;
                if (localUserDao == null) {
                    userDAO = localUserDao = new UserDAO();
                }
            }
        }
        return localUserDao;
    }
}
