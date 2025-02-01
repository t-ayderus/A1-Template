
package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MazeParser
{

    private static final Logger logger = LogManager.getLogger();

    

    //Finds Entrance of Maze
    public int[] getEntrance(ArrayList<ArrayList<Path>>  maze)
    {
        for(int i = 0; i<maze.size(); i++)
        { 
            if(maze.get(i).get(0) == (Path.PASS))
                return new int[] {i,0};        
        }
        return null;
    }

    //Finds Exit of Maze
    public int[] getExit( ArrayList<ArrayList<Path>> maze)
    {
        //Last Collum
        int end = maze.get(0).size() - 1;

        for(int i = 0; i<maze.size(); i++)
        {
            if( maze.get(i).get(end) == (Path.PASS) )
                return new int[] {i,end};
        }
        return null;
    }
  
    //Method to parse and return 2D representation of maze
    public ArrayList<ArrayList<Path>> parse(String filePath)
    {  
           ArrayList<ArrayList<Path>> maze= new ArrayList<>();

           try{
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int row = 0;
                while ((line = reader.readLine()) != null) {

                    maze.add( new ArrayList<>() );

                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') 
                            maze.get(row).add(Path.WALL);

                        else if (line.charAt(idx) == ' ') 
                            maze.get(row).add(Path.PASS);

                        
                    }
                    row++;
            }

          } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\\n");
        }
    
        return maze;
    }

}