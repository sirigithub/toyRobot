package com.app.toyRobot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert.*;

import com.app.toyRobot.dictionary.Commands;
import com.app.toyRobot.dictionary.Direction;
import com.app.toyRobot.exception.RobotGameException;
import com.app.toyRobot.game.RobotGame;
import com.app.toyRobot.model.TableTop;
import com.app.toyRobot.util.Constants;


public class RobotCommandsTest {
	
	private TableTop tableTop;
    RobotGame robotGame ;

	
	@Before
	public void setUp()
	{
		tableTop = new TableTop(0,0,5,5);
		robotGame= RobotGame.getInstance();
		robotGame.initialiseGame(tableTop);				
	}
	
	@Test
	public void testValidPlaceCommand()
	{
		String command ="PLACE 1,1,N";
		String result =robotGame.processCommand(command);
		assertEquals("Executed",result);
		
	}
	@Test
	public void testInValidPlaceCommandThrowsException() throws RobotGameException
	{
		String command ="PLACE 1,1";
		String result =robotGame.processCommand(command);
	}
	
	@Test
	public void testPlaceOutOfBoardCoordinatesThrowsException() throws RobotGameException
	{
		String command ="PLACE 15,10,N";
		String result =robotGame.processCommand(command);
	}
	
	@Test
	public void testInValidCommandThrowsException() 
	{
		String command ="abcdef";
		String result =robotGame.processCommand(command);
	}
	
	@Test
	public void testProcessInvalidMoveCommand() throws RobotGameException
	{
		String command ="MOVE";
		String result =robotGame.processCommand(command);
		
	}
	@Test
	public void testMoveCommandProcessed()
	{
		ArrayList<String> commands = new ArrayList();
		robotGame.processCommand("PLACE 1,2,EAST");
		robotGame.processCommand("MOVE");
		robotGame.processCommand("MOVE");
		String result =robotGame.processCommand("REPORT");
		
        assertEquals("3,2 EAST",result);
		
	}
	
	@Test
	public void testMoveCommandIgnored()
	{
		ArrayList<String> commands = new ArrayList();
		
        robotGame.processCommand("PLACE 0,0,SOUTH");
		robotGame.processCommand("MOVE");
		robotGame.processCommand("MOVE");
		String result =robotGame.processCommand("REPORT");
        assertEquals("0,0 SOUTH",result);
		
	}
	/**
	 * Test to ensure direction of the robot is still the same on MOVE
	 */
	@Test
	public void testDirectionOnMoveCommand()
	{
		ArrayList<String> commands = new ArrayList();
		
		commands.add("PLACE 0,0,EAST");
        commands.add("MOVE");
        commands.add("REPORT");
	
        String result ="";
        for(String command: commands)
        {
       	 result =robotGame.processCommand(command);
        }
       
        String directionValue = result.substring(4);
        assertEquals(directionValue.trim(),"EAST");
		
	}
	@Test
	public void testTurnLeftCommand()
	{
		robotGame.processCommand("PLACE 1,1,NORTH");
		assertEquals(robotGame.processCommand(Commands.LEFT.name()),Constants.MSG_TURNED_LEFT);
		String position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.WEST.name());
		assertEquals(robotGame.processCommand(Commands.LEFT.name()),Constants.MSG_TURNED_LEFT);
		position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.SOUTH.name());
		assertEquals(robotGame.processCommand(Commands.LEFT.name()),Constants.MSG_TURNED_LEFT);
		position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.EAST.name());
		
	}
	@Test
	public void testTurnRightCommand()
	{
		robotGame.processCommand("PLACE 0,0,NORTH");
		assertEquals(robotGame.processCommand(Commands.RIGHT.name()),Constants.MSG_TURNED_RIGHT);
		String position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.EAST.name());
		assertEquals(robotGame.processCommand(Commands.RIGHT.name()),Constants.MSG_TURNED_RIGHT);
		position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.SOUTH.name());
		assertEquals(robotGame.processCommand(Commands.RIGHT.name()),Constants.MSG_TURNED_RIGHT);
		position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals(position.substring(4).trim(),Direction.WEST.name());
		
	}
	
	@Test
	public void testProcessInvalidLeftCommand() throws RobotGameException
	{
		String command ="LEFT";
		String result =robotGame.processCommand(command);
		
	}
	
	@Test
	public void testProcessInvalidRightCommand() throws RobotGameException
	{
		String command ="RIGHT";
		String result =robotGame.processCommand(command);
		
	}
	@Test
	public void testReportCommand()
	{
		robotGame.processCommand("PLACE 4,3,NORTH");
		robotGame.processCommand(Commands.MOVE.name());
		String position = robotGame.processCommand(Commands.REPORT.name());
		assertEquals("4,4 NORTH",position);	
		
	}
	
	@Test
	public void testProcessInvalidReportCommand() throws RobotGameException
	{
		String command ="REPORT";
		String result =robotGame.processCommand(command);
		
	}
	
}
