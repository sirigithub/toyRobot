package com.app.toyRobot.dictionary;

public enum Commands {
	
	PLACE("place"),MOVE("move"),LEFT("left"),RIGHT("right"),REPORT("report");
	
	private String description;
	
	private Commands(String description)
	{
		this.description=description;
	}
	public String getDescription()
	{
		return this.description;
	}
	
	public static Commands getValueByName(String command)
	{
		if(command!=null){
			for(Commands value : Commands.values())
			{
				if(command.equalsIgnoreCase(value.name()) || command.equalsIgnoreCase(value.description))
				{
					return value;
				}
			}
			
		}
		return null;
	}

}
