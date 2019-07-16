package dao.impl;

import dao.ItemDao;
import db.Storage;
import model.Item;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.NoSuchElementException;

public class ItemDaoImpl implements ItemDao {

    private static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

    public List<Item> getAll() {
        return Storage.items;
    }

    @Override
    public Item getItem(Long id) {
        return Storage
                .items
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Item removeItem(Long id) {
        Item itemToRemove = Storage
                .items
                .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .get();
        Storage.items.remove(itemToRemove);
        return itemToRemove;
        }

    @Override
    public void replaceItem(Item oldItem, Item newItem) {
        Item replacement = Storage.items
                .stream()
                .filter(item -> item.getId().equals(oldItem.getId()))
                .findFirst()
                .get();
        replacement.setName(newItem.getName());
        replacement.setDescription(newItem.getDescription());
        replacement.setPrice(newItem.getPrice());
    }


    public void add(Item item) {
        Storage.items.add(item);
    }
}
