package com.ebay.pages;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;

public class ebaySearchPage extends BasePage{


public ebaySearchPage(Page page){
    super(page);
}

private String inputSearchBar="//input[@id='gh-ac']";
private String  searchBtn="//input[@id='gh-btn']";
private String  firstSearchItem ="//ul[@class='srp-results srp-list clearfix']/li[1]//div[@class='s-item__title']";
private String addToCart="//a[@id='atcBtn_btn_1']";
private String cartItem="//i[@id='gh-cart-n']";

    public void navigate_to_home_page() {
       page.navigate("https://ebay.com/");
    }

    public void search_for_book(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.click(inputSearchBar);
        page.fill(inputSearchBar,"book");
        page.click(searchBtn);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void search_and_add_to_cart() {
        page.click(firstSearchItem);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        Page[] pages = page.context().pages().toArray(new Page[0]);
        if (pages.length>1){
            Page nextTab = pages[1];
            nextTab.waitForLoadState();
            nextTab.click(addToCart);
            Integer ItemCount= Integer.valueOf(nextTab.locator(cartItem).textContent());
            System.out.println(ItemCount);
            Assert.assertEquals(ItemCount,1);
        }
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }
}
