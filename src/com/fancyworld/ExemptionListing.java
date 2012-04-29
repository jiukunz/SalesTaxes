package com.fancyworld;

import java.util.HashSet;
import java.util.Set;

public final class ExemptionListing {
    private static Set<String> exemptCommodities = new HashSet<String>();
    static {
        String[] exemptionList = new String[]{"book","chocolate bar","chocolates","headache pills"};
        createExemptionListing(exemptionList);
    }

    private static void createExemptionListing(String[] exemption) {
        for(int i = 0;i < exemption.length;i++){
            exemptCommodities.add(exemption[i]);
        }
    }

    public static boolean contains(Commodity commodity) {
        return exemptCommodities.contains(commodity.getName());
    }
}
