package service;

import dao.ItemDAO;

public class ItemDaoFactory {
    private static ItemDAO instance;
    private ItemDaoFactory() {
    }

    public static ItemDAO getInstance() {
        if (instance == null) {
            instance = new ItemDAO();
        }
        return instance;
    }
}
