package service.impl;

import dao.ItemDao;
import factory.dao.ItemDaoFactory;
import model.Item;
import service.IdCounter;
import service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private static ItemDao itemDao = ItemDaoFactory.getItemDao();
    private static long itemID = IdCounter.itemID;

    private Item createItem(String name, String description, double price) {
        return new Item(itemID++, name, description, price);
    }

    @Override
    public void addItem(String name, String description, double price) {
        Item newItem = createItem(name, description, price);
        itemDao.add(newItem);
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
    public Item removeItem(Long id) {
        return itemDao.removeItem(id);
    }

    @Override
    public void update(Item oldItem, Item newItem) {
        itemDao.replaceItem(oldItem, newItem);
    }
}
