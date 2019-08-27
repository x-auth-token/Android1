package family;

import common.Food;



public class ClassMain {
	
	public static void main(String[] args) {
		Food food = new Food(50);
		
		Parent mother = new Parent("Tami", food);
		Parent father = new Parent("Kobi", food);
		Child child = new Child("Liron");
		
		Cat cat = new Cat("Sher");
		Dog dog = new Dog("Chupi");
		
		cat.addLlistener(mother);
		cat.addLlistener(father);
		
		dog.addLlistener(mother);
		dog.addLlistener(father);
		dog.addLlistener(child);
		
		Thread tcat = new Thread(cat);
		Thread tdog = new Thread(dog);
		
		tcat.start();
		tdog.start();
		
	}
	
	
	
}
