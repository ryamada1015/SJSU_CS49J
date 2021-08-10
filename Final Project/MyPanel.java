package edu.sjsu.finalproject;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
	
	JButton myButton = new JButton("Calculate");
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	JTextField textField3 = new JTextField();
	JLabel label1 = new JLabel("Number of days");
	JLabel label2 = new JLabel("Time One");
	JLabel label3 = new JLabel("Time Two");
	JLabel resultMsg;
	
	final int clockX = 400;
	final int clockY = 50;
	final int clockY2 = 100;
	final int clockWidth = 150;
	final int clockHeight = 150;
	
	MyPanel(){
		add(label1);
		add(textField1);
		add(label2);
		add(textField2);
		add(label3);
		add(textField3);
		add(myButton);
		
		setBackground(Color.white);
		setLayout(null);
		
		label1.setBounds(50, 40, 150, 30);
		label2.setBounds(50, 80, 150, 30);
		label3.setBounds(50, 120, 150, 30);
		textField1.setBounds(200, 40, 150, 28);
		textField2.setBounds(200, 80, 150, 28);
		textField3.setBounds(200, 120, 150, 28);
		myButton.setBounds(247, 160, 100, 25);
		
		myButton.addActionListener(e -> printTimeDifference());

	}
	
	public MyPanel getPanel() {
		return this;
	}

	public void printTimeDifference() {
				try {
					String days = textField1.getText();
					String time1 = textField2.getText();
					String time2 = textField3.getText();
					
					if(time1.length() != 4 || time2.length() != 4)
						throw new StringIndexOutOfBoundsException();
					else if(!Character.isDigit(days.charAt(0)))
						throw new NumberFormatException();
					int min1 = Integer.parseInt(time1.substring(2));
					int min2 = Integer.parseInt(time2.substring(2));
					int hour1 = Integer.parseInt(time1.substring(0,2));
					int hour2 = Integer.parseInt(time2.substring(0,2));
					
					if(hour1 < 0 || hour1 >= 25 || hour2 < 0 || hour2 >= 25)
						throw new IllegalArgumentException();
					
					int hourDiff = 0;
					int minDiff = 0;
					
					if(hour1 < hour2 && min1 > min2) {
						hourDiff = 24*(hour2 - hour1 - 1);
						minDiff = 60 - (min1 - min2);
					}
					else if(hour1 <= hour2 && min1 <= min2) {
						hourDiff = 24*(hour2 - hour1);
						minDiff = min2 - min1;
					}
					else if(hour1 >= hour2 && min1 > min2) {
						hourDiff = 24*(24 - (hour1 - hour2) - 1);
						minDiff = 60 - (min1 - min2);
					}
					else if(hour1 > hour2 && min1 <= min2) {
						hourDiff = 24*(24 - (hour1 - hour2));
						minDiff = min2 - min1;
					}
					
//					MyClock clock = new MyClock(hour1, min1, clockX+clockWidth/2, clockHeight+clockHeight/2);
//					MyClock clock2 = new MyClock(hour2, min2, clockX+clockWidth/2, clockY2+clockHeight/2);
//					
//					resultMsg = new JLabel("The time difference is: " + hourDiff + " hours and " + minDiff + " minutes.");
//					
//					getPanel().add(clock);
//					getPanel().add(clock2);
					getPanel().add(resultMsg);
					
//					clock.setBounds(clockX, clockY, clockWidth, clockHeight);
//					clock2.setBounds(clockX, clockY2, clockWidth, clockHeight);

					resultMsg.setBounds(50, 250, 500, 40);
					resultMsg.setFont(new Font("Arial", Font.BOLD, 18));

					
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(getParent(), "Enter a number.");
				}catch(StringIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(getParent(), "Length not correct.");
				}catch(IllegalArgumentException e) {
					JOptionPane.showMessageDialog(getParent(), "Hour out of bound.");
				}
	}
}
