package service;

import model.Item;

import java.util.List;

public interface ItemService {

    void addItem(String name, String description, double price);

    List<Item> getAll();

    Item getItem(Long id);

    Item removeItem(Long id);

}
