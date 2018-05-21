package com.simpleprogrammer.proteintracker;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TrackingServiceTest {

    private TrackingService service;

    //before every test
    @BeforeClass
    public static void before() {
        System.out.println("before class");
    }

    //after every test
    @AfterClass
    public static void after() {
        System.out.println("after class");
    }

    //with out this the amount in TrackingService is undependable because these tests could run in any order
    @Before
    public void setUp() {
        service = new TrackingService();
    }

    @After
    public void teardown() {
        System.out.println(" after");
    }

    @Test
    public void newTrackingServiceIsZero() {
        assertEquals("tracking service was not zero", 0, service.getTotal());
    }

    @Test
    //just an example of how to ignore
    @Ignore
    public void WhenAddingProteinTotalIncreasesByThatAmount() {
        service.addProtein(10);
        assertEquals(10, service.getTotal());
    }

    @Test
    public void WhenRemovingProteinTotalRemainsZero() {
        service.removeProtein(5);
        assertEquals(0, service.getTotal());
    }

    //tests to see if the exception i made was thrown
    @Test(expected = InvalidGoalException.class)
    public void WhenGoalIsSetToLessThanZeroExcpetionIsThrown() throws InvalidGoalException {
        service.setGoal(-5);
    }

    //timeout example. in milliseconds
    @Test(timeout = 200)
    public void TimeOutTest() {
        for(int i = 0; i < 100; i++)
            service.addProtein(i);
    }
}