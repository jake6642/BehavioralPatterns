package view;
/*
 * 2018-03-23
 * Patterns of Object-Oriented Systems
 * 
 * Jacob Collins & Malya Juvvadi
 * 
 * Purpose: This package will be responsible for 
 * displaying the user interface. It will also
 * implement the Observer functions so that the interface 
 * can be updated when the model changes, independent of
 * the controller. 
 *
 * */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Model;
import model.Observer;

public class Window extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	private Model model;
	JLabel number;
	JLabel savedNum;
	
	/*Constructor*/
	public Window(Model m, Controller c) {
		super ("Behavioral Patterns");
		this.model = m;
		model.setObserver(this);
		
		/*Init everything for the view*/
		initFrame();
		initComponents(c);		
	}
	
	/*this will init the frame*/
	private void initFrame() {
		setSize(350,250); // default window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
	}
	
	
	private void initComponents(Controller c) {
		/*Setup the buttons*/
		JButton store = new JButton("Store");
		JButton restore = new JButton("Restore");
		JButton increment = new JButton("+");
		JButton decrement = new JButton("-");
		number = new JLabel("0");
		savedNum = new JLabel("");
		savedNum.setFont(new Font("Sans Serif", Font.PLAIN, 20));
		number.setFont(new Font("Sans Serif", Font.PLAIN, 48));
		
		/*Setup the layout*/
		GridLayout grid = new GridLayout();
		JPanel pane = new JPanel();
		JPanel numberPane = new JPanel();
		JPanel changePane = new JPanel();
		numberPane.setLayout(grid);
		pane.setLayout(grid);
		changePane.setLayout(grid);
		pane.add(store);
		pane.add(restore);
		numberPane.add(number);
		numberPane.add(savedNum);
		changePane.add(decrement);
		changePane.add(increment);
		this.add(changePane, BorderLayout.SOUTH);
		number.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		savedNum.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
		this.add(numberPane, BorderLayout.CENTER);
		this.add(pane, BorderLayout.NORTH);
		
		/*setup listeners*/
		store.addActionListener(c);
		restore.addActionListener(c);
		increment.addActionListener(c);
		decrement.addActionListener(c);
	}
	
	/*Observer functions*/
	public void numChanged() {
		number.setText(Integer.toString(model.getNum()));
	}
	
	public void mementoChanged() {
		savedNum.setText("Stored: " + model.getSaved());
	}
	
}
