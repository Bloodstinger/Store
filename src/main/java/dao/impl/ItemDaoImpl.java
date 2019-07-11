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
        for (Item item : Storage.items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public Item removeItem(Long id) {
        for (Item item : Storage.items) {
            if (item.getId().equals(id)) {
                Storage.items.remove(item);
                return item;
            }
        }
        throw new NoSuchElementException();
    }

    public void add(Item item) {
        Storage.items.add(item);
    }
}
