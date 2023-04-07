import java.util.ArrayList;

// Class Maze, C211 Group Project Spring 2023
// Author: Dwayne Roark

// Creating Class Maze
public class Maze {

    private int row, column; // User input dimensions for maze
    private int gridRow, gridColumn; // Dimensions of output grid
    private char[][] grid; // Character based Output Grid
    private Cell[][] cells; // 2d array of Object Cells

    // Constructor
    public Maze(int x, int y) {
        row = y;
        column = x;
        gridRow = y * 4 + 1;
        gridColumn = x * 2 + 1;
        grid = new char[gridRow][gridColumn];
    }

    // Creating Class for a Cell
    private class Cell {
        int x, y; // Variable for Cell Coordinates

        // ArrayList Called Neighbors with References to Other Cells That Are Adjacent
        // to This Cell
        ArrayList<Cell> neighbors = new ArrayList<>();

        // Boolean Values Used in Grid Creation
        boolean path = false; // Cell is Currently Part of a Path
        boolean wall = true; // Impassable Cell
        boolean open = true; // Has Been Used in Generation

        // Constructor with Wall Set to True
        Cell(int x, int y) {
            this(x, y, true);
        }

        // Constructor with isWall Boolean Variable
        Cell(int x, int y, boolean isWall) {
            this.x = x;
            this.y = y;
            this.wall = isWall;
        }

        // Method Adds Cell to Neighbors ArrayList Adding a neighbor to
        // This Cell and This Cell as a Neighbor to Other
        void addNeighbor(Cell other) {
            if (!this.neighbors.contains(other)) {
                this.neighbors.add(other);
            }
            if (!other.neighbors.contains(this)) {
                other.neighbors.add(this);
            }
        }

        // Method to Check Whether the Cell has a Neighbor Below
        boolean isCellBelowNeighbor() {
            return this.neighbors.contains(new Cell(this.x, this.y + 1));
        }

        // Method to Check Whether the Cell has a Neighbor to the Right
        boolean isCellRightNeighbor() {
            return this.neighbors.contains(new Cell(this.x + 1, this.y));
        }

        // Method Returns a String Representation of the Cell in the Format Cell(x, y)
        @Override
        public String toString() {
            return String.format("Cell(%s, %s)", x, y);
        }

        // Method Checks Whether Another Object Equals This Cell Object
        // by Comparing Their x and y Coordinates
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Cell))
                return false;
            Cell otherCell = (Cell) other;
            return (this.x == otherCell.x && this.y == otherCell.y);
        }
    }
}