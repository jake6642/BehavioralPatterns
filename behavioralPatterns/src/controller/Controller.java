package controller;
/*
 * 2018-03-23
 * Patterns of Object-Oriented Systems
 * 
 * Jacob Collins & Malya Juvvadi
 * 
 * Purpose: This package will be responsible for 
 * listening for the user input and calling
 * the corresponding Model function.
 *
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class Controller implements ActionListener{
	
	Model model;
	public Controller(Model m) {
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand().toString();
		/* I am unsure how to make this independent of 
		 * the button names so it doesn't depend on the 
		 * view package names...
		 * */
		switch (cmd) {
		case "Restore":
			//restore memento
			model.restore();
			break;
		case "Store":
			//set memento
			model.store();
			break;
		case "+":
			model.incrNum();
			break;
		case "-":
			model.decNum();
			break;
		default:
			break;
		}
	}
}
