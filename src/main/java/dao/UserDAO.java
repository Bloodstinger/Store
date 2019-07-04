package dao;

import db.Storage;
import model.User;

import java.util.List;

public class UserDAO {
    private static UserDAO ourInstance;

    public static UserDAO getInstance() {
        if (ourInstance == null) {
            return new UserDAO();
        }
        return ourInstance;
    }

    private UserDAO() {
    }

    public List<User> getAll() {
        return Storage.USERS;
    }

    public void add(User user) {
        Storage.USERS.add(user);
    }
}
