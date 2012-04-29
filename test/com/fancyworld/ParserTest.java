package com.fancyworld;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void should_parse_commodity_count() throws Exception {
        assertThat(parser.parseCountFrom("1 book at 12.49"), is(1));
    }

    @Test
    public void should_parse_commodity_name() throws Exception {
        assertThat(parser.parseNameFrom("1 music CD at 14.99"), is("music CD"));
        assertThat(parser.parseNameFrom("1 imported book at 16.99"), is("book"));
        assertThat(parser.parseNameFrom("1 box of imported chocolates at 11.25"), is("chocolates"));
    }

    @Test
    public void should_parse_commodity_price() throws Exception {
        assertThat(parser.parsePriceFrom("1 chocolate bar at 0.85"), is(0.85));
    }

    @Test
    public void should_parse_commodity_type() throws Exception {
        assertThat(parser.parseTypeFrom("1 imported box of chocolates at 10.00"), is(Type.IMPORTED));
    }
}
