# toyRobot
ToyRobot Simulator
-----------------------
This project simulates a toy robot moving in a predefined square tabletop of 5 units/5 units with 0,0 as the start coordinates. The simulator program initialises the robot on the tabletop when it receives a PLACE X,Y,F command where X and Y are valid coordinates and F is the direction to which the robot will face. Other valid commands are MOVE, LEFT,RIGHT and REPORT. Other valid commands are ignored until the time a valid PLACE command is received.

System Requirements
---------------------
The program requires java runtime 1.7 or above to run. It needs Maven version 2 or above to compile the source.

Download and Run 
--------------------------
Download source code from https://github.com/sirigithub/toyRobot
To run the program, bring up command prompt and navigate to the target directory containing the executable (e.g. cd "location on the drive"\toyRobot-master\target).

java -jar toyRobot-0.0.1-SNAPSHOT-jar-with-dependencies

The program executes until it receives  a EXIT command(case sensitive).

Compile
--------
To compile the source , please move to the location of the install.

cd "location on the drive"\toyRobot-master.

mvn clean install

This command cleans, compiles runs the tests and creates an executable jar file toyRobot-0.0.1-SNAPSHOT-jar-with-dependencies.

Test
-----
The tests can be run using the mvn test command.These junit tests use some static test data.

Example Input/Output
-----------------------
Enter a command, Valid commands are:
PLACE X,Y,NORTH|SOUTH|EAST|WEST, MOVE, LEFT, RIGHT, REPORT or EXIT
MOVE
The Robot has not been placed on the board. Ignoring command
PLACE 0,0,NORTH

Executed

MOVE

Executed

REPORT

0,1 NORTH

LEFT

Turned Left

REPORT

0,1 WEST

EXIT!

The command is invalid

EXIT

GOOD BYE!!

Expected Messages :
--------------------
A command is not among PLACE,MOVE,LEFT,RIGHT,REPORT or EXIT : The command is invalid

The command tries to place or move the robot outside the 0,0,5,5 coordinates :The position of the robot is not valid as it is outside the board

The robot has not been placed on the board: The Robot has not been placed on the board. Ignoring command.

The direction is not NORTH,SOUTH,EAST or WEST :The direction is invalid.Please choose among NORTH,SOUTH,EASt,WEST.

Turning LEFT or RIGHT brings up : Turned Left,Turned Right

Succesful move brings up : Executed.







