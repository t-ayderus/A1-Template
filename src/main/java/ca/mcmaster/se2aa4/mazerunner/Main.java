/*
 * File: Main.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A program that returns or verifies the path of a maze
 */

package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.algorithmlogic.Algorithm;
import ca.mcmaster.se2aa4.mazerunner.algorithmlogic.Observer;
import ca.mcmaster.se2aa4.mazerunner.algorithmlogic.PathObservor;
import ca.mcmaster.se2aa4.mazerunner.algorithmlogic.RightHand;
import ca.mcmaster.se2aa4.mazerunner.command.Command;
import ca.mcmaster.se2aa4.mazerunner.command.FindPathCommand;
import ca.mcmaster.se2aa4.mazerunner.command.FollowPathCommand;
import ca.mcmaster.se2aa4.mazerunner.mazelogic.Maze;
import ca.mcmaster.se2aa4.mazerunner.navigation.Player;

public class Main{

private static final Logger logger = LogManager.getLogger();
private static final Maze maze = new Maze();
private static final StringParser strParser = new StringParser();

//Implements Command Pattern
private static Command command;

//Implements Observer Pattern
private static Observer observer;

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "Input Maze" );
        options.addOption("p",true,"User Input Potential Path");

        CommandLineParser parser = new GnuParser();
        CommandLine cmd;
            
       logger.info("** Starting Maze Runner");
       try {
            cmd = parser.parse(options, args);
        
            maze.setMaze(args[1]);
            logger.info("**** Reading the maze from file " + args[1]);

            if(cmd.hasOption("p") && cmd.hasOption("i") )
            {   
                Player player = new Player( maze, maze.getEntrance());
                String path = strParser.validateString(args[3]);
                path = strParser.toCannonicalForm(path);
                command = new FollowPathCommand(path,player);
            }
            else if(cmd.hasOption("-i"))
            {
                Algorithm algorithm = new RightHand(maze);
                observer = new PathObservor();
                algorithm.addObserver(observer);
                command = new FindPathCommand(algorithm);
            }
            else{
                logger.error("Incorrect Input");
            }

            command.execute();
            
        } catch(Exception e) {
           logger.error("/!\\ An error has occured /!\\");
        }  
       
    }
}