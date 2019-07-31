package factory.service;

import service.ShoppingCartService;
import service.impl.ShoppingCartServiceImpl;

public class ShoppingCartServiceFactory {

    private static volatile ShoppingCartService shoppingCartService;

    private ShoppingCartServiceFactory() {
    }

    public static ShoppingCartService getShoppingCartService() {
        ShoppingCartService localService = shoppingCartService;
        if (localService == null) {
            synchronized (ShoppingCartService.class) {
                localService = shoppingCartService;
                if (localService == null) {
                    shoppingCartService = localService = new ShoppingCartServiceImpl();
                }
            }
        }
        return localService;
    }

}
