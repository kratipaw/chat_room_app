package edu.udacity.java.nano.chat;

import edu.udacity.java.nano.pages.ChatHtml;
import edu.udacity.java.nano.pages.LoginHtml;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.openqa.selenium.WebDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebSocketConfig.class})
@WebAppConfiguration
public class WebSocketChatServerTest {

    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new HtmlUnitDriver(true);
    }

    @After
    public void destroy() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    @Test
    public void loginAndJoin() throws Exception{
        LoginHtml page = LoginHtml.to(webDriver);
        ChatHtml chat = page.loginAndJoin("joey");

        (new WebDriverWait(chat.webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("username: " + chat.getUsername().getText());
                return chat.getUsername().getText().equals(page.getUsernameText());
            }
        });
    }

    @Test
    public void chat() throws Exception {
        LoginHtml page = LoginHtml.to(webDriver);
        ChatHtml chat = page.loginAndJoin("joey");
        chat.sendChatMessage("Hey!! How you doin?");

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("current URL: " + chat.getCurrentUrl());
                return chat.getMessageContent() != null && chat.getMessageContent().getText().contains(page.getUsernameText());
            }
        });
    }

    @Test
    public void logout() throws Exception {

        LoginHtml page = LoginHtml.to(webDriver);
        ChatHtml chat = page.loginAndJoin("joey");
        chat.sendChatMessage("Hey!! How you doin?");


        WebElement element = webDriver.findElement(By.id("logout"));

        element.click();

        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver input) {
                System.out.println("logout triggered. current URL: " + webDriver.getCurrentUrl());
                return webDriver.getCurrentUrl().equals("http://localhost:8080/");
            }
        });
    }


}
