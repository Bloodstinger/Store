package dao;

import db.Storage;
import model.Item;

import java.util.List;

public class ItemDAO implements DaoPattern<Item> {

    private static Long id = 0L;

    public static Item createItem(String name, String description, Double price) {
        return new Item(id++, name, description, price);
    }

    public List<Item> getAll() {
        return Storage.ITEMS;
    }

    public void add(Item item) {
        Storage.ITEMS.add(item);
    }
}
