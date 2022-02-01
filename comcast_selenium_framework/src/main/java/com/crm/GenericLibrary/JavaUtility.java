package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will generate random number and return it to the celler
	 * @return
	 */
	public int getRnadomNumber(){
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
			}
	/**
	 * this method will return the current system date
	 * @return
	 */
	public String getcurrentDate(){
		Date date=new Date();
		String currentdate = date.toString();
		return currentdate;
	}
	/**
	 * this method will give the date in specified format
	 * @return
	 */
	public String getFinalDateFormat(){
		Date date=new Date();
		String d = date.toString();
		String[] dte = d.split(" ");
		String YYYY = dte[5];
		String DD = dte[2];
		String MM = dte[1];
		String today = YYYY+"-"+MM+"-"+DD;
		return today;
		
	}
	/**
	 * This method is used to pass virtual key to op
	 * @throws AWTException
	 */
	
	public void pressVurtualEnterKey() throws AWTException
	{
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	
	}
}

