package ca.mcmaster.se2aa4.mazerunner.algorithmlogic;
/*
 * File: Observer.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A that defines the Obersver interface for the Observer Pattern
 */
//Interface for observer pattern
public interface Observer {
    //Add Move made by the player to the path
    public void addMove(Move move);

    //Returns the path taken by the player
    public String observedPath();
}