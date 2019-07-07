package dao;

import model.Item;

import java.util.List;

public interface ItemDao {

    void add(Item item);

    List<Item> getAll();
}
