
package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MazeParser
{

    private final Logger logger = LogManager.getLogger();

    public static void main(String[] args)
    {
        MazeParser mp = new MazeParser();
        ArrayList<ArrayList<Path>>  maze = mp.parse(args[1]);
        mp.printMaze(maze);

    }
    

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
    


     public void printMaze(ArrayList<ArrayList<Path>> maze )
    {        
        Iterator<ArrayList<Path>>  listIterator= maze.iterator();

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

    //Method to parse and return 2D representation of maze
    public ArrayList<ArrayList<Path>> parse(String filePath)
    {  
           ArrayList<ArrayList<Path>> maze= this.initializeMaze(filePath);

           try{
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                int row = 0;
                while ((line = reader.readLine()) != null) {

                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') 
                            maze.get(row).set(idx, Path.WALL);

                    }
                    row++;
            }

          } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\\n");
        }
    
        return maze;
    }


    public ArrayList<ArrayList<Path>> initializeMaze(String filePath)
    {
        int [] size = getSize(filePath);
        int rows = size[0];
        int length= size[1];     
        ArrayList<ArrayList<Path>> maze = new ArrayList<>();
            for(int i = 0; i<rows; i++)
            {
                maze.add(new ArrayList<>() );
                for(int l = 0; l<length; l++)
                {
                    maze.get(i).add(Path.PASS);
                }
            }
        return maze;
    }


    public int[] getSize(String filePath)
    {
        int rows = 0;
        int length= 0;     
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            
            while ((line = reader.readLine()) != null) {
                if(rows ==0)
                    length=line.length();
                rows++;
            }
          } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\\n");
        }
        return new int[] {rows,length};

    }


}