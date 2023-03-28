package classMaze;

import java.util.Scanner;

public class MazeMain {
    
    // Attributes
    int rows, columns;
    int expected = 60;
    MazeSolver mazeSolver = new MazeSolver();
    
    // Discuss if limit to size should be implemented
    public void mazeSize(int rows, int columns, int expected) {
        if (rows  <= 0 && rows >= expected)
        {
            System.out.println("Please input integer between 0-60.");
        }
        else if (columns  <= 0 && columns >= expected)
        {
                System.out.println("Please input integer between 0-60.");
        }
        else
        {
            this.mazeSolver; // If width and height are >0 & <60 call mazeSolver; will need to update
        }
   }
    
    
    // Takes user input for maze size
    // Discussed improvement of turning into GUI
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter width:");
        String columns = scan.nextLine();
        System.out.println("Enter height:");
        String rows = scan.nextLine();
    }
}