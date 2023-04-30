# Programming2Project
# 2D Array Maze


Project Scope:
Using a 2D array to create a maze for the user in the console. The user can then navigate the maze to find a target
and create a GUI compontent to the program. 

Program Instructions:
Console version: Naivgate the 2d maze trying to reach the end of the maze (E) using the 
(U)p, (D)own, (L)eft, (R)ight keys moving through the maze forwards or backwards
if you reach a dead end. Try to reach the end of the maze for a special message. 

GUI version: Press the Generate maze to generate a random 2d maze array and 
then press the Solve Maze button to have the computer solve it. Don't worry if no
path is found the computer will tell you.

*Known Issues*
---------------
TextArea will NOT refresh until a loop is completed. This is the reason in the GUI portion of 
the program the computer is used to solve the maze instead of user transveral. 
Possible soulution to problem is taking a multithread approach and run the while loop in a 
seperate thread to allow for updates while the loop is in progress. However, this is beyond the 
scope of this class. 

*Side note --- > Multithreading was attempted but after several hours could not get it to work. 



Members
------------------
Riley Combs <br /> 
Dwayne Roark <br />
Rhett Godwin

Dwayne is going to be creating the class Maze. Created a stub for the class and added constructors, getters, and setters.


Rhett is going to be creating the class MazeSolver. 
Rhett created the following classes in support of the gui and solverportion of the program:

MainGUI ---> Main component that starts the GUI

MazeArrays ---> Array class to support the maze solver with mazes in correct format

MazeController ---> Handles all GUI components (buttons, event handling, supported automatic transveral to solve maze within solve button

MazeMainConsole ---> Starts the console portion of the program that allows for manual transveral of the maze based on user input

MazeSolver -----> code that allows for manual transveral of the maze with wall detection and start/win mechanics.

MazeSolverGUI ----> created as a reference for the automatic solve function in GUI (code merged into MazeController class) 

MazeXML ----> Handles the layout of the GUI, button, and text area placement



Riley is going to be creating the class MazeMain. Created a stub for the class and added a constructor and scanner.


Dwayne did some research and found some examples of how to create mazes using a grid-based system. Started creating Maze class using a grid-based system.
