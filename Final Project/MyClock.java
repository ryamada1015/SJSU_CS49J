package edu.sjsu.finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MyClock extends JComponent {

	private int hour;
	private int min;
	private int xCenter;
	private int yCenter;
	final int size = 130;
	
	MyClock(int hour, int min, int xCenter, int yCenter){
		this.hour = hour;
		this.min = min;
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		
		setPreferredSize(new Dimension(size, size));
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getXCenter() {
		return this.xCenter;
	}
	
	public int getYCenter() {
		return this.yCenter;
	}
	
	@Override
	public void paintComponent(Graphics gr) {
		
		super.paintComponent(gr);
		int radius = 60;
		
		gr.setColor(Color.black);
		gr.drawOval(xCenter-radius, yCenter-radius, radius*2, radius*2);
		
		//min hand
		//int minLength = (int) (radius*0.8);
		int xMin = (int) (Math.cos(min * Math.PI / 30 - Math.PI / 2) * 100 + xCenter);
		int yMin = (int) (Math.sin(min * Math.PI / 30 - Math.PI / 2) * 100 + yCenter);
		
		gr.drawLine(xCenter, yCenter, xMin, yMin);
		
		//hour hand
		//int hourLength = (int)(radius*0.5);
		int xHour = (int) (Math.cos((hour * 30 + min / 2) * Math.PI / 180 - Math.PI / 2) * 80 + xCenter);
		int yHour = (int) (Math.sin((hour * 30 + min / 2) * Math.PI / 180 - Math.PI / 2) * 80 + yCenter);
		
		gr.drawLine(xCenter, yCenter, xHour, yHour);
		
		
	}
	
}
