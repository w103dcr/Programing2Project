//Class MazeSolver, C211 Group Project Spring 2023
//Author: Rhett Godwin
public class MazeSolver
{
    // Initialize instance variables
    private int[][] maze;
    private boolean[][] visited;
    private int startRow, startCol;
    private int endRow, endCol;

    // default constructor
    public MazeSolver() {
        maze = new int[0][0];
        visited = new boolean[0][0];
        startRow = 0;
        startCol = 0;
        endRow = 0;
        endCol = 0;
    }

    // non default constructor
    public MazeSolver(int[][] maze, boolean[][] visited, int startRow, int startCol, int endRow, int endCol) {
        super();
        this.maze = maze;
        this.visited = visited;
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

//getter for maze
    public int[][] getMaze()
    {
        return maze;
    }

//setter for maze
    public void setMaze(int[][] maze)
    {
        this.maze = maze;
    }

//getter for visited
    public boolean[][] getVisited()
    {
        return visited;
    }

//setter for visited
    public void setVisited(boolean[][] visited)
    {
        this.visited = visited;
    }

//getter for startrow
    public int getStartRow()
    {
        return startRow;
    }

//setter for start row
    public void setStartRow(int startRow)
    {
        this.startRow = startRow;
    }

//getter for startcol
    public int getStartCol()
    {
        return startCol;
    }

//setter for startcol
    public void setStartCol(int startCol)
    {
        this.startCol = startCol;
    }

//getter for endrow
    public int getEndRow()
    {
        return endRow;
    }

//setter for endrow
    public void setEndRow(int endRow)
    {
        this.endRow = endRow;
    }

//getter for endcol
    public int getEndCol()
    {
        return endCol;
    }

//setter for endcol
    public void setEndCol(int endCol)
    {
        this.endCol = endCol;
    }

}
