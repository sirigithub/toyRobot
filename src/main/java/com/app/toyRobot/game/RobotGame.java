package com.app.toyRobot.game;

import com.app.toyRobot.model.Coordinates;
import com.app.toyRobot.model.TableTop;
import com.app.toyRobot.dictionary.*;
import com.app.toyRobot.util.*;
import com.app.toyRobot.exception.RobotGameException;
/**
 * Singleton class representing the game to execute the commands on the Robot.This class interprets the command and invokes the relavent
 * 
 * @author sirisha
 *
 */
public class RobotGame {

    TableTop tableTop;

    Robot robot;

    private static  RobotGame robotGame;

    private  RobotGame()
    {

    }
    public static RobotGame getInstance(){
        if(robotGame == null){
            robotGame = new RobotGame();
        }
        return robotGame;
    }

    public void initialiseGame(TableTop tabletop)
    {
        this.tableTop =tabletop;
    }
    /**
     * Method checks for a PLACE command to process for every other command it ensures the robot has been
     * moved onto the board
     * returns relevant error message or success 
     * @param command
     * @return
     */
    public String processCommand (String command)
    {
     try{
    	 String commandResult ="Executed";
    	 if(command.toUpperCase().startsWith(Commands.PLACE.name())){
    		 robot=  processPlaceCommand(command.toUpperCase());
    		 return commandResult;
    	 }
    	if(isRobotOnTable()==false)
         {
                return Constants.ROBOT_NOT_INITIALISED;
         }
    	 
    	 switch(command.toUpperCase())
    	 {
    	 case "MOVE":
    		 robot.moveForward(tableTop);
    		 break;
    	 case "LEFT":
    		 commandResult= robot.moveLeft();
    		 break;	
    	 case "RIGHT":
    		 commandResult= robot.moveRight();
    		 break;
    	 case "REPORT":
    		 commandResult = robot.reportPosition();
    		 break;
    	 default :
    		 throw new RobotGameException(Constants.INVALID_COMMAND);
    	 }
        
    	 return commandResult;

        }
        catch(RobotGameException ex)
        {
            return ex.getMessage();
        }
    }
    private Robot processPlaceCommand(String command)
    {
        String positionInformation = command.replace(Commands.PLACE.name(),"");
        String[] coordinateValues = positionInformation.split(",");

        if(coordinateValues.length <3 )
        {
            throw new RobotGameException(Constants.INVALID_COMMAND);
        }
        return placeRobot(coordinateValues[0].trim(), coordinateValues[1].trim(), coordinateValues[2].trim());
    }

    private Robot placeRobot(String x,String y, String face)
    {
        Coordinates coordinates = new Coordinates(x,y);
        Direction moveDirection = Direction.getValueByNameOrShortCode(face);
        
        if(moveDirection ==null)
        {
        	throw new RobotGameException(Constants.INVALID_DIRECTION);
        }
        
        if(tableTop.isPositionOnTable(coordinates) ==false)
        {
                throw new RobotGameException(Constants.INVALID_POSITION);
         }

        robot = Robot.getInstance(coordinates,moveDirection);
        
        return robot;
   }

    private boolean isRobotOnTable()
    {
        if(robot !=null)
            return true;

        return false;
    }

    private boolean isPositionValid(int xCoordinate , int yCoordinate , String moveDirection)
    {

    return false;

    }
	

}
