// Class Maze2, C211 Group Project Spring 2023
// Author: Dwayne Roark

 // Importing Utilities
 import java.util.Scanner;
 import java.util.Random;
 import java.util.Arrays;
 
public class Maze2 {

     // Creating Instance Attributes
     int[][] maze;
     int rows, columns;
     static Scanner scan = new Scanner(System.in);
     static Random rand = new Random();

     // Default Constructor
     public Maze2() {
         rows = 0;
         columns = 0;
     }

     // Non-Default Constructor
     public Maze2(int m, int n) {
         init(m, n);
     }

     // Initializes the Maze With These Numbers of Rows and Columns
     public void init(int m, int n) {
         if (m > 0 && n > 0) {
             maze = new int[m][n];
             rows = m;
             columns = n;
         }
     }

     // Generates Random Values of 1 In the Maze Based on the
     // Percent Parameter
     public void randomize(float percent) {
         int i, j;
         float r;
         for (i = 0; i < rows; i++)
             for (j = 0; j < columns; j++) {
                 r = rand.nextFloat();
                 if (r <= percent)
                     maze[i][j] = 1;
             }
     }

     // Formats the Maze to a Easier to Read Format
     public void output() {
         System.out.print("+");
         for (int i = 0; i <= maze.length - 1; i++) {
             System.out.print("--");
         }
         System.out.println("+");
         for (int i = 0; i < rows; i++) {
             System.out.print("|");
             for (int j = 0; j < columns; j++) {
                 if (maze[i][j] == 0) {
                     System.out.print("  ");
                 }
                 if (maze[i][j] == 1) {
                     System.out.print("* ");
                 }
                 if (maze[i][j] == 2) {
                     System.out.print(". ");
                 }
             }
             System.out.println("|");
         }
         System.out.print("+");
         for (int i = 0; i <= maze.length - 1; i++) {
             System.out.print("--");
         }
         System.out.println("+");
     }

     // Main Method
     public static void main(String[] args) {

         // Establishing Instance Variables
         int n;
         Maze2 board = new Maze2();

         // Prompt User for Table Size
         System.out.println("Enter the dimention of the table");

         // Setting n to User Input
         n = scan.nextInt();

         // Setting Table Dimensions to n
         board.init(n, n);

         // Using p to Set Ones on Board
         board.randomize((float) .5);

         // Convert Board to Easy to Read Format
         board.output();
     }
 }