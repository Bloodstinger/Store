package utils;

import model.Item;

import java.util.List;
import java.util.stream.DoubleStream;

public class PriceCount {

    public static Double getPrice(List<Item> list) {
        return list
                .stream()
                .flatMapToDouble(x -> DoubleStream.of(x.getPrice()))
                .sum();
    }
}
