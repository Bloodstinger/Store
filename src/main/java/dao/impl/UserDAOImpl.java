package dao.impl;

import dao.UserDao;
import db.Storage;
import model.User;

import java.util.List;

public class UserDAOImpl implements UserDao {

    public List<User> getAll() {
        return Storage.USERS;
    }

    public void add(User user) {
        Storage.USERS.add(user);
    }
}
