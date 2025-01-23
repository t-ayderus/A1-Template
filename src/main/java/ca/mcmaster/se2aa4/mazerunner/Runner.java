package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Runner{


    private final Logger logger = LogManager.getLogger("runnerLogger");
    private final Compass compass = new Compass();

    private ArrayList<ArrayList<String>>  maze;
    private int  pos[] = new int[2];
   
    public void setMaze(ArrayList<ArrayList<String>> currentMaze, int [] entrancePosition)
    {
        this.maze =  currentMaze;
        this.pos[0] = entrancePosition[0];
        this.pos[1] = entrancePosition[1];
    }


    //Takes in Cannocial Path
    public void moveRunner(String strPath,  int [] exitPosition )
    {

        for( int i = 0; i<strPath.length(); i++)
        {

            switch(strPath.charAt(i))
            {
                case 'F':
                   fwd();
                    logger.info("Fwd: Row " + this.pos[0] + " Col " + this.pos[1]);

                break;
                case 'R':
                    compass.right();
                    logger.info("New Direction " + compass.getDirection());

                break;
                case 'L':
                    compass.left();
                    logger.info("New Direction " + compass.getDirection());

                break;
                default:
                    logger.error("Incorrect Input");
            }    
        }

        logger.info("Exit is at " + exitPosition[0] + ", " + exitPosition[1]);

        if(this.pos[0] ==exitPosition[0] && this.pos[1] == exitPosition[1] )
            System.out.println("correct path");
        else  
            System.out.println("incorrect path");

    }

    public void fwd()
    {

        try {

             switch(compass.getDirection()){
            //Move Up to upper Row
            case 'N': 
                    if(maze.get(pos[0]-1).get(pos[1]).equals("PASS") )
                        pos[0]--;
                    else
                        logger.info("WALL");
            break;
            //Move Right in same Row
            case 'E':
                    if(maze.get(pos[0]).get(pos[1]+1).equals("PASS") )
                        pos[1]++;
                    else
                        logger.info("WALL");
            break;
            //Move Down to bellow Row
            case 'S':
                    if(maze.get(pos[0]+1).get(pos[1]).equals("PASS") )
                        pos[0]++;
                    else
                        logger.info("WALL");
            break;

            //Move left in a Row
            case 'W':
                    if(maze.get(pos[0]).get(pos[1]-1).equals("PASS") )
                      pos[1]--;
                    else
                      logger.info("WALL");
            break;

            default:
                logger.error("Path Error");
        }
        } catch (Exception e) {
            logger.error("Error: Path Out of Bounds");
        }
       
    }

}