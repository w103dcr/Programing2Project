//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin

//*****MazeMainConsole FINAL BUILD******
//* Main Start Method for the console  *
//* program to transverse a 2d maze    *
//* with wall detection, backtracking  *
//* and win conditions                 *
//**************************************





public class MazeMainConsole
{

    public static void main(String[] args) throws InterruptedException
    {
        //create maze object for MazeArrays class
        MazeArrays maze = new MazeArrays();
        //create maze object for MazeSolver class
        MazeSolver Solver = new MazeSolver();
        //creates char arrray for the arrays class based on 
        //a random variable of 1-10
        char test[][] = maze.returnArray(maze.randomGen());
        //prints the retrived array using a method from the MazeSolver
        Solver.printArray(test);
        //runs the move function which transverses the array will wall detection and start/win mechanics
        Solver.move(test, 0, 0);
     
       

}
}
