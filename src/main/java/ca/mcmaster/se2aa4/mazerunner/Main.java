

package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main{



private static final Logger logger = LogManager.getLogger("mazeRunnerLogger");
private static final MazeParser mazeParser = new MazeParser();
private static final Runner player = new Runner();


private static ArrayList<ArrayList<String>>  maze;

    public static void main(String[] args) {

        
        Options options = new Options();
        options.addOption("i", true, "Input Maze" );
        options.addOption("p",true,"User inputted potential path");

         CommandLineParser parser = new GnuParser();

         CommandLine cmd;
            
        logger.info("** Starting Maze Runner");
       try {

             cmd = parser.parse(options, args);
        

            if(cmd.hasOption("p") && cmd.hasOption("i") )
            {
                logger.info("**** Reading the maze from file " + args[1]);
                maze = mazeParser.parse(args[1]);

               //DEBUGGING 
               //mazeParser.printMaze(maze);
                player.setMaze(maze, mazeParser.getEntrance(maze));

                player.moveRunner(args[3], mazeParser.getExit(maze) );
        
            }
            else if(cmd.hasOption("-i"))
            {
                System.out.println("3F L 4F R 3F");

            }
            else{
                logger.error("Incorrect Input");
            }
            
        } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\");
         }  
        // logger.error("**** Computing path");
        //logger.error("PATH NOT COMPUTED");
        //logger.error("** End of MazeRunner");
    }
}