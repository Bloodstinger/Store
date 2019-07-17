package model;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> items;

    ShoppingCart() {
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public ArrayList getAll() {
        return this.items;
    }
}
