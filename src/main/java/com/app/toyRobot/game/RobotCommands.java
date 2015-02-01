package com.app.toyRobot.game;
import com.app.toyRobot.model.TableTop;
import com.app.toyRobot.exception.*;

public interface RobotCommands {
	
	public void moveForward(TableTop tableCoordinates) throws RobotGameException;
	public String moveLeft();
	public String moveRight();
	public String reportPosition() throws RobotGameException;
	

}
