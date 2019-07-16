package factory.service;

import service.UserService;
import service.impl.UserServiceImpl;

public class UserServiceFactory {

    private static volatile UserService userService;

    private UserServiceFactory() {
    }

    public static UserService getUserService() {
        UserService localService = userService;
        if (localService == null) {
            synchronized (UserService.class) {
                localService = userService;
                if (localService == null) {
                    userService = localService = new UserServiceImpl();
                }
            }
        }
        return localService;
    }
}
