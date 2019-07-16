package factory.dao;

import dao.ItemDao;
import dao.impl.ItemDaoImpl;

public class ItemDaoFactory {

    private static volatile ItemDao itemDAO;

    private ItemDaoFactory() {
    }

    public static ItemDao getItemDao() {
        ItemDao localItem = itemDAO;
        if (localItem == null) {
            synchronized (ItemDao.class) {
                localItem = itemDAO;
                if (localItem == null) {
                    itemDAO = localItem = new ItemDaoImpl();
                }
            }
        }
        return localItem;
    }
}
