package dao;

import model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);

    void removeUser(User user);

    void replaceUser(User user);
}
