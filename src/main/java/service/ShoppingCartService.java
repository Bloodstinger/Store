package service;

import model.Item;
import model.ShoppingCart;
import model.User;

import java.util.List;

public interface ShoppingCartService {

    void createShoppingCart(User user);

    void addItem(User user, Item item);

    void removeItem(Item item);

    int getSize();

    List<Item> getAll();

    User getUserById(Long id);

    ShoppingCart getCartByUser(User user);

    void clearShoppingCart(User user);

}
