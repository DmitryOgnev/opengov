package pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Tests.MainTest;

public class OperatingPage extends Base
{

	public OperatingPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	            //·      Select Careers from Company tab drop-down menu 1.1
	
	public void openCompany(){                                   
		try{                                                                                                    // try catch helps to save fail result into csv in case of fail
		      
			   driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div[3]/nav/div/ul[1]/li[4]/a/span")).click();     // Click on company
		       
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us")));         // Awaiting till the frame opens     
		       
		       printSave("Success", "openCompany() step 2 of the test" + MainTest.Testname);                                                        // Write the result
		} 
		catch(Exception e) {
			   printSave("Fail", "openCompany() step 2 of the test"+ MainTest.Testname);                                                           // Or Write negative result
		}                                  
	}
	
	
	
	           //·      Select Careers from Company tab drop-down menu 1.2
	
	public void selectCareer(){                                                                             // try catch helps to save fail result into csv in case of fail                          
		try{
		     driver.findElement(By.xpath(".//*[@id='companyDropdown']/div/div/div[1]/div/ul/li[3]/a/span[1]")).click();  // Click on career
		
	       	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us")));         // Awaiting till the page opens
	       	 
	         printSave("Success", "selectCareer() step 3 of the test"+ MainTest.Testname);                                                       // Write the result
		 
		} 
		catch(Exception e) {
			   printSave("Fail", "selectCareer() step 4 of the test"+ MainTest.Testname);                                                         // Or Write negative result
		}                                  
	}
	
	
	
	           //·      Click View Open Positions button
	
	public void selectViewOpenPositions() {
		try{                                                                                                  // try catch helps to save fail result into csv in case of fail
		 
		     driver.findElement(By.className("btn__hd")).click();                                           // Click on View Open Positions
		     
		     Thread.sleep(1000);                                                                            // Знаю что ты это не любишь, но здесь все уже подгружено, поэтому прицепиться не к чему
		     
		     printSave("Success", "selectViewOpenPositions() step 5 of the test"+ MainTest.Testname);                                              // Write the result
				
		} 
		catch(Exception e) {
			 printSave("Fail", "selectViewOpenPositions() step 5 of the test"+ MainTest.Testname);                                                  // Or Write negative result
		}               	     
	}
	
	
	
	          //·      Select Engineering from By Team drop-down
	
	public void selectEngineering() {
		try{                                                                                               // try catch helps to save fail result into csv in case of fail
			
		    Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='department']")));  
		 
		    dropdown.selectByVisibleText("Engineering");                                                    // Selecting Engineering from Select
		    printSave("Success", "selectEngineering() step 6 of the test"+ MainTest.Testname);                                                    // Write negative result                  
			
		} 
		catch(Exception e) {
		    printSave("Fail", "selectEngineering() step 6 of the test"+ MainTest.Testname);                                                        // Or Write negative result
		}               
		
	}
	
	
	
	         //·      Find all open positions in Redwood City
	
	public void selectCity() {
		
	   try{	
		    Select dropdown = new Select(driver.findElement(By.cssSelector("select[name='location']")));     
		
		    dropdown.selectByVisibleText("Redwood City");                                                   // Selecting Engineering from Select
		    
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='boxTriggerList__hdg']")));   // Awaiting update of the list                                                                            
		    
		    printSave("Success", "selectCity() step 7 of the test"+ MainTest.Testname);                                                          // Write negative result
			
		} 
		catch(Exception e) {
		    printSave("Fail", "selectCity() step 7 of the test"+ MainTest.Testname);                                                              // Or Write negative result
		}         
		

	}
	
	        

}
