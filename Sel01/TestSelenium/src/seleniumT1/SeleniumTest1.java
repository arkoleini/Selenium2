package seleniumT1;

import java.util.List;
import java.util.Random;
import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest1 {

	public static void main(String[] args)  {

		String firstName = "baanu";
		String lastName = "Aali";
		String address = "2345 Ohio Dr, Apt 2345, Plano, TX, 34567";
		String emailAddress = "baanuaali@gmail.com";
		String phoneNumber = "2345678909";

		// set Property, initialize, open URL and maximize
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");

		pause(2);

		// Find Locator
		WebElement myFirstName = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));
		myFirstName.sendKeys(firstName);
		WebElement myLastName = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
		myLastName.sendKeys(lastName);
		WebElement myAddress = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		myAddress.sendKeys(address);
		WebElement myMail = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
		myMail.sendKeys(emailAddress);
		WebElement myPhone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
		myPhone.sendKeys(phoneNumber);
		List<WebElement> gender = driver.findElements(By.xpath("//input[@ng-model='radiovalue']"));
		int index1 = randomNumber(gender, -1);
		gender.get(index1).click();
		List<WebElement> hobbies = driver.findElements(By.xpath("//input[contains(@id,'checkbox')]"));
		int index2 = randomNumber(hobbies, -1);
		int index3 = randomNumber(hobbies, index2);
		hobbies.get(index2).click();
		hobbies.get(index3).click();

		// ------------------------Languages dynamic runtime-----------------------------------------------------------
		pause(2);
		
		List<WebElement> li_List = driver.findElements(By.xpath("//multi-select//UL/Li"));	                  //random  dropdown 
		int indexLang = randomNumber(li_List, -1);  														  //get random index from language 
		WebElement innerLinkElelemt = li_List.get(indexLang).findElement(By.xpath("//*[@class='ui-corner-all']"));
	    String valueLanguage = innerLinkElelemt.getAttribute("innerText");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript( "var span  = document.createElement(\"span\");"
						+ "span.setAttribute('class', 'ui-icon ui-icon-close');"
				        +"span.setAttribute('style', 'display: inline-block; cursor: pointer;');"
						+ "var div1 = document.createElement(\"div\");"
						+ "div1.textContent = \""+valueLanguage+"\";"
						+ "div1.setAttribute('class','ui-autocomplete-multiselect-item');"
						+ "div1.appendChild(span);"
						+ "document.getElementById('msdd').appendChild(div1)");
		


		// ------------------------Skill DropDown-----------------------------------------------------------
		pause(2);

		// JavascriptExecutor
		WebElement skillDorpdown = driver.findElement(By.xpath("//Select[contains(@id,'Skills')]"));
		Actions action = new Actions(driver);
		action.moveToElement(skillDorpdown);

		pause(2);

		List<WebElement> languages = driver.findElements(By.xpath("//Select[contains(@id,'Skills')]//option"));

		for (WebElement option : languages) {
			if (option.getText().equals("C++")) {
				option.click();
			}
		}

		pause(4);

		driver.quit();
	}

	
	//----------random index of list method------
	public static int randomNumber(List<WebElement> myList, int num1) 
	{
		int result = 0;

		do {
			Random r = new Random();
			int start = 0;
			int end = myList.size();
			result = r.nextInt(end - start) + start;

		} while (result == num1);

		return result;
	}
	
	//---------sleep timer--------
	public static void pause(int second) 
	{
	    try {
	      Thread.sleep(second * 1000);
	    } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	  }

}