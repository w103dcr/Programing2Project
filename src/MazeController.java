//Class MazeArrays, C211 Group Project Spring 2023
//Author: Rhett Godwin

//****Maze Controller FINAL BUILD*******
//Provides buttons and events for GUI  *
//**************************************


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.PrintStream;
import java.time.format.TextStyle;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.io.IOException;
import java.io.OutputStream;

public class MazeController
{
    
    //object create object maze
    MazeArrays maze = new MazeArrays();

   
    int arrNum;
    int ranNum;
   

    @FXML
    //create textArea txtOutput
    TextArea txtOutput;

  

    public MazeController() {

    }

    @FXML
    //Button Generate for gui. That calls return array function in
    //array with a random number. and calls that array
    public void btnGen(ActionEvent e) throws InterruptedException
    {   
        
        ranNum = maze.randomGen();
        arrNum = ranNum;
        char test[][] = maze.returnArray(arrNum);
        String mazeString = getArrayString(test);
  
        txtOutput.clear();
        System.out.print(mazeString);
        txtOutput.appendText(mazeString);

    }

    @FXML
    //button solve for gui
    public void btnSolve(ActionEvent e)
    {

        char test[][] = maze.returnArray(arrNum);

        move(test, 0, 0);

    }

    @FXML

    //Exit buttons
    public void Exit(ActionEvent e)
    {
        System.exit(0);
    }

   

// Starting Maze Solver functions

    public void move(char[][] maze, int row, int column)
    {

// use a stack to keep track of the path
        Stack<int[]> path = new Stack<>();
        path.push(new int[]
        { row, column });

//code for automatic transition of maze 
//**Could not get manual transition to update** 
//**textarea while in a while loop**
//**Switched to automatic transversal to solve**
        while (!path.isEmpty())
        {
            // get the current position
            int[] pos = path.pop();
            row = pos[0];
            column = pos[1];

            // check if we've reached the goal
            if (maze[row][column] == 2)
            {
                txtOutput.clear();
                txtOutput.appendText(getArrayString(maze));
                return;
            }

            // mark the current position as visited
            maze[row][column] = '*';

            // try to move up
            if (row > 0 && maze[row - 1][column] != 1 && maze[row - 1][column] != '*')
            {
                path.push(new int[]
                { row - 1, column });
            }

            // try to move down
            if (row < maze.length - 1 && maze[row + 1][column] != 1 && maze[row + 1][column] != '*')
            {
                path.push(new int[]
                { row + 1, column });
            }

            // try to move left
            if (column > 0 && maze[row][column - 1] != 1 && maze[row][column - 1] != '*')
            {
                path.push(new int[]
                { row, column - 1 });
            }

            // try to move right
            if (column < maze[0].length - 1 && maze[row][column + 1] != 1 && maze[row][column + 1] != '*')
            {
                path.push(new int[]
                { row, column + 1 });
            }

            // print the maze after solving and display solved message
            txtOutput.appendText(getArrayString(maze));
         
        }

// if we get here, there is no path to the goal
        JOptionPane.showMessageDialog(null, "No path to goal found.");
    }

//to string method for displaying the output in a toString
//for GUI display
    public static String getArrayString(char[][] maze)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maze.length; i++)
        {
            for (int j = 0; j < maze[i].length; j++)
            {
                if (maze[i][j] == 1)
                {
                    sb.append("#");
                } else if (maze[i][j] == 0)
                {
                    sb.append("O");
                } else if (maze[i][j] == '*')
                {
                    sb.append("X");
                } else if (maze[i][j] == 2)
                {
                    sb.append("E");
                } else if (maze[i][j] == 4)
                {
                    sb.append("S");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
