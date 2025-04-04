package ca.mcmaster.se2aa4.mazerunner;

//Interface for observer pattern
public interface Observer {
    //Add Move made by the player to the path
    public void addMove(Move move);

    //Returns the path taken by the player
    public String observedPath();
}