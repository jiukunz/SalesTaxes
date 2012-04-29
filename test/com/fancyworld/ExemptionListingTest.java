package com.fancyworld;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExemptionListingTest {
    @Test
    public void should_return_true_when_commodity_is_exempt() throws Exception {
        Commodity commodity = mock(Commodity.class);
        when(commodity.getName()).thenReturn("headache pills");

        ExemptionListing exemptionListing = new ExemptionListing();
        boolean isExempt = exemptionListing.contains(commodity);

        assertThat(isExempt,is(true));
    }

    @Test
    public void should_return_false_when_commodity_is_exempt() throws Exception {
        Commodity commodity = mock(Commodity.class);
        when(commodity.getName()).thenReturn("music CD");

        ExemptionListing exemptionListing = new ExemptionListing();
        boolean isExempt = exemptionListing.contains(commodity);

        assertThat(isExempt,is(false));
    }
}
