package dao.impl;

import dao.UserDao;
import db.Storage;
import model.User;

import java.util.List;
import java.util.NoSuchElementException;

public class UserDAOImpl implements UserDao {

    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User getUserById(Long id) {
        for (User user : Storage.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : Storage.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void removeUser(Long id) {
        for (int i = 0; i < Storage.users.size(); i++) {
            User user = Storage.users.get(i);
            if (user.getId().equals(id)) {
                Storage.users.remove(user);
                break;
            }
        }
    }

    public void add(User user) {
        Storage.users.add(user);
    }
}

