//package org.openqa.selenium.example;
import junit.framework.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Test;
public class Example extends TestCase {

//LIBO
/*
    public  void testLogin() {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.

        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement elementUserID = driver.findElement(By.name("userId"));
        WebElement elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("andy");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("apple");
        elementUserPassword.submit();
        assertEquals("Online temperature conversion calculator", driver.getTitle());

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        elementUserID = driver.findElement(By.name("userId"));
        elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("bob");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("bathtub");
        elementUserPassword.submit();
        assertEquals("Online temperature conversion calculator", driver.getTitle());


        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        elementUserID = driver.findElement(By.name("userId"));
        elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("charley");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("china");
        elementUserPassword.submit();
        assertEquals("Online temperature conversion calculator", driver.getTitle());

        driver.quit();
    }
*/
    public  void testLoginCaseSensitivity() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement elementUserID = driver.findElement(By.name("userId"));
        WebElement elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("charley");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("China");
        elementUserPassword.submit();
        assertEquals("Bad Login", driver.getTitle());
        driver.quit();
    }

    public void testLoginSpace() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement elementUserID = driver.findElement(By.name("userId"));
        WebElement elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys(" Andy ");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("  apple ");
        elementUserPassword.submit();
        assertEquals("Online temperature conversion calculator", driver.getTitle());

        driver.quit();
    }

/*
    public  void testLoginTimeout() {
	WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement elementUserID = driver.findElement(By.name("userId"));
        WebElement elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("  hello ");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("world");
        elementUserPassword.submit();

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        elementUserID = driver.findElement(By.name("userId"));
        elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("  hello ");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("world");
        elementUserPassword.submit();

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        elementUserID = driver.findElement(By.name("userId"));
        elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("  hello ");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("world");
        elementUserPassword.submit();

        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        elementUserID = driver.findElement(By.name("userId"));
        elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("bob");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("bathtub");
        elementUserPassword.submit();

        //System.out.println(driver.getPageSource());	
        WebElement tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("Wait for 0 seconds before trying to login again",tempElement.getText());
        driver.quit();
    }
*/
    public void testPrecison() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-login.html");
        WebElement elementUserID = driver.findElement(By.name("userId"));
        WebElement elementUserPassword = driver.findElement(By.name("userPassword"));
        elementUserID.clear();
        elementUserID.sendKeys("bob");
        elementUserPassword.clear();
        elementUserPassword.sendKeys("bathtub");
        elementUserPassword.submit();
        assertEquals("Online temperature conversion calculator", driver.getTitle());
        
	WebElement tempElement=driver.findElement(By.name("farenheitTemperature" ));
        tempElement.clear();
        tempElement.sendKeys("214");
        tempElement.submit();
        tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("214 Farenheit = 101.1 Celsius", tempElement.getText());
	driver.quit();
    }


    public void testInputFormat() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=9.73E2");
        WebElement tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("Need to enter a valid temperature!Got a NumberFormatException on 9.73E2", tempElement.getText());
    	driver.quit();
    }


    @Test(expected = NumberFormatException.class)
    public void testNumberFormatException() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=abc");
        WebElement tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("Need to enter a valid temperature!Got a NumberFormatException on abc", tempElement.getText());
    }


    public void testUrlParameter() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://apt-public.appspot.com/testing-lab-conversion?farenheitTemperature=212");
        WebElement tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("212 Farenheit = 100 Celsius", tempElement.getText());

        driver.get("http://apt-public.appspot.com/testing-lab-conversion?FARENHeittemperature=212");
        tempElement=driver.findElement(By.tagName("h2" ));
        assertEquals("212 Farenheit = 100 Celsius", tempElement.getText());
    }


    public static void main(String args[]) {
        String[] testCaseName = 
            { Example.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }

}

