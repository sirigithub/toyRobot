package com.app.toyRobot.exception;
/**
 * 
 * @author sirisha
 *
 */
public class RobotGameException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RobotGameException()
	{
		super();
	}
	
	public RobotGameException(String exceptionMessage)
	{
		super(exceptionMessage);
		
	}
	public RobotGameException(String exceptionMessage, Exception e)
	{
		super(exceptionMessage,e);
		
	}

}
