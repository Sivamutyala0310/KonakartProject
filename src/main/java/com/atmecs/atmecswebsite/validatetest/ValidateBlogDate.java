package com.atmecs.atmecswebsite.validatetest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ValidateBlogDate
{
	static Long dateDifference;
	
		public static long differenceOfBlogDate(String actualDate) throws ParseException 
		{ 
			try 
			{
			SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd, yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
			Date date = format1.parse(actualDate);
			String blogdate = (format2.format(date));
			System.out.println("Blog published date is:"+" "+blogdate );                    
			String todaysDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			System.out.println("Systems current date is :" + " "+todaysDate );

			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate d1 = LocalDate.parse(blogdate, df);
			LocalDate d2 = LocalDate.parse(todaysDate, df);
			dateDifference = ChronoUnit.DAYS.between(d1, d2);
			}
			
			catch(ParseException exception)
			{
				exception.printStackTrace();
			}
			return dateDifference;
		
	   }
	}
