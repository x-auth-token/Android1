package family;

import common.Food;



public class ClassMain {
	
	public static void main(String[] args) {
		Food food = new Food(500);
		
		Parent mother = new Parent("Tami", food);
		Parent father = new Parent("Kobi", food);
		Child child = new Child("Liron");
		
		Cat cat = new Cat("Sher");
		Dog dog = new Dog("Chupi");
		
		cat.addListener(mother);
		cat.addListener(father);
		
		dog.addListener(mother);
		dog.addListener(father);
		dog.addListener(child);
		
		Thread tcat = new Thread(cat);
		Thread tdog = new Thread(dog);
		
		tcat.start();
		tdog.start();
		
	}
	
	
	
}
