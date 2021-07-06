package service;

import dao.ItemDAO;

public class ItemDaoFactory {

    private static volatile ItemDAO itemDAO;

    private ItemDaoFactory() {
    }

    public static ItemDAO getItemDao() {
        ItemDAO localItem = itemDAO;
        if (localItem == null) {
            synchronized (ItemDAO.class) {
                localItem = itemDAO;
                if (localItem == null) {
                    itemDAO = localItem = new ItemDAO();
                }
            }
        }
        return localItem;
    }
}
