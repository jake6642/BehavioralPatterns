package model;

import java.util.ArrayList;

public class Model {
	private Observer observer;
	Caretaker ct = new Caretaker();
	int num = 0;

	/*default constructor*/
	public Model() {
	}

	/*Set the observer for this model*/
	public void setObserver(final Observer observer) {
		this.observer = observer;
	}

	/*This is basically a container for the mememento*/
	class Memento {
		private int state;

		public Memento(int state) {
			this.state = state;
		}

		public int getState() {
			return state;
		}

	}

	/*Subclass that takes care of the memento*/
	class Caretaker {
		private ArrayList<Memento> mementos = new ArrayList<>();

		public void addMemento(Memento m) {
			mementos.add(m);
		}

		public Memento getMemento() {
			return mementos.get(0);
		}
	}

	/* returns the currently saved memento*/
	public String getSaved() {
		return Integer.toString(ct.getMemento().getState());
	}
	
	public void restore() {
		try {
			setNum(ct.getMemento().getState());
		}catch(Exception e){
			System.out.println("No Memento to retrieve");
		}
	}

	/* Allow the controller to save mementos without 
	 * directly accessing the memento class.
	 * */
	public void store() {
		ct = new Caretaker();
		ct.addMemento(new Memento(getNum()));
		observer.mementoChanged();
	}

	/* set the number to the value specified and 
	 * notify the observer so the view can update
	 * */
	public void setNum(int input) {
		num = input;
		observer.numChanged();
	}

	/*increment the number by 1*/
	public void incrNum() {
		setNum(getNum() + 1);
	}
	
	/*decrement the number by 1*/
	public void decNum() {
		setNum(getNum() - 1);
	}

	/*return the current number upon request*/
	public int getNum() {
		return num;
	}
}
