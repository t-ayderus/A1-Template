package ca.mcmaster.se2aa4.mazerunner;


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