package com.fancyworld;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaxerTest {
    @Test
    public void should_return_0_when_exempt_commodity() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity = commodityFactory.create("1 book at 12.49");
        Taxer taxer = new Taxer();
        double tax = taxer.tax(commodity);
        assertThat(tax,is(0.0));
    }

    @Test
    public void should_return_price_with_tax_when_commodity_is_not_exempt() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity = commodityFactory.create("1 music CD at 14.99");
        Taxer taxer = new Taxer();
        double tax = taxer.tax(commodity);
        assertThat(tax,is(1.50));
    }

    @Test
    public void should_return_price_only_with_imported_tax_when_commodity_is_exempt_and_imported() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity = commodityFactory.create("2 imported book at 14.99");
        Taxer taxer = new Taxer();
        double tax = taxer.tax(commodity);
        assertThat(tax,is(1.50));
    }

    @Test
    public void should_return_price_with_origin_tax_and_imported_tax_when_commodity_is_not_exempt_and_imported() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity = commodityFactory.create("1 imported bottle of perfume at 14.99");
        Taxer taxer = new Taxer();
        double tax = taxer.tax(commodity);
        assertThat(tax,is(2.25));
    }
}
