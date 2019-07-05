package dao;

import db.Storage;
import model.User;

import java.util.List;

public class UserDAO implements DaoPattern<User> {

    private static Long id = 0L;

    public static User createUser(String email, String password) {
        return new User(id++, email, password);
    }

    public List<User> getAll() {
        return Storage.USERS;
    }

    public void add(User user) {
        Storage.USERS.add(user);
    }
}
