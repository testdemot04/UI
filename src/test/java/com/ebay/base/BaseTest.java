package com.ebay.base;

import com.ebay.pages.ebaySearchPage;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected Browser browser;
  protected Page page;
  protected ebaySearchPage ebaySearchPage;

    @BeforeClass
    public void setup(){
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        page = context.newPage();
        ebaySearchPage=new ebaySearchPage(page);
    }

    @AfterClass
    public void tearDown() {
        page.context().browser().close();
    }

}
