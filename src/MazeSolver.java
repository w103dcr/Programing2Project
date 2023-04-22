//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin
//************ALPHA BUILD 0.3****************
//*     NOT IN 100% WORKING STATE           *
//*******************************************

package projectmazetest;

import java.util.Arrays;

public class MazeSolver
{
    Maze maze = new Maze();
    char[][] mazeTest = maze.returnArray();

    public void solveMaze(int x, int y)
    {

        // check to see if we reached the end of the maze
        if (x == mazeTest.length - 1 && y == mazeTest[0].length - 1)
        {

            // marks the end of the maze with an E
            mazeTest[x][y] = 'E';
            return;
        }

        // check if the current cell is a wall or has been visited
        if (mazeTest[x][y] == '1' || mazeTest[x][y] == '*')
        {
            return;
        }

//marks the current cell as visited

        System.out.println(Arrays.deepToString(mazeTest));
        if (x >= 0 && x < mazeTest.length && y >= 0 && y < mazeTest.length)
        {
            mazeTest[x][y] = '*';

        }
        // Use recursion to explore each cell

        // left
        if (x > 0)
        {
            solveMaze(x - 1, y);
        }

        // up
        if (y > 0)
        {
            solveMaze(x, y - 1);
        }

        // right
        if (x < mazeTest.length - 1)
        {
            solveMaze(x + 1, y);
        }

        // down
        if (y < mazeTest.length - 1)
        {
            solveMaze(x, y + 1);
        }
    }

    public char[][] returnArray()
    {
        return mazeTest;
    }

}



