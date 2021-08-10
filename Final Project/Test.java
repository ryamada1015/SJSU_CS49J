package edu.sjsu.finalproject;

import javax.swing.JFrame;

public class Test extends JFrame {
	
	public Test() {
		setTitle("Time Difference");
		setSize(800, 400);
		setLocation(500,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		MyPanel panel = new MyPanel();
		JFrame myApp = new Test();
		panel.printTimeDifference();
		myApp.add(panel);
		myApp.show();
	}

}
