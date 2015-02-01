package com.app.toyRobot.dictionary;

public enum Direction {
	
	NORTH("N"),SOUTH("S"),EAST("E"),WEST("W");
	
	private String shortName;
	
	private Direction(String shortName)
	{
		this.shortName =shortName;	
	}
	public String getShortName()
	{
		return this.shortName;
	}

}
