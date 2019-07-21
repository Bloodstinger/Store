package service.impl;

import dao.ItemDao;
import dao.UserDao;
import factory.dao.ItemDaoFactory;
import factory.dao.UserDaoFactory;
import model.Item;
import model.User;
import service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    private User user;
    private static final ItemDao itemDao = ItemDaoFactory.getItemDao();
    private static final UserDao userDao = UserDaoFactory.getUserDAO();
    private long userId;
    private List<Item> items = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
