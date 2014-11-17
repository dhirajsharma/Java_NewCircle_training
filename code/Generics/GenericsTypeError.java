package com.markana.demo;

import java.util.*;

public class GenericsTypeError {
	public static void main( String[] args) {
		// Create a List of Dog objects
		List<Dog> kennel = new ArrayList<Dog>();
		
		// Adding a Dog is no problem
		kennel.add( new Dog() );
		
		// The following line results in a compiler error
		List<Object> objs = kennel;
		
		// Because if it were allowed, we could do this
		objs.add( new Cat() );
		
		// And now we've got a Cat in our List of Dogs
	}
}
