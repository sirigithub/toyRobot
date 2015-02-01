package com.app.toyRobot;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert.*;

import com.app.toyRobot.game.*;
import com.app.toyRobot.model.Coordinates;
import com.app.toyRobot.model.TableTop;

public class TableTopTest {
	private TableTop table ;
	
	@Before
	public void setUp()
	{
	 table = new TableTop(0,0,5,5);
	}
	
	@Test
	public void testCoordinatesOutsideTableReturnsFalse()
	{
		
		Coordinates coordinate = new Coordinates(6,0);
		assertEquals(false,table.isPositionOnTable(coordinate));
		
	}
	@Test
	public void testNegativeCoordinatesReturnsFalse()
	{		
		Coordinates coordinate = new Coordinates(-1,-1);
		assertEquals(false,table.isPositionOnTable(coordinate));	
	}
	@Test
	public void testValidCoordinatesReturnsTrue()
	{		
		Coordinates coordinate = new Coordinates(4,3);
		assertEquals(true,table.isPositionOnTable(coordinate));	
	}
	

}
