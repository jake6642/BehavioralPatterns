package model;
/* Jacob Collins
 * 03-30-2018
 * Implementation of the Singleton Design Pattern
 * 
 * */
import java.util.ArrayList;

public class SingletonMemento {
	/* This is basically a container for the memento */
	private int state;
	private ArrayList<SingletonMemento> mementos = new ArrayList<>();
	
	/* Prevent outsiders from calling this constructor */
	private SingletonMemento(int state) {
		this.state = state;
	}

	/* This subclass will provide access to the memento class */
	private static class Holder {
		private final static SingletonMemento INSTANCE = new SingletonMemento(0);
	}

	public static SingletonMemento getInstance() {
		return Holder.INSTANCE;
	}

	public SingletonMemento setState(int i) {
		Holder.INSTANCE.state = i;
		return Holder.INSTANCE;
	}

	public int getState() {
		return Holder.INSTANCE.state;
	}

	
	/*These methods work as the caretakers for the memento */
	public void addMemento(SingletonMemento m) {
		mementos.add(m);
	}

	public SingletonMemento getMemento() {
		return mementos.get(0);
	}

}
