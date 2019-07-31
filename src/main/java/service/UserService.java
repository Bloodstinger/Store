package service;

import model.User;

import java.util.List;

public interface UserService {

    boolean inDatabase(String email, String password);

    void addUser(String email, String password, String role);

    List<User> getAll();

    User getUserById(Long id);

    User getUserByEmail(String email);

    void removeUser(User user);

    void update(User user);
}
