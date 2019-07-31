package dao;

import model.Item;
import model.ShoppingCart;
import model.User;

import java.util.List;

public interface ShoppingCartDao {

    void createShoppingCart(User user);

    void addItem(User user, Item item);

    ShoppingCart getCartByUser(User user);

    void removeItem(Item item);

    void clearShoppingCart(User user);

    int getSize();

    List<Item> getAll();

    User getUserById(Long id);
}
