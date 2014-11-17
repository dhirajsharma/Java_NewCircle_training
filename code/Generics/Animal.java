package com.markana.demo;

abstract class Animal {
	abstract public void speak();
	
	public void identify() {
		System.out.println("I'm an animal.");
	}
}

class Dog extends Animal {
	@Override
	public void speak() {
		System.out.println("woof");
	}
	
	@Override
	public void identify() {
		System.out.println("I'm a Dog.");
	}
}

class Cat extends Animal {
	@Override
	public void speak() {
		System.out.println("meow");
	}
	
	@Override
	public void identify() {
		System.out.println("I'm a Cat.");
	}
}
