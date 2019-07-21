package service;

import model.Item;
import model.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    List<Item> getOrderItems();
}
