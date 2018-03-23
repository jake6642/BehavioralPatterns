package behavioralPatterns;

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
