package com.markana.demo;

import java.util.*;

public class GenericsWildcardExample3 {
	
	public static <T> void add1( T obj, Collection<? super T> c) {
		c.add(obj);
	}

	public static <U, T extends U> void add2( T obj, Collection<U> c) {
		c.add(obj);
	}

	public static void main( String[] args) {
		
		// Create a List of Cat and Dog objects
		List<Animal> menagerie = new ArrayList<Animal>();
		
		// Add a Cat and a Dog
		menagerie.add( new Cat() );
		menagerie.add( new Dog() );
		
		// And now let's try using our generic methods to add objects
		add1( new Cat(), menagerie);
		add2( new Dog(), menagerie);
		
		for (Animal o: menagerie) {
			o.identify();
		}
				
	}
}
