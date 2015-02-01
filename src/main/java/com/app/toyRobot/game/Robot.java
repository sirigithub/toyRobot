package com.app.toyRobot.game;
import com.app.toyRobot.model.Coordinates;
import com.app.toyRobot.model.TableTop;
import com.app.toyRobot.dictionary.*;
import com.app.toyRobot.util.*;
import com.app.toyRobot.exception.RobotGameException;
/**
 * Class representing a single robot instance.
 * @author sirisha
 *
 */
public class Robot implements RobotCommands {
    private Coordinates coordinates;

    Direction moveDirection;

    private static Robot robotInstance;

    private Robot( Coordinates coordinates, Direction moveDirection)
    {
        this.coordinates =coordinates;
        this.moveDirection = moveDirection;

    }

    public static Robot getInstance(Coordinates position, Direction moveDirection){
        if(robotInstance == null){
            robotInstance = new Robot(position,moveDirection);
            return robotInstance;
        }
        robotInstance.coordinates = position;
        robotInstance.moveDirection =moveDirection;

        return robotInstance;
    }


    public void setRobotPosition(String row, String column ,String faceDirection){

        Coordinates coordinates = new Coordinates(Integer.valueOf(row).intValue(),Integer.valueOf(column).intValue());
        moveDirection = Direction.valueOf(faceDirection.toUpperCase());

    }

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    public String getMoveDirection()
    {
        return this.moveDirection.name();
    }

    public void assignCoordinates(int x,int y, String faceDirection)
    {
        Coordinates coordinates = new Coordinates(x,y);
        moveDirection = Direction.valueOf(faceDirection.toUpperCase());

    }
    public void moveForward(TableTop tableCoordinates){
        int newYAxisPosition=0;
        int newXAxisPosition=0;
        Coordinates newCoordinates =null;

        switch (moveDirection) {
            case NORTH:
                newYAxisPosition = coordinates.getYAxisCoordinate()+1;
                newCoordinates = new Coordinates(this.coordinates.getXAxisCoordinate(),newYAxisPosition);

                if(tableCoordinates.isPositionOnTable(newCoordinates)==false)
                {
                    throw new RobotGameException(Constants.INVALID_POSITION);
                }
                coordinates =newCoordinates;
                break;
            case SOUTH:
                newYAxisPosition = coordinates.getYAxisCoordinate() -1;
                newCoordinates = new Coordinates(this.coordinates.getXAxisCoordinate(),newYAxisPosition);

                if(tableCoordinates.isPositionOnTable(newCoordinates)==false)
                {
                    throw new RobotGameException(Constants.INVALID_POSITION);
                }
                coordinates =newCoordinates;
                break;
            case EAST:
                newXAxisPosition = coordinates.getXAxisCoordinate()+1;
                newCoordinates = new Coordinates(newXAxisPosition,this.coordinates.getYAxisCoordinate());

                if(tableCoordinates.isPositionOnTable(newCoordinates)==false)
                {
                    throw new RobotGameException(Constants.INVALID_POSITION);
                }
                coordinates = newCoordinates;
                break;
            case WEST:
                newXAxisPosition = coordinates.getXAxisCoordinate()-1;
                newCoordinates = new Coordinates(newXAxisPosition,this.coordinates.getYAxisCoordinate());

                if(tableCoordinates.isPositionOnTable(newCoordinates)==false)
                {
                    throw new RobotGameException(Constants.INVALID_POSITION);
                }
                coordinates = newCoordinates;
                break;
        }

    }
    public  String moveLeft(){

        switch (moveDirection) {
            case NORTH:
                moveDirection = Direction.WEST;
                break;
            case SOUTH:
                moveDirection = Direction.EAST;
                break;
            case EAST:
                moveDirection = Direction.NORTH;
                break;
            case WEST:
                moveDirection = Direction.SOUTH;
                break;
        }
        return Constants.MSG_TURNED_LEFT;

    }
    public  String moveRight(){

        switch (moveDirection) {
            case NORTH:
                moveDirection = Direction.EAST;
                break;
            case SOUTH:
                moveDirection = Direction.WEST;
                break;
            case EAST:
                moveDirection = Direction.SOUTH;
                break;
            case WEST:
                moveDirection = Direction.NORTH;
                break;
        }
        return Constants.MSG_TURNED_RIGHT;

    }
    public String reportPosition() throws RobotGameException{


        return (coordinates.getXAxisCoordinate()+","+coordinates.getYAxisCoordinate()+" "+moveDirection.name());
    }

    public boolean isRobotPositioned()
    {
        return (coordinates!=null?true:false);
    }




}