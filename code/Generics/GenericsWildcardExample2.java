package com.markana.demo;

import java.util.*;

public class GenericsWildcardExample2 {

	public static void main( String[] args) {
		// Create a List of Dog objects
		List<Dog> kennel = new ArrayList<Dog>();
		
		// Adding a Dog is no problem
		kennel.add( new Dog() );
		
		/* 
		 * We can assign to objs a reference to any List as long
		 * as it contains objects of type Animal or some subclass
		 * of Animal.
		 */
		
		List<? extends Animal> objs = kennel;
		
		/* 
		 * Now we know that the objects in the objs List are
		 * all Animals or all the same subclass of Animal. So
		 * we can safely access the existing objects as Animals.
		 * For example, invoking identify() on them.
		 */
		
		for (Animal o: objs) {
			o.identify();
		}
		
		/*
		 * However, it would be a compilation error to try to
		 * add new objects to the list through objs. We don't know
		 * what type of objects the List contains. They might be
		 * all Dogs, or all Cats, or all "generic" Animals. 
		 */
	}
}
