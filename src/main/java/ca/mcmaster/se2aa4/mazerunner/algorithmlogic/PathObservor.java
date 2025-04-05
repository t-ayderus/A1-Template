package ca.mcmaster.se2aa4.mazerunner.algorithmlogic;  
/*
 * File: PathObserver.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A thatimplements the PathObserver class for the Observer Pattern
 */

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