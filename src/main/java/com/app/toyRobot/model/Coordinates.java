package com.app.toyRobot.model;
/**
 * This class represents the coordinates along the x and y axis in a given space.
 * An instance of a coordinate determines the position in a given space.
 * @author sirisha
 *
 */
public class Coordinates {
	
	int xAxisCoordinate;
	int yAxisCoordinate;
	
	public int getXAxisCoordinate()
	{
		return this.xAxisCoordinate;
	}
	
	public void setXAxisCoordinate(int X)
	{
		this.xAxisCoordinate =X;
	}
	
	public int getYAxisCoordinate()
	{
		return this.yAxisCoordinate;
	}
	
	public void setYAxisCoordinate(int Y)
	{
		this.yAxisCoordinate =Y;
	}
	
	public Coordinates(int X, int Y)
	{
		this.xAxisCoordinate = X;
		this.yAxisCoordinate =Y;
	}
	
	public Coordinates(String xPosition, String yPosition)
	{
		this.xAxisCoordinate = Integer.parseInt(xPosition);
		this.yAxisCoordinate =Integer.parseInt(yPosition);
	}
	

}
