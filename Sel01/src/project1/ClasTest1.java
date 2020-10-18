package project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasTest1 {
	
	public static void main(String[] args) {
		
	
		    String firstName = "baanu";
		    String lastName = "Aali";
		    String address = "2345 Ohio Dr, Apt 2345, Plano, TX, 34567";
		    String emailAddress = "baanuaali@gmail.com";
		    String phoneNumber = "2345678909";
		    //this is test
		    //***********/
		    //set Property, initialize, open URL and maximize 
		    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://demo.automationtesting.in/Register.html");
		    CarGuru cg = new CarGuru();
		    PracticeDemo1 pd = new PracticeDemo1();
		    
		    cg.pause(1);
		    
		    //Find Locator
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
		    int index1 = pd.randomNumber(gender, -1);
		    gender.get(index1).click();
		    List<WebElement> hobbies = driver.findElements(By.xpath("//input[contains(@id,'checkbox')]"));
		    int index2 = pd.randomNumber(hobbies, -1);
		    int index3 = pd.randomNumber(hobbies, index2);
		    hobbies.get(index2).click();
		    hobbies.get(index3).click();
		    
		    //------------------------Country DropDown dynamic runtime-----------------------------------------------------------
		    
//		    List<WebElement> li_List = driver.findElements(By.xpath("//multi-select//UL/Li"));
		//    
//		    WebElement innerLinkElelemt = li_List.get(3).findElement(By.xpath("//*[@class='ui-corner-all']"));
//		    String res2 = innerLinkElelemt.getAttribute("innerText");
		//    
//		    WebElement Countries = driver.findElement(By.id("msdd"));
//		    Countries.sendKeys("test1");
//		    cg.pause(4);
		    
		    //------------------------Skill DropDown-----------------------------------------------------------
		    
		    JavascriptExecutor 
		    WebElement skillDorpdown = driver .findElement(By.xpath("//Select[contains(@id,'Skills')]"));
		    Actions action = new Actions(driver);
		    action.moveToElement(skillDorpdown);
		    //*********************************************

		    cg.pause(4);

		    
		    
		    List<WebElement> languages = driver.findElements(By.xpath("//Select[contains(@id,'Skills')]//option"));
		    
		    
		    for (WebElement option: languages) {
		      if (option.getText().equals("C++")) {
		        option.click();
		      }
		    }

		  
		    
		    
		    cg.pause(4);

//		    List<WebElement> languages = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]//li[(@class='ng-scope')]"));
//		    int index4 = pd.randomNumber(languages, -1);
//		    dropDown.selectByIndex(index4);
//		    cg.pause(5);


		    driver.quit();
		  
	}
	

}
