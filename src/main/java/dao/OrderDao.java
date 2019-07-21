package dao;

import model.Item;
import model.Order;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);

    List<Item> getItems();

}
