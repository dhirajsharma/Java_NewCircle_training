package com.marakana.demo;

import java.text.*;
import java.util.Locale;

public class FormatNumbers {

	public static void main(String[] args) {
		// Print out a number using the localized number, integer, currency,
		 // and percent format for each locale
		 Locale[] locales = NumberFormat.getAvailableLocales();
		 double myNumber = -123456.78;
		 NumberFormat form;
		 for (int j=0; j<4; ++j) {
		     System.out.println("FORMAT");
		     for (Locale l: locales) {
		         if (l.getCountry().length() == 0) {
		            continue; // Skip language-only locales
		         }
		         System.out.print(l.getDisplayName());
		         switch (j) {
		         case 0:
		             form = NumberFormat.getInstance(l); break;
		         case 1:
		             form = NumberFormat.getIntegerInstance(l); break;
		         case 2:
		             form = NumberFormat.getCurrencyInstance(l); break;
		         default:
		             form = NumberFormat.getPercentInstance(l); break;
		         }
		         if (form instanceof DecimalFormat) {
		             System.out.print(":\t" + ((DecimalFormat) form).toPattern());
		         }
		         System.out.print(" ->\t" + form.format(myNumber));
		         try {
		             System.out.println(" ->\t" + form.parse(form.format(myNumber)));
		         } catch (ParseException e) {}
		     }
		 }
	}

}
