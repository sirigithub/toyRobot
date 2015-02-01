package com.app.toyRobot.simulator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.app.toyRobot.exception.RobotGameException;
import com.app.toyRobot.game.RobotGame;
import com.app.toyRobot.model.TableTop;

/**
 * Class invokes the robot game by creating a table space.The class accepts commands from the command prompt
 * and passes them to the robot game to act on them until the EXIT command is received.
 * 
 * @author sirisha
 *
 */
public class ToyRobotSimulator {

    public static  void main(String[] args)
    {
        TableTop tableTop = new TableTop(0,0,5,5);
        RobotGame robotGame = RobotGame.getInstance();
        robotGame.initialiseGame(tableTop);

        System.out.println("Toy Robot Simulator");
        System.out.println("Enter a command, Valid commands are:");
        System.out.println("PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT or EXIT");


        try {
            while(true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String command = reader.readLine();
                if ("EXIT".equals(command)) {
                    break;
                } else {
                	String returnValue= robotGame.processCommand(command);
                    System.out.println(returnValue);
                }
            }

        } catch (RobotGameException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println("GOOD BYE!!");
    }
}

