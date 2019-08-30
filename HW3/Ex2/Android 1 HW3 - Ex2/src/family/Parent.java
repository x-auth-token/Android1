package family;

import java.awt.Event;

import common.Food;
import common.Listeners;


public class Parent extends FamilyMember implements Listeners  {
	
	
	private Food food;
	
	public Parent(String name, Food food) {
		super(name);
		this.food = food;
	}
	
	
	
	
	
}
