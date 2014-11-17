package com.marakana.demo;

import java.util.Date;
import java.text.*;

public class DateExample {

	public static void main(String[] args) {
		Date now = new Date();
		DateFormat df;
		
		// Get the default date and time format
		df = DateFormat.getDateTimeInstance();
		System.out.println(df.format(now));
		
		// Get the default "short" date and time format
		df = DateFormat.getInstance();
		System.out.println(df.format(now));
		
		// Get the default "medium" date format
		df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println(df.format(now));
		
		// Get the default "long" time format
		df = DateFormat.getTimeInstance(DateFormat.LONG);
		System.out.println(df.format(now));
		
		// An example of parsing a time and date string into a Date
		try {
			df = new SimpleDateFormat("MMM d, y");
			Date birthday = df.parse("August 29, 1965");
			df = DateFormat.getDateInstance(DateFormat.MEDIUM);
			System.out.println(df.format(birthday));
		} catch (ParseException e) {
			// Couldn't parse the date string
			e.printStackTrace();
		}
		
		
	}

}
