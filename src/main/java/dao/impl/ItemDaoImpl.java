package dao.impl;

import dao.ItemDao;
import db.Storage;
import model.Item;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    public List<Item> getAll() {
        return Storage.ITEMS;
    }

    public void add(Item item) {
        Storage.ITEMS.add(item);
    }
}
