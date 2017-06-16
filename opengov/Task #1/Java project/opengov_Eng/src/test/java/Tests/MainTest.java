package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.Base;
import pages.OperatingPage;

public class MainTest extends BaseTest
{
    @Rule public TestName name = new TestName();
    public static String Testname;

	private OperatingPage operatingPage;

	@Before
	public void setUp() throws Exception
	{
		operatingPage = new OperatingPage(driver);
		Testname = name.getMethodName();
		
	}

	@After
	public void tearDown() throws Exception
	{
	    System.out.println("See result.csv file");
	    
	  //·      Given results save in .csv or word format file where print the test run time and test results 
		operatingPage.CSVcreate();
		operatingPage.bufferWriter.close();           // Close  BufferedReader
	}

	
	@Test
	public void OpenPositionTestingOfEngeneersInRW()
	{
		
		//·      Open opengov.com
		operatingPage.load();
		
		//·      Select Careers from Company tab drop-down menu 1.1
		operatingPage.openCompany();
		
		//·      Select Careers from Company tab drop-down menu 1.2
		operatingPage.selectCareer();
		
		//·      Click View Open Positions button
		operatingPage.selectViewOpenPositions();
		
		//·      Select Engineering from By Team drop-down
		operatingPage.selectEngineering();
		
		//·      Find all open positions in Redwood City
		operatingPage.selectCity();
		
		//·      Create any assertion for this test
		assertIfOpenPositonsExistsAndWhatWhePositions();
		
		
	   //Optional task:
	   //	·      Create second assertion for this test 
		assertPositionsCanBeOpenedAndCheckInside();
	}
	
	  //Optional task:
	  //·      Given results save in .csv or word format file where print the test run time and test results
	  // See in line 33
	
	
	
	//--------------------------------Assert Methods Definition------------------------------
	
	
	
	 //Definitions of Create any assertion for this test
	
		public void assertIfOpenPositonsExistsAndWhatWhePositions() {
				
			try{		
			        List<WebElement> list = driver.findElements(By.cssSelector("span[class='boxTriggerList__hdg']"));   // Here we take all opened positions
			 
			        if(list.size()==0){                                                                                 // Importent!!! if no positions, it is also positive result, may be we just deleted them and check it
			             assertTrue(driver.findElement(By.xpath(".//*[@id='currentOpenings']/div/div/div/div[2]/div/div/div[2]/div/div/p")).
			    		                                                                     getText().equals("Sorry, nothing was found"));            // but we can check this message
				    }
			        else   { for(WebElement iter: list)  { operatingPage.printSavePositions(iter.getText());}                         // If we have them - lets write into the foundPositions list and print
			        
			        }
			        
			        operatingPage.printSave("Success " + list.size() + " Open positions found", "assertIfOpenPositonsExistsAndWhatWhePositions() step 8 of the test" + Testname) ;                   // We are writing  
			} 
			 catch(Exception e) {
				 operatingPage.printSave("Fail", "assertIfOpenPositonsExistsAndWhatWhePositions() step 8 of the test"+ Testname);
			}       
			  
		}
		
		
		//Definition of method for Optional task:
		//	·      Create second assertion for this test            
		 
		public void assertPositionsCanBeOpenedAndCheckInside(){                            // this method mainly check if the positions can be open and verify it
			try {
			        List<WebElement> list = driver.findElements(By.cssSelector("span[class='boxTriggerList__hdg']"));                  // Now we create list to push there all our positions
			  
			        if(list.size()>0){ for(WebElement iter : list){ iter.click();  }                                                   // Open them in new tabs
				     
			        }
			  
			        
			        if(list.size()>0){
				           String mainTab = driver.getWindowHandle();                                                                  // Make reference to our current  tab
				           ArrayList<String> AllTabs = new ArrayList<String>(driver.getWindowHandles());                               // Make references to All tabs ( including the main)
			    
				           for(int i=1; i<AllTabs.size(); i++){                                                                        // In loop we take all new tabs (not the main, that why we start from i=1)
				    	 
				                driver.switchTo().window(AllTabs.get(i));                                                              // Change positions
				                operatingPage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div/a/span")));    // Awaiting in case of slow connection
				           
				                assertEquals("REDWOOD CITY", driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[1]/div/div[1]")).getText());  // Check data in new tabs (RedWood )
						        assertEquals("ENGINEERING", driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[1]/div/div[2]")).getText());   // Check data in new tabs (Engineering)
						        System.out.println("position #"+ i + " opens well");                                                                        // just print it (double check)
						        driver.close();                                                                                                             // we close new tabs                                            
						  
			               }                                                                                                                                 // loop is finished
				                driver.switchTo().window(mainTab);                                                                                          // we go back to the main tab
			       }
			        
			        
			        
			        operatingPage.printSave("Success " + list.size() + " position pages open well", "assertPositionsCanBeOpenedAndCheckInside()") ;                                              // Saving results
		   } 
		    catch(Exception e) {
		    	 
		    	operatingPage.printSave("Fail", "assertPositionsCanBeOpenedAndCheckInside()");
		    }       

			  
	   }
	

}
