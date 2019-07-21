package dao;

import model.Item;

import java.util.List;

public interface ItemDao {

    void add(Item item);

    List<Item> getAll();

    Item getItem(Long id);

    void removeItem(Long id);

    void replaceItem(Item oldItem, Item newItem);
}
