package factory.dao;

import dao.ShoppingCartDao;
import dao.impl.Hibernate.ShoppingCartHibImpl;
import model.ShoppingCart;

public class ShoppingCartDaoFactory {
    private static volatile ShoppingCartDao shoppingCartDao;

    private ShoppingCartDaoFactory() {
    }

    public static ShoppingCartDao getShoppingCart() {
        ShoppingCartDao localItem = shoppingCartDao;
        if (localItem == null) {
            synchronized (ShoppingCart.class) {
                localItem = shoppingCartDao;
                if (localItem == null) {
                    shoppingCartDao = localItem = new ShoppingCartHibImpl();
                }
            }
        }
        return localItem;
    }
}
