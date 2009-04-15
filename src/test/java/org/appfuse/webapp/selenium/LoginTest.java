/*
 *  Copyright (c) 2009 G2iX and others
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.appfuse.webapp.selenium;

import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Base class for Amazon Web Acceptance tests
 */
public class LoginTest
{
    protected void loginScenario()
        throws Exception
    {
        /* slow down the processing speed 2 seconds per command */
        session().setSpeed( Integer.toString( 2 * 1000 ) );

        session().open( "/" );
        session().waitForPageToLoad( "30000" );
        assertTrue( session().isTextPresent( "Login" ) );
        session().type( "j_username", "admin" );
        session().type( "j_password", "admin" );
        session().click( "//input[@name='login']" );
        session().waitForPageToLoad( "30000" );
        assertTrue( session().isTextPresent( "Welcome" ) );

        session().open( "/mainMenu.html" );
        session().click( "//ul[@id='primary-nav']/li[3]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "link=View Users" );
        session().waitForPageToLoad( "30000" );
        session().click( "//ul[@id='primary-nav']/li[4]/ul/li[2]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "//ul[@id='primary-nav']/li[4]/ul/li[3]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "//ul[@id='primary-nav']/li[4]/ul/li[4]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "//ul[@id='primary-nav']/li[4]/ul/li[4]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "//ul[@id='primary-nav']/li[4]/ul/li[6]/a" );
        session().waitForPageToLoad( "30000" );
        session().click( "link=Main Menu" );
        session().waitForPageToLoad( "30000" );
        session().click( "link=Edit Profile" );
        session().waitForPageToLoad( "30000" );
        session().click( "link=Main Menu" );
        session().waitForPageToLoad( "30000" );
        session().click( "link=Edit Profile" );
        session().waitForPageToLoad( "30000" );
        session().click( "saveUser_button_cancel" );
        session().waitForPageToLoad( "30000" );
        session().captureScreenshot( "screenshot-1.png" );
    }

    private void loginScenarioThatFails()
        throws Exception
    {
        session().open( "/" );
        session().waitForPageToLoad( "30000" );
        assertTrue( session().isTextPresent( "Welcome" ) );
    }

    @Test( groups = { "demo", "multiEnvironment", "default" }, description = "Test login Using Selenium Grid." )
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite" } )
    public void firstTest( String seleniumHost, int seleniumPort, String browser, String webSite )
        throws Throwable
    {
        try
        {
            startSeleniumSession( seleniumHost, seleniumPort, browser, webSite );
            loginScenario();
        }
        finally
        {
            closeSeleniumSession();
        }
    }
}