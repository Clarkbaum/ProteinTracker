package com.simpleprogrammer.proteintracker;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class TrackingServiceTheories {
    @DataPoints
    public static int[] data() {
        return new int[] {
                1,5,10,15,20,50,-4
        };
    }

    //this is a lot like @Test
    @Theory
    public void positiveValuesShouldAlwaysHavePositiveTotals(int value) {
        TrackingService service = new TrackingService();
        service.addProtein(value);
        //this is going to ignore any values that dont meet this, so the -4. other wise this test will fail
        Assume.assumeTrue(value > 0);

        assertTrue(service.getTotal() > 0);
    }
}
