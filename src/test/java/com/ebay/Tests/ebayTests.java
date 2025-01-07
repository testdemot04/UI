package com.ebay.Tests;

import com.ebay.base.BaseTest;
import org.testng.annotations.Test;

public class ebayTests extends BaseTest {

    @Test
public void Verify_item_can_be_added_to_Cart(){
    ebaySearchPage.navigate_to_home_page();
    ebaySearchPage.search_for_book();
    ebaySearchPage.search_and_add_to_cart();
}

}
