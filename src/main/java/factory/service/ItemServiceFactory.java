package factory.service;

import service.ItemService;
import service.impl.ItemServiceImpl;

public class ItemServiceFactory {

    public static volatile ItemService itemService;

    private ItemServiceFactory() {
    }

    public static ItemService getItemService() {
        ItemService localService = itemService;
        if (localService == null) {
            synchronized (ItemService.class) {
                localService = itemService;
                if (localService == null) {
                    itemService = localService = new ItemServiceImpl();
                }
            }
        }
        return localService;
    }
}
