
package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MazeParser
{

    private static final Logger logger = LogManager.getLogger();


    //Finds Entrance of Maze
    public int[] getEntrance(ArrayList<ArrayList<String>>  maze)
    {
        for(int i = 0; i<maze.size(); i++)
        {
          
            if(maze.get(i).get(0).equals("PASS"))
                return new int[] {i,0};
                
        }

        return null;
    }

    //Finds Exit of Maze
    public int[] getExit( ArrayList<ArrayList<String>> maze)
    {
        //Last Collum
        int end = maze.get(0).size() - 1;

        for(int i = 0; i<maze.size(); i++)
        {
            if( maze.get(i).get(end).equals("PASS") )
                return new int[] {i,end};
        }
        return null;
    }
  
   //A method to Print The Maze
    public void printMaze( ArrayList<ArrayList<String>>  maze )
    {
        Iterator<ArrayList<String>>  listIterator= maze.iterator();

        while(listIterator.hasNext())
        {
            ArrayList<String> row = (ArrayList<String>) listIterator.next();

            for(String col: row)
            {
                System.out.print(col+" ");
            }
            System.out.print(System.lineSeparator());
        } 

    }

    //Method to parse and return 2D representation of maze
    public ArrayList<ArrayList<String>> parse(String filePath)
    {  
           ArrayList<ArrayList<String>> maze= new ArrayList<ArrayList<String>>();

           try{
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int row = 0;
                while ((line = reader.readLine()) != null) {

                    maze.add( new ArrayList<String>() );

                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') 
                            maze.get(row).add("WALL");

                        else if (line.charAt(idx) == ' ') 
                            maze.get(row).add("PASS");

                        
                    }
                    row++;
            }

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\\n");
        }
    
        return maze;
    }


    public static void main(String[] args)
    {
        MazeParser mazeParser = new MazeParser();
        ArrayList<ArrayList<String>>  maze = new ArrayList<ArrayList<String>>();


       maze = mazeParser.parse(args[0]);

        mazeParser.printMaze(maze);
        
       logger.info( mazeParser.getExit(maze)[0] + "and " + mazeParser.getExit(maze)[1] );
    }

}