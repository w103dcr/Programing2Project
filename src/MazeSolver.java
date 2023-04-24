//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin
//************ALPHA BUILD .085****************
//*     NOT IN 100% WORKING STATE           *
//      TRANSVERSE METHOD WORKS BUT         *
//      DOESNT DISPLAY RIGHT                *
// CHANGELOG:                               *
// .05-------------------                   *
// REWORKED CODE TO ALLOW FOR METHODS TO    *
// TO BE CALLED FROM MAIN WITHOUT PASSING   *
// ARRAYS                                   *
//.06--------------------                   *
// ADDED MANUAL MOVE() METHOD TO TRANSVERSE *
// THE MAZE MANUALLY (NOT WORKING CORRECTLY)*
//.07---------------------                  *
// UPDATES THE MAZE VISUALLY AS YOU MOVE    *
// THROUGH IT. (WALLS ARENT DETECTING YET   *
//.08---------------------                  *
// WALL DETECTION ADDED TO CODE             *
//.08.1                                     *
// REMOVED AUTO SOLVE CODE (KEEP MANUAL CODE*
// STREAMLINED SOME CODE   
// .085
// WIN CONDITIONS ADDED
//TODO--------------------------------------*
//BACKTRACKING DETECTION                    *
//                                          *
//*******************************************

package projectmazetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazeSolver
{

    public static void move(char[][] maze, int row, int column)
    {
        Scanner scan = new Scanner(System.in);

        // Initialize set to keep track of locations to prevent backtracking
       

 

        // while Q is not pressed ask direction
        while (true)
        {
            System.out.println("Enter the direction you wish to go (U)p, (D)own, (L)eft, (R)ight");
            System.out.println("Or Q to quit");
            String input = scan.next();

            if (input.equalsIgnoreCase("q"))
            {
                break;

            }

            // up if desired location is not a 1 move to location
            if (input.equalsIgnoreCase("u") && maze[row][column] != 1 )
            {

                if (maze[row - 1][column] != 1)
                {
                    if (maze[row][column +1 ] == 2) {
                    youWin();
                    break;
                }
                    System.out.println("Moving to position");

                    maze[row - 1][column] = '*';
                    row--;

                    printArray(maze);
                } else
                {
                    wallDetected();
                }
            }

            // down if desired location is not a 1 move to location
            else if (input.equalsIgnoreCase("d") && maze[row][column] != 1)
            {
                if (maze[row + 1][column] != 1)
                {
                    if (maze[row][column +1 ] == 2) {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");
                    maze[row + 1][column] = '*';
                    row++;
                    printArray(maze);
                } else
                {
                    wallDetected();
                }

                // right if desired location is not a 1 move to location
            } else if (input.equalsIgnoreCase("r") && maze[row][column] != 1)
            {
                if ( maze[row][column + 1] != 1)
                {
                  if (maze[row][column +1 ] == 2) {
                      youWin();
                      break;
                  }
                    System.out.println("Moving to position");
                    maze[row][column + 1] = '*';
                    column++;
                    printArray(maze);
                 
                
                  
                  
                } else
                {
                    wallDetected();
                }

                // left if desired location is not a 1
            } else if (input.equalsIgnoreCase("l") && maze[row][column] != 1)
            {
                if (maze[row][column - 1] != 1)
                { 
                    if (maze[row][column +1 ] == 2) {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");
                    maze[row][column - 1] = '*';
                    column--;
                    printArray(maze);
                } else
                {
                    wallDetected();

                }
            } else
            {
                System.out.println("invalid input or Backtracking attempted. Choose another direction");
            }
        }

    }

    public static void printArray(char[][] maze)
    {
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                if (maze[i][j] == 1)
                {
                    System.out.print("#");
                }
                if (maze[i][j] == 0)
                {
                    System.out.print(".");
                }
                if (maze[i][j] == '*')
                {
                    System.out.print("X");
                }
                if (maze[i][j] == 2)
                {
                    System.out.print("E");
                }
                if (maze[i][j] == 4)
                {
                    System.out.print("S");
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void wallDetected()
    {
        System.out.println("Wall Detected!!!! Please choose another direction");
    }
public static void youWin() {
    String s ="   ▄▄   ▄▄ ▄▄▄▄▄▄▄ ▄▄   ▄▄    ▄     ▄ ▄▄▄ ▄▄    ▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \n"
             +"  █  █ █  █       █  █ █  █  █ █ ▄ █ █   █  █  █ █  █  █  █  █  █  █  █  \n"
             +"  █  █▄█  █   ▄   █  █ █  █  █ ██ ██ █   █   █▄█ █  █  █  █  █  █  █  █ \n"
             +"  █       █  █ █  █  █▄█  █  █       █   █       █  █  █  █  █  █  █  █  \n"
             +"  █▄     ▄█  █▄█  █       █  █       █   █  ▄    █▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█  \n"
             +"    █   █ █       █       █  █   ▄   █   █ █ █   █▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄   \n"
             +"    █▄▄▄█ █▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█  █▄▄█ █▄▄█▄▄▄█▄█  █▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█  \n";
    System.out.println(s);

    }
}
