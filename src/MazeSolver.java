//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin

//******RELEASE CANDIDATE 1 BUILD************
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
// STREAMLINED SOME CODE                    *
// .085                                     *
// WIN CONDITIONS ADDED                     *
// .095                                     *
// CODE TO ALLOW USER TO MOVE THROUGH THE   *
// MAZE WITH BACKTRACKING                   *
//TODO--------------------------------------*
//MIGHT HAVE TO CHANGE SOME OUTPUT METHODS  *
//FOR GUI                                   *
//*******************************************

package projectmazetest;

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
            if (input.equalsIgnoreCase("u") && row > 0 && maze[row][column] != 1)
            {

                if (maze[row - 1][column] != 1)
                { // win condition if the number 2 is hit in the array
                  // call the youWin method and closes the program
                    if (maze[row][column + 1] == 2)
                    {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");

                    // allows for backtracking in the maze
                    if (maze[row][column] == '*')
                    {
                        maze[row][column] = 0;
                    }
                    // if allowed moved to position and set with a '*' to show position in maze
                    maze[row - 1][column] = '*';
                    row--;
                    // called the printArray method to print the maze array
                    printArray(maze);
                } else
                {
                    // if a 1 is detected call wall detected method
                    wallDetected();
                }
            }

            // down if desired location is not a 1 move to location
            else if (input.equalsIgnoreCase("d") && row < maze.length && maze[row][column] != 1)
            {
                if (maze[row + 1][column] != 1)
                {
                    // win condition if the number 2 is hit in the array
                    // calls the youWin method and closes the program
                    if (maze[row][column + 1] == 2)
                    {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");

                    // allows for backtracking in the maze
                    if (maze[row][column] == '*')
                    {
                        maze[row][column] = 0;
                    }

                    // if allowed move to position and set with a * to show position in maze and
                    // prints Array
                    maze[row + 1][column] = '*';
                    row++;
                    printArray(maze);
                } else
                {
                    // if a 1 is detected call wall detected method
                    wallDetected();
                }

                // right if desired location is not a 1 move to location
            } else if (input.equalsIgnoreCase("r") && column < maze.length && maze[row][column] != 1)
            {
                if (maze[row][column + 1] != 1)
                {
                    // win condition if the number 2 is hit in the array
                    // call the youWin method and closes the program
                    if (maze[row][column + 1] == 2)
                    {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");

                    // allows for backtracking in the maze
                    if (maze[row][column] == '*')
                    {
                        maze[row][column] = 0;
                    }

                    // if allowed more to position and set with a * to show position in the maze and
                    // prints the array
                    maze[row][column + 1] = '*';
                    column++;
                    printArray(maze);

                } else
                {
                    // if a 1 is detected call wall dectected method
                    wallDetected();
                }

                // left if desired location is not a 1
            } else if (input.equalsIgnoreCase("l") && column > 0 && maze[row][column] != 1)
            {
                if (maze[row][column - 1] != 1)
                {
                    // win condition if the number 2 is hit in the array
                    // call the youWin method and closes the program
                    if (maze[row][column + 1] == 2)
                    {
                        youWin();
                        break;
                    }
                    System.out.println("Moving to position");
                    // allows for backtracking in the maze
                    if (maze[row][column] == '*')
                    {
                        maze[row][column] = 0;
                    }

                    // if allowed more to position and set with a * to show position in the maze and
                    // prints the array
                    maze[row][column - 1] = '*';
                    column--;
                    printArray(maze);
                } else
                {
                    // if a 1 is detected call wall detected method
                    wallDetected();

                }

            }
        }

    }

    // print array method that prints an array of input char[][] array
    // and converts 1's to #, 0 to '.', Asterix to X, 2 to E and 4 to S
    public static void printArray(char[][] maze)
    {

        System.out.flush();

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

    // wall detected print method
    public static void wallDetected()
    {
        System.out.println("Wall Detected!!!! Please choose another direction");
    }

    // You win method to display you win in ASCII graphics
    public static void youWin()
    {
        String s = "   ▄▄   ▄▄ ▄▄▄▄▄▄▄ ▄▄   ▄▄    ▄     ▄ ▄▄▄ ▄▄    ▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ \n"
                + "  █  █ █  █       █  █ █  █  █ █ ▄ █ █   █  █  █ █  █  █  █  █  █  █  █  \n"
                + "  █  █▄█  █   ▄   █  █ █  █  █ ██ ██ █   █   █▄█ █  █  █  █  █  █  █  █ \n"
                + "  █       █  █ █  █  █▄█  █  █       █   █       █  █  █  █  █  █  █  █  \n"
                + "  █▄     ▄█  █▄█  █       █  █       █   █  ▄    █▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█  \n"
                + "    █   █ █       █       █  █   ▄   █   █ █ █   █▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄ ▄▄   \n"
                + "    █▄▄▄█ █▄▄▄▄▄▄▄█▄▄▄▄▄▄▄█  █▄▄█ █▄▄█▄▄▄█▄█  █▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█▄▄█  \n";
        System.out.println(s);

    }

}
