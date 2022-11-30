package utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomSequence {
	public String appendPassword()
	{
		String updatePassword="";
		String randomLowerCaseString=RandomStringUtils.randomAlphabetic(1).toLowerCase();
		String randomUppderCaseString=RandomStringUtils.randomAlphabetic(1).toUpperCase();
		int randomInteger=new Random().ints(1000, 9999).findFirst().getAsInt();
		final String alphabet = "!@#$%^&*";
		final int N = alphabet.length();
		Random rd = new Random();
		int iLength = 1;
		StringBuilder special_char = new StringBuilder(iLength);
		for (int i = 0; i < iLength; i++) {
		    special_char.append(alphabet.charAt(rd.nextInt(N)));
		}
		updatePassword=updatePassword+randomLowerCaseString+randomUppderCaseString+special_char+randomInteger;
		return updatePassword;
	}
	
	public String appendEmail()
	{
		String updateEmail="";
		String randomLowerCaseString=RandomStringUtils.randomAlphabetic(1).toLowerCase();
		String randomUppderCaseString=RandomStringUtils.randomAlphabetic(1).toUpperCase();
		int randomInteger=new Random().ints(1000, 9999).findFirst().getAsInt();
		
		updateEmail=updateEmail+randomLowerCaseString+randomUppderCaseString+randomInteger;
		return updateEmail;
	}

}
