package utils;

public class ConfirmCode {

    public static String code() {
        Double number = 1000 + Math.random() * 8999;
        return String.valueOf(Math.round(number));
    }
}
