package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


//Implements Command Pattern
public class FollowPathCommand extends Command{

    private final Logger logger = LogManager.getLogger();
    
    private Maze maze;
    private int exitPosition[];
    private String strPath;
    private Player player;
    

    public FollowPathCommand(String strPath, Player player){ 
        this.strPath = strPath;
        this.exitPosition = player.getMazeExit();
        this.player = player;
    }

//Execute the follow path command
    @Override
    public void execute(){
        
        //Assumes start is left side, facing East
        if(this.followPathEastSide( ) ){
            System.out.println("correct path");
        //Switch start to right side, facing West    
        }else if(this.followPathWestSide())
            System.out.println("correct path");
        else 
            System.out.println("incorrect path");         
   }

//Follow the path from the left side of the maze, facing East
    public boolean followPathEastSide(){
         return followPath();
    } 
//Follow the path from current direction of the player
    public boolean followPath(){
         for( int i = 0; i<strPath.length(); i++)
        {
            if(strPath.charAt(i) == 'F')
                player.fwd();
            else if(strPath.charAt(i) == 'R'){   
                player.right();
                //logger.info("New Direction " + compass.getDirection());
            }else if(strPath.charAt(i) == 'L'){
                player.left();
               // logger.info("New Direction " + compass.getDirection());
            }else
                logger.error("Incorrect Input");

            logger.info("Fwd: Row " + this.player.getPosition()[0] + " Col " + this.player.getPosition()[1]);
        }

        if(this.player.getPosition()[0] == exitPosition[0] && this.player.getPosition()[1] == exitPosition[1] )
            return true;
        else  
            return false;

    }
    
//Follow the path from the right side of the maze, facing West
    public boolean followPathWestSide(){
            int [] newStart = player.getMazeExit();
            this.exitPosition = player.getMazeEntrance();
            player.setPosition(newStart, Direction.W);
            return followPath();

    }

}