package service;

import model.Item;
import model.User;

import java.util.List;

public interface ShoppingCartService {

    void addItem(Item item);

    void removeItem(Item item);

    int getSize();

    List<Item> getAll();

    User getUserById(Long id);
}
