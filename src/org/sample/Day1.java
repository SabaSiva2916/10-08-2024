package org.sample;

import java.time.Duration;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {

    public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	// Implicit Wait
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.facebook.com/");
	WebElement btnCreate = driver.findElement(By.xpath("//a[text()='Create new account']"));
	btnCreate.click();

	// WebDriverWait
	WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement txtFN = wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
	txtFN.sendKeys("HelloJava");

	WebElement txtLN = driver.findElement(By.id("lastName"));
	txtLN.sendKeys("Welcome@123");

	WebElement tableData = driver.findElement(By.id("customer"));
	List<WebElement> allRows = tableData.findElements(By.tagName("tr"));
	for (int i = 0; i < allRows.size(); i++) {
	    WebElement ele = allRows.get(i);
	    String text = ele.getText();
	    System.out.println(text);
	}

    }
}
