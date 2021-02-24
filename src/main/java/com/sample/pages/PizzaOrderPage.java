package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;


public class PizzaOrderPage extends TestBase {
    private int longTimeout = 60;


    public void waitForElementToBeVisible(WebElement element) throws ElementClickInterceptedException {
        WebDriverWait wait = new WebDriverWait(this.driver, (long) this.longTimeout, 500L);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementClickInterceptedException.class);
    }

    public void waitForPageToBeInteractable() {

        waitForElementToBeVisible(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")));
    }

    public void selectPizzaTypesAndToppings(String pizzaType, String Toppings1, String Toppings2, String Quantity) throws InterruptedException {
        Select pizza1 = new Select(driver.findElement(By.id("pizza1Pizza")));
        pizza1.selectByValue(pizzaType);


        Select toppings1 = new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")));
        toppings1.selectByValue(Toppings1);
        Select toppings2 = new Select(driver.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")));
        toppings2.selectByValue(Toppings2);
        driver.findElement(By.id("pizza1Qty")).clear();
        driver.findElement(By.id("pizza1Qty")).sendKeys(Quantity);
        sleep(1000);

    }


    public void enterPersonalInfoAndSubmit(String Name, String Email, String Phone, String paymentType) {

        driver.findElement(By.id("name")).sendKeys(Name);

        driver.findElement(By.id("email")).sendKeys(Email);

        driver.findElement(By.id("phone")).sendKeys(Phone);

        if (paymentType.equals("Credit")) {
            driver.findElement(By.id("ccpayment")).click();
        } else {
            driver.findElement(By.id("cashpayment")).click();
        }
        driver.findElement(By.id("placeOrder")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/button")).click();


    }

    public Boolean verifyRequiredErrorDisplayed() {
        try {

            if (driver.findElement(By.xpath("//*[@id='dialog']/p")).isDisplayed()) {
                return false;
            } else return true;
        } catch (Exception e) {
            return false;
        }

    }


    }








