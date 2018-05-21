package com.simpleprogrammer.proteintracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

//makes this a parameterized test
@RunWith(Parameterized.class)
public class ParameterizedTests {

    private static TrackingService service = new TrackingService();
    private final int input;
    private final int expected;

    //this is input, output. this shows what we should put and what protein amount should be the output.
    //this is also assuming we keep the same object through out the whole test instead of creating a new instance for each test
    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList(new Object[][]{
                {5, 5},
                {5,10},
                {-12,0},
                {50,50},
                {1,51}
        });
    }

    //the parameters above seem to be set to call this constructer which then sets the private vars then test() is ran next with checks the static service
    public ParameterizedTests(int input, int expectedValue){
        this.input = input;
        this.expected = expectedValue;
    }

    //this tests will go thru each of the parameters above
    @Test
    public void test() {
        //this is because we are using negative numbers in the input to represent removing proteins
        if(input >=0 )
            service.addProtein(input);
        else
            service.removeProtein(-input);

        assertEquals(expected, service.getTotal());
    }
}
