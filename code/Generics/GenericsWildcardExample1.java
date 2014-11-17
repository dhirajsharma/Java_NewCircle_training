package com.markana.demo;

import java.util.*;

public class GenericsWildcardExample1 {

	public static void main( String[] args) {
		// Create a List of Dog objects
		List<Dog> kennel = new ArrayList<Dog>();
		
		// Adding a Dog is no problem
		kennel.add( new Dog() );
		
		// The following line compiles without error
		List<?> objs = kennel;
		
		/* 
		 * But now we can't make any assumptions about the type of
		 * objects in the objs List. In fact, the only thing that
		 * we can safely do with them is treat them as Objects.
		 * For example, implicitly invoking toString() on them.
		 */
		
		for (Object o: objs) {
			System.out.println("String representation: " + o);
		}
		
	}
}
