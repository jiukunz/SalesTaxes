package com.fancyworld;

public class CommodityFactory {
    private Parser parser = new Parser();

    public Commodity create(String description) {
        double price = parser.parsePriceFrom(description);
        int count = parser.parseCountFrom(description);
        String name = parser.parseNameFrom(description);
        Type type = parser.parseTypeFrom(description);

        return new Commodity(count, name,price,type,description);
    }
}
