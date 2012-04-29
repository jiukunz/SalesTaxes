package com.fancyworld;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void should_return_output1_when_input1() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity1 = commodityFactory.create("1 book at 12.49");
        Commodity commodity2 = commodityFactory.create("1 music CD at 14.99");
        Commodity commodity3 = commodityFactory.create("1 chocolate bar at 0.85");

        Taxer taxer = new Taxer();
        Counter counter = new Counter(taxer);

        counter.exhibit(commodity1);
        counter.exhibit(commodity2);
        counter.exhibit(commodity3);

        assertThat(counter.print(), is("1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83\n"));
    }

    @Test
     public void should_return_output2_when_input2() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity1 = commodityFactory.create("1 imported box of chocolates at 10.00");
        Commodity commodity2 = commodityFactory.create("1 imported bottle of perfume at 47.50");

        Taxer taxer = new Taxer();
        Counter counter = new Counter(taxer);

        counter.exhibit(commodity1);
        counter.exhibit(commodity2);

        assertThat(counter.print(), is("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15\n"));
    }

    @Test
    public void should_return_output3_when_input3() throws Exception {
        CommodityFactory commodityFactory = new CommodityFactory();
        Commodity commodity1 = commodityFactory.create("1 imported bottle of perfume at 27.99");
        Commodity commodity2 = commodityFactory.create("1 bottle of perfume at 18.99");
        Commodity commodity3 = commodityFactory.create("1 packet of headache pills at 9.75");
        Commodity commodity4 = commodityFactory.create("1 box of imported chocolates at 11.25");

        Taxer taxer = new Taxer();
        Counter counter = new Counter(taxer);

        counter.exhibit(commodity1);
        counter.exhibit(commodity2);
        counter.exhibit(commodity3);
        counter.exhibit(commodity4);

        assertThat(counter.print(), is("1 imported bottle of perfume: 32.19\n" +
                "1 bottle of perfume: 20.89\n" +
                "1 packet of headache pills: 9.75\n" +
                "1 imported box of chocolates: 11.80\n" +
                "Sales Taxes: 6.65\n" +
                "Total: 74.63\n"));
    }
}
