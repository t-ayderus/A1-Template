package ca.mcmaster.se2aa4.mazerunner.command;
/*
 * File: FindPathCommand.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A that extends the Command class to define the Find Path Command 
 */
import ca.mcmaster.se2aa4.mazerunner.StringParser;
import ca.mcmaster.se2aa4.mazerunner.algorithmlogic.Algorithm;   

public class FindPathCommand extends Command{
    
    private static final StringParser strParser = new StringParser();
    private Algorithm algorithm;


    public FindPathCommand(Algorithm algorithm){
        this.algorithm = algorithm;
    }

//Execute the find path command
    public void execute(){
        String path = algorithm.findPath();
        System.out.println( strParser.toFactorizedForm(path) );

    }
}