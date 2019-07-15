package service;

import model.User;

import java.util.List;

public interface UserService {

    boolean inDatabase(String email, String password);

    void addUser(String email, String password, String role);

    List<User> getAll();

    User getUser(Long id);

    User getUser(String email);

    void removeUser(Long id);

    void update(User oldUser, User newUser);
}
