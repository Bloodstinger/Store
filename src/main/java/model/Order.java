package model;

import java.util.List;

public class Order {

    private Long orderId;
    private List<Item> itemsList;
    private User user;

    public Order(ShoppingCart shoppingCart) {
        this.itemsList = shoppingCart.getAll();
        this.user = shoppingCart.getUser();
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public User getUser() {
        return user;
    }

}
