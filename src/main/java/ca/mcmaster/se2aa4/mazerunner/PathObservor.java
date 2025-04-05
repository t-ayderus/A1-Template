package ca.mcmaster.se2aa4.mazerunner;  

//Implements the Observer Interface

public class PathObservor implements Observer{

    private StringBuilder path;

    public PathObservor(){
        this.path = new StringBuilder();
    }

//Return the path taken by the player
    public String observedPath(){
        return path.toString();
    }

//Add move to the path
    public void addMove(Move move){
        path.append(move.toString());
    }
}