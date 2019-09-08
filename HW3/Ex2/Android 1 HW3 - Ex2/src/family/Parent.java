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
	
	@Override
	public synchronized void care(Subject subj, NEEDS need) {
		if (!(subj.isTreated())) {
			super.care(subj, need);
			food.getPortion();
			System.out.println(food.getAmount() + " kg of food is left");
		}
	}
	
	
	
	
	
}
