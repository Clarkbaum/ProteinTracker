package com.simpleprogrammer.proteintracker;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class ConsoleRunner {

    public static void main (String args[]) {

        //gives us a runner we can run tests with
        //we dont need this to run junit in the IDE but if we wanted to run the junit from the command line we will
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        junit.run(TrackingServiceTest.class);

    }
}
