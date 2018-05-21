package com.simpleprogrammer.proteintracker;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
//thjis is filtering the tests based on the ones with this category
@Categories.IncludeCategory(GoodTestsCategory.class)
//i can exclude categories too
@Categories.ExcludeCategory(BadCategory.class)
@Suite.SuiteClasses({
        HistoryItemTest.class,
        TrackingServiceTest.class
})
public interface GoodTestsSuite {
}
