package model;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> items;
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
        items = new ArrayList<>();
    }

    public long getUserId() {
        return user.getId();
    }

    public User getUser() {
        return user;
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

    public ArrayList<Item> getAll() {
        return this.items;
    }
}
