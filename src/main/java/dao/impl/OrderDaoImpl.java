package dao.impl;

import dao.OrderDao;
import model.Item;
import model.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public List<Item> getItems() {
        return null;
    }
    //TODO add order feature. Order should take shopping cart from session and save items/order
    // details to DB.
}
