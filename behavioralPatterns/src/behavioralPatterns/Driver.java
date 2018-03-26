package behavioralPatterns;
/*
 * 2018-03-23
 * Patterns of Object-Oriented Systems
 * 
 * Jacob Collins & Malya Juvvadi
 * 
 * Purpose: This program will use the MVC framework to 
 * implement the Observer and Memento Patterns. 
 * 
 *
 * */
import controller.Controller;
import model.Model;
import view.Window;

public class Driver {

	public static void main(String[] args) {

		//Create our model to do the calculations
		Model m = new Model();
		//Create the controller that will handle inputs
		Controller c = new Controller(m);
		//create the View
		Window w = new Window(m, c);
		//set it visible last so everything is drawn correctly
		w.setVisible(true);	
	}

}
