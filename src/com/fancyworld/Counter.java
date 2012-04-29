package com.fancyworld;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {
    private Parser parser = new Parser();
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    private Taxer taxer;
    private Map<Commodity,Double> sketch = new LinkedHashMap<Commodity, Double>();

    public Counter(Taxer taxer) {
        this.taxer = taxer;
    }

    public void exhibit(Commodity commodity) {
        double tax = taxer.tax(commodity);
        sketch.put(commodity,tax);
    }

    private double totalPrice(){
        double totalPrice = 0;
        for(Map.Entry<Commodity,Double> entry : sketch.entrySet()){
            totalPrice += entry.getKey().getPrice();
        }
        return totalPrice;
    }

    private double totalTax(){
        double totalTax = 0;
        for(Map.Entry<Commodity,Double> entry : sketch.entrySet()){
            totalTax += entry.getValue();
        }
        return totalTax;
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Commodity,Double> entry : sketch.entrySet()){
            stringBuilder.append(parser.transDescription(entry.getKey().getDescription()) + ": ");
            stringBuilder.append(decimalFormat.format(entry.getKey().getPrice() + entry.getValue()) + "\n");
        }
        stringBuilder.append("Sales Taxes: " + decimalFormat.format(totalTax()) + "\n");
        stringBuilder.append("Total: " + decimalFormat.format(totalPrice() + totalTax()) + "\n");
        return stringBuilder.toString();
    }

}
