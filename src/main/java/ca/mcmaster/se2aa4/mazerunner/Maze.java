package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Iterator;

public class Maze{

    private final MazeParser mazeParser = new MazeParser();
    private ArrayList<ArrayList<Path>> maze = new ArrayList<>();

    private int[] entrance;
    private int[] exit;

    public void setMaze(String filePath)
    {
        this.maze = mazeParser.parse(filePath);
        this.entrance = mazeParser.getEntrance(maze);
        this.exit = mazeParser.getExit(maze);
    }

    public int [] getEntrance()
    {
        return this.entrance;
    }

     public int [] getExit()
    {
        return this.exit;
    }

    public Path getIndex(int row, int col)
    {
        return this.maze.get(row).get(col);
    }

    //A method to Print The Maze
    public void printMaze( )
    {
        Iterator<ArrayList<Path>>  listIterator= this.maze.iterator();

        while(listIterator.hasNext())
        {
            ArrayList<Path> row = (ArrayList<Path>) listIterator.next();

            for(Path col: row)
            {
                System.out.print( col +" ");
            }
            System.out.print(System.lineSeparator());
        } 

    }
}