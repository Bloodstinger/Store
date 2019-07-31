package service.impl;

import dao.ShoppingCartDao;
import dao.UserDao;
import factory.dao.ShoppingCartDaoFactory;
import factory.dao.UserDaoFactory;
import model.Item;
import model.ShoppingCart;
import model.User;
import service.ShoppingCartService;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final UserDao userDao = UserDaoFactory.getUserDAO();
    private static final ShoppingCartDao shoppingCartDao = ShoppingCartDaoFactory.getShoppingCart();

    @Override
    public void createShoppingCart(User user) {
        shoppingCartDao.createShoppingCart(user);
    }

    @Override
    public void addItem(User user, Item item) {
        shoppingCartDao.addItem(user, item);
    }

    @Override
    public void removeItem(Item item) {
        shoppingCartDao.removeItem(item);
    }

    @Override
    public int getSize() {
        return shoppingCartDao.getSize();
    }

    @Override
    public List<Item> getAll() {
        return shoppingCartDao.getAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public ShoppingCart getCartByUser(User user) {
        return shoppingCartDao.getCartByUser(user);
    }

    @Override
    public void clearShoppingCart(User user) {
        shoppingCartDao.clearShoppingCart(user);
    }
}
