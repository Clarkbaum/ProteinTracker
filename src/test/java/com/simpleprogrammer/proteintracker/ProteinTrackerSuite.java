package com.simpleprogrammer.proteintracker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//this will run all the tests in the suiteclasses list
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HistoryItemTest.class,
        TrackingServiceTest.class
})
public class ProteinTrackerSuite {
}
