package factory.dao;

import dao.UserDao;
import dao.impl.UserDAOImpl;

public class UserDaoFactory {

    private static volatile UserDao userDAO;

    private UserDaoFactory() {
    }

    public static UserDao getUserDAO() {
        UserDao localUserDao = userDAO;
        if (localUserDao == null) {
            synchronized (UserDao.class) {
                localUserDao = userDAO;
                if (localUserDao == null) {
                    userDAO = localUserDao = new UserDAOImpl();
                }
            }
        }
        return localUserDao;
    }
}
