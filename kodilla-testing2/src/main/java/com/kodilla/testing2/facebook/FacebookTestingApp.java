package com.kodilla.testing2.facebook;

import com.kodilla.testing2.google.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_INPUT = "//input[@id= 'u_0_n']";
    public static final String XPATH_INPUT2 = "//input[@id= 'u_0_p']";
    public static final String XPATH_MAIL = "//input[@id= 'u_0_s']";
    public static final String XPATH_MAIL_CONFIRM = "//input[@id= 'u_0_v']";
    public static final String XPATH_PASSWORD = "//input[@id= 'u_0_z']";
    public static final String XPATH_SELECT_DAY = "//select[@id= 'day']";
    public static final String XPATH_SELECT_MONTH = "//select[@id= 'month']";
    public static final String XPATH_SELECT_YEAR = "//select[@id= 'year']";
    public static final String XPATH_INPUT_MALE = "//input[@id= 'u_0_6']";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        WebElement inputField = driver.findElement(By.xpath(XPATH_INPUT));
        inputField.sendKeys("Test");

        WebElement inputField2 = driver.findElement(By.xpath(XPATH_INPUT2));
        inputField2.sendKeys("Kodilla");

        WebElement inputMail = driver.findElement(By.xpath(XPATH_MAIL));
        inputMail.sendKeys("testowy@kodilla.pl");

        while (!driver.findElement(By.xpath(XPATH_MAIL_CONFIRM)).isDisplayed());

        WebElement inputMailConfirm = driver.findElement(By.xpath(XPATH_MAIL_CONFIRM));
        inputMailConfirm.sendKeys("testowy@kodilla.pl");


        WebElement inputPassword = driver.findElement(By.xpath(XPATH_PASSWORD));
        inputPassword.sendKeys("password");



       // while (!driver.findElement(By.xpath(XPATH_SELECT)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(12);

        WebElement selectCombo2 = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectBoard2 = new Select(selectCombo2);
        selectBoard2.selectByIndex(6);

        WebElement selectCombo3 = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectBoard3 = new Select(selectCombo3);
        selectBoard3.selectByIndex(20);

        WebElement maleRadioBtn = driver.findElement(By.xpath(XPATH_INPUT_MALE));

        if (!maleRadioBtn.isSelected() && maleRadioBtn.isEnabled()) {
            maleRadioBtn.click();
        }

    }
}
