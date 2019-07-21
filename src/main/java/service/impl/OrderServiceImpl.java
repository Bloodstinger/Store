package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import model.Item;
import model.Order;
import service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public List<Item> getOrderItems() {
        return orderDao.getItems();
    }
}
