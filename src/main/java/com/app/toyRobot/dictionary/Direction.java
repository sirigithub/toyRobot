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
	/**
	 * Method tries to match a given direction by name or short name eg North,NORTH or N
	 * returns null f no match is found 
	 * @param direction
	 * @return
	 */
	public static Direction getValueByNameOrShortCode(String direction)
	{
		if(direction!=null){
			for(Direction value : Direction.values())
			{
				if(direction.equalsIgnoreCase(value.name()) || direction.equalsIgnoreCase(value.shortName))
				{
					return value;
				}
			}
			
		}
		return null;
	}
	


}
