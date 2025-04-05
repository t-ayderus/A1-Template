/*
 * File: Player.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that models a Player, moving through a maze
 */
package ca.mcmaster.se2aa4.mazerunner.navigation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.mazelogic.Maze;



public class Player{

    private final Logger logger = LogManager.getLogger();
    private Maze maze;
    private int pos[] = new int[2];
    private Compass compass;

    public Player(Maze currentMaze, int [] entrancePosition)
    {
        this.maze =  currentMaze;
        this.pos[0] = entrancePosition[0];
        this.pos[1] = entrancePosition[1];
        compass =  new Compass(pos);
    }

//Move Player forward in the direction it is facing
    public void fwd(){
        this.pos = compass.fwd(maze);
    }

//Move Player Left in the direction it is facing
    public void left(){
        compass.left();
    }

//Move Player Right in the direction it is facing
    public void right(){
        compass.right();
    }

//Get the current position of the player
    public int[] getPosition(){
        return this.pos;
    }

//Get the current direction of the player
    public Direction getDirection(){
        return compass.getDirection();
    }

//Set the current position of the player
    public void setPosition(int [] newPos, Direction newDir){
        this.pos[0] = newPos[0];
        this.pos[1] = newPos[1];
        compass.setPosition(newPos, newDir);
    }

//Get maze entrance 
    public int [] getMazeEntrance(){
        return maze.getEntrance();
    }
//Get maze exit
    public int [] getMazeExit(){
        return maze.getExit();
    }
}