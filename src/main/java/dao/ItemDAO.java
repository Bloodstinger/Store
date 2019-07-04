package dao;

import db.Storage;
import model.Item;

import java.util.List;

public class ItemDAO {
    private static ItemDAO ourInstance;

    public static ItemDAO getInstance() {
        if (ourInstance == null) {
            ourInstance = new ItemDAO();
        }
        return ourInstance;
    }

    private ItemDAO() {
    }

    public List<Item> getAll() {
        return Storage.ITEMS;
    }

    public void add(Item item) {
        Storage.ITEMS.add(item);
    }
}
