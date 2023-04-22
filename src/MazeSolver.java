//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin
//************ALPHA BUILD 0.5****************
//*     NOT IN 100% WORKING STATE           *
//      TRANSVERSE METHOD WORKS BUT         *
//      DOESNT DISPLAY RIGHT                *
// CHANGELOG:                               *
// REWORKED CODE TO ALLOW FOR METHODS TO    *
// TO BE CALLED FROM MAIN WITHOUT PASSING   *
// ARRAYS                                   *
//*******************************************

package projectmazetest;

import java.util.Arrays;

public class MazeSolver
{

//check if a given cell in the maze is valid (within bounds and a '.' character)
    public static boolean isValidSpot(char[][] maze, int row, int column)
    {
        if (row >= 0 && row < maze.length && column >= 0 && column < maze.length)
        {
            return maze[row][column] == '.';

        }
        return false;
    }

    // Transverse the maze using recursion and mark visited cells with an X
    // character
    public static boolean traverseMaze(char[][] maze, int row, int column)
    {
        if (isValidSpot(maze, row, column))
        {
            if (row == maze.length - 1 && column == maze.length - 1)
            {
                return true;
            }

            // marks the current cell as visited
            maze[row][column] = 'X';

            // up
            boolean returnValue = traverseMaze(maze, row - 1, column);

            // right
            if (!returnValue)
            {
                returnValue = traverseMaze(maze, row, column + 1);

                // down
                if (!returnValue)
                {
                    returnValue = traverseMaze(maze, row + 1, column);
                }

                // left
                if (!returnValue)
                {
                    returnValue = traverseMaze(maze, row, column - 1);

                    if (returnValue)
                    {

                        // if this path leads to the end of the maze, mark the path with dots
                        System.out.print(row + ", " + column);
                        maze[row][column] = '.';
                    }
                    return returnValue;
                }

            }

        }
        return false;
    }

    // prints the final state of the maze with the solution path marked with dots
    public static void printSolution(char[][] maze)
    {
        System.out.println("Solution to maze\n----------------");
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[j].length - 1; j++)
            {
                System.out.print(maze[i][j] + " ");
                if (maze[i][j] == '.')
                {
                    System.out.print(".");
                }

            }
            System.out.println("|");

        }
        System.out.println("--------------");
    }
}
