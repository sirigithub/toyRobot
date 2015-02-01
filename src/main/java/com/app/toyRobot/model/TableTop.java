package com.app.toyRobot.model;
/**
 * This class represents the table top which forms the moving space for the robot.
 * The min and max coordinates determine the space within which the robot can move without
 * falling off.
 * @author sirisha
 *
 */
public class TableTop {
	
	Coordinates maxCoordinates;
	Coordinates minCoordinates;
	
	public TableTop( int xMin, int yMin , int xMax, int yMax)
	{
		minCoordinates = new Coordinates(xMin, yMin);
		maxCoordinates = new Coordinates(xMax, yMax);
	}
	
	public boolean isPositionOnTable(Coordinates newCoordinates)
	{
 	if((newCoordinates.xAxisCoordinate <= maxCoordinates.getXAxisCoordinate())
				&& (newCoordinates.xAxisCoordinate >= minCoordinates.getXAxisCoordinate( ))
				&& (newCoordinates.yAxisCoordinate <= maxCoordinates.getYAxisCoordinate( ))
				&& (newCoordinates.yAxisCoordinate >= minCoordinates.getYAxisCoordinate( )))
				{
					return true;
				}
		return false;		
	}	
	

}
