package ex6and7;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

	public List<T> stackList = new ArrayList<T>();

	public synchronized void push(T item) {
		stackList.add(item);
	}

	public synchronized T pop() {
		T item;
		item = stackList.remove((stackList.size() - 1));
		return item;
	}
}
