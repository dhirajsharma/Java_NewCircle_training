package com.markana.demo;

/** Demonstration that arrays are not completely type-safe
 * @author Ken Jones
 *
 */
public class ArrayTypeError {

	public static void main(String[] args) {
		// Create an array of three anonymous dogs
		Dog[] kennel = { new Dog(), new Dog(), new Dog()};
		
		// Let them all speak
		for (Dog d: kennel) d.speak();
		
		// Dogs are Objects, so this should work
		Object[] things = kennel;
		
		/* A Cat is an Object, so we should be able to add one to the
		 * things array. Note that the following does NOT cause a
		 * compiler error! Instead it throws a RUNTIME exception,
		 * ArrayStoreException.
		 */
		things[0] = new Cat();
	}

}
