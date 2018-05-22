package com.simpleprogrammer.proteintracker;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
//these from the hamcrest part of the tutorial
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

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
    //this is how you can set one to be multiple categories
    @Category({GoodTestsCategory.class, BadCategory.class})
    public void newTrackingServiceIsZero() {
        assertEquals("tracking service was not zero", 0, service.getTotal());
    }

    @Test
    //just an example of how to ignore
    //@Ignore
    @Category(GoodTestsCategory.class)
    public void WhenAddingProteinTotalIncreasesByThatAmount() {
        service.addProtein(10);
        assertEquals(10, service.getTotal());
        //part of hamcrest
        assertThat(service.getTotal(), is(10));
        //more hamcrest
        assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
    }

    @Test
    @Category(GoodTestsCategory.class)
    public void WhenRemovingProteinTotalRemainsZero() {
        service.removeProtein(5);
        assertEquals(0, service.getTotal());
    }

    //this seems to have to be expectredexception
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //tests to see if the exception i made was thrown
    @Test(expected = InvalidGoalException.class)
    public void WhenGoalIsSetToLessThanZeroExcpetionIsThrown() throws InvalidGoalException {
        //this comes from the Rule above. checks to see what time of thrown it is
        thrown.expect(InvalidGoalException.class);
        thrown.expectMessage("Goal was less than zero");
        service.setGoal(-5);
    }

    //sets timeout for the whole class
    @Rule
    public Timeout timeout = new Timeout(20);

    //timeout example. in milliseconds
    //will no longer need to set timeout here since the rule sets it for the whole class
    @Test
    //@Test(timeout = 200)
    public void TimeOutTest() {
        for(int i = 0; i < 100; i++)
            service.addProtein(i);
    }
}