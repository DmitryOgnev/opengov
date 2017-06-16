package pages;

import java.io.BufferedWriter;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tests.MainTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Base
{   
	protected WebDriver driver;
	protected String pageURL = "http://opengov.com";
    public WebDriverWait wait;
    List<String> stepList;                            //list, which contains all steps of the test
    List<String> foundPositions;                      //list, which contains all opened positions
    private Date startDate;                                   //For calculation duration of test
    private String TestName;
    
    public BufferedWriter bufferWriter;
	
	public Base(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		stepList = new ArrayList<String>();
		foundPositions = new ArrayList<String>();
		
		try{  bufferWriter = new BufferedWriter(new FileWriter(new File("C:\\temporarFiles\\result.csv"), true)); }
		catch (IOException e) {e.printStackTrace();}
	}
	
	public void load() {                           // Method, just opened the page
		startDate = new Date();
		try {
		    driver.get(pageURL);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Us")));		
            printSave("Success", "load() step 1 of the test "+ MainTest.Testname) ;
	   } 
	    catch(Exception e) {
	    	 
	          printSave("Fail", "load() step 1 of the test" + MainTest.Testname);
	    }       
	}
	
	public void printSave(String success, String method) {              // Method, that puts all steps into the stepList list
		String finalString = "Date of step performance: " + new Date() + ", Method: " + method + ", Result " + success + ",";   // Here we create the ready string that will be put into stepList list 
		
		System.out.println(finalString);
		stepList.add(finalString);
		
	}
	
	public void printSavePositions(String string){            // Method, that puts all steps into the foundPositions list
		
		System.out.println("Found position: " + string);
		foundPositions.add("Found position: " + string);
		
	}
	
	//·      Given results save in .csv or word format file where print the test run time and test results
	
	public void CSVcreate() throws IOException {        // In this method we make CSV file and put all our lists there
		
		StringBuilder compound_str;
		bufferWriter.write("Column1, Column2, Column3, Column4, Column5" + "\r\n");		
		
		if(stepList.size()>foundPositions.size()){                                      //(Пишем все в 1 файл) Beacuse stepList list () and ompound_str are use in one loop, I have to select the bigest one, А также у меньшего не напороться на отсутствие данных, т.к от закончится первым при переборе большего   
		
		    for(int i=0; i<stepList.size(); i++) {
			      compound_str = new StringBuilder();
		          compound_str.append(stepList.get(i) +"XXXXXXXX,");
		          if(foundPositions.size()>i) {compound_str.append(foundPositions.get(i)+"\r\n"); } 
		           else{compound_str.append("\r\n"); }
		     
		           bufferWriter.write(compound_str.toString());    
		     }
		}
		
		else {                                      // Здесь соответственно если открытых вакансий больше чем steps  
			
		    for(int i=0; i<foundPositions.size(); i++) {
		    	   compound_str = new StringBuilder();
		    	   if(stepList.size()>i) {
		                           compound_str.append(stepList.get(i) +"XXXXXXXX,");
		           }
		            compound_str.append(foundPositions.get(i)+"\r\n"); 
		            bufferWriter.write(compound_str.toString());    
		     }
		}
		
		bufferWriter.write("Total duration of the test: " + MainTest.Testname + " is: "+ (new Date().getTime() - startDate.getTime())/1000 + " seconds\r\b");  // write Total result	
	}
	
	
}
