package com.app.toyRobot.game;
import com.app.toyRobot.model.Coordinates;
import com.app.toyRobot.model.TableTop;
import com.app.toyRobot.dictionary.*;
import com.app.toyRobot.exception.RobotGameException;

public class Robot implements RobotCommands{
	
	private Coordinates coordinates;
	Direction moveDirection;
	
	private static Robot robotInstance;
	
	private Robot(Coordinates coordinates, Direction direction)
	{
		this.coordinates =coordinates;
		this.moveDirection =direction;
	}
	
	public void moveForward(TableTop tableCoordinates) throws RobotGameException
	{
		
	}
	public void moveLeft()
	{
		
	}
	public void moveRight()
	{
		
	}
	public String reportPosition() throws RobotGameException
	{
		return "";
	}
	

}
