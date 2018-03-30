package model;



public class Model {
	private Observer observer;
	SingletonMemento memento;
	int num = 0;

	/*default constructor*/
	public Model() {
		//get a single instance of the memento upon model creation. 
		//notice that no "new" operation is called for the memento
		this.memento = SingletonMemento.getInstance();
	}

	/*Set the observer for this model*/
	public void setObserver(final Observer observer) {
		this.observer = observer;
	}


	/* returns the currently saved memento*/
	public String getSaved() {
		return Integer.toString(memento.getMemento().getState());
	}
	
	public void restore() {
		try {
			setNum(memento.getMemento().getState());
		}catch(Exception e){
			System.out.println("No Memento to retrieve");
		}
	}

	/* Allow the controller to save mementos without 
	 * directly accessing the memento class.
	 * */
	public void store() {
		memento.addMemento(memento.setState(getNum()));
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
