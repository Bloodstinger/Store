package service.impl;

import dao.ItemDao;
import factory.dao.ItemDaoFactory;
import model.Item;
import service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private static ItemDao itemDao = ItemDaoFactory.getItemDao();

    @Override
    public void addItem(String name, String description, double price) {
        itemDao.add(new Item(name, description, price));
    }

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }

    @Override
    public Item getItem(Long id) {
        return itemDao.getItem(id);
    }

    @Override
    public void removeItem(Long id) {
        itemDao.removeItem(id);
    }

    @Override
    public void update(Item oldItem, Item newItem) {
        itemDao.replaceItem(oldItem, newItem);
    }
}
