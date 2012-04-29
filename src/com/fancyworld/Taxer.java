package com.fancyworld;

public class Taxer {
    public double tax(Commodity commodity) {
        double tax = 0;
        if(commodity.getType() == Type.IMPORTED){
            tax += commodity.getPrice() * 0.05;
        }

        if(!ExemptionListing.contains(commodity)){
            tax += commodity.getPrice() * 0.1;
        }
        tax = tax * commodity.getCount();
        return format(tax);
    }

    private double format(double tax) {
        return ((double) (long) (tax * 20 + 0.5)) / 20;
    }
}
