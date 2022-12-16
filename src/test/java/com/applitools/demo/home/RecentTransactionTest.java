package com.applitools.demo.home;

import com.applitools.demo.component.catalog.GridRow;
import com.applitools.demo.HomePageTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RecentTransactionTest extends HomePageTest {
    @Test
    public void whenLoggedIn_thenStarbucksIsOnTop() {
        String firstDescription = this.catalog.homePage().recentTransactions().grid().rowByIndex(0).description();
        Assert.assertEquals(firstDescription, "Starbucks coffee");
    }

    @Test
    public void whenLoggedIn_thenValidateStarbucksStatusAndAmount() {
        GridRow starbucksRow = this.catalog.homePage().recentTransactions().grid().rowByDescription("Starbucks coffee");
        Assert.assertEquals(starbucksRow.status(), "Complete");
        Assert.assertEquals(starbucksRow.amount(), "+ 1,250 USD");
    }

    @Test
    public void whenLoggedIn_thenShowsTopSixRecentTransactions() {
        int count = this.catalog.homePage().recentTransactions().grid().rowCount();
        Assert.assertEquals(count, 6);
    }

    @Test(dataProvider = "ordered_list_of_recent_transaction")
    public void whenTransactionDataAvailable_thenValidateTopSixRecentTransactions(
        int index,
        String status,
        String date,
        String description,
        String category,
        String amount
    ) {
        GridRow row = this.catalog.homePage().recentTransactions().grid().rowByIndex(index);
        Assert.assertEquals(row.status(), status);
        Assert.assertEquals(row.date(), date);
        Assert.assertEquals(row.description(), description);
        Assert.assertEquals(row.category(), category);
        Assert.assertEquals(row.amount(), amount);
    }

    @DataProvider(name = "ordered_list_of_recent_transaction")
    public Object[][] recentTransaction_data() {
        return new Object [][] {
            {0, "Complete", "Today", "Starbucks coffee", "Restaurant / Cafe", "+ 1,250 USD"},
            {1, "Declined", "Jan 19th", "Stripe Payment Processing", "Finance", "+ 952.23 USD"},
            {2, "Pending", "Yesterday", "MailChimp Services", "Software", "- 320 USD"},
            {3, "Pending", "Jan 23rd", "Shopify product", "Shopping", "+ 17.99 USD"},
            {4, "Complete", "Jan 7th", "Ebay Marketplace", "Ecommerce", "- 244 USD"},
            {5, "Pending", "Jan 9th", "Templates Inc", "Business", "+ 340 USD"}
        };
    }
}
