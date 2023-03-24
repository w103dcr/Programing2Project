// Class Maze, C211 Group Project Spring 2023
// Author: Dwayne Roark

// Creating Class Maze
public class Maze {

    // Creating Instance Attributes
    int[][] maze;
    int rows, columns;

    // Default Constructor
    public Maze() {
        rows = 0;
        columns = 0;
    }

    // Non-Default Constructor
    public Maze(int m, int n) {
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

    // Getters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Setters
    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}