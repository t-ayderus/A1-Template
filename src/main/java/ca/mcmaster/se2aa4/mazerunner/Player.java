/*
 * File: Player.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that models a Player, moving through a maze
 */
package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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

    public void fwd(){
        this.pos = compass.fwd(maze);
    }

    public void left(){
        compass.left();
    }

    public void right(){
        compass.right();
    }

    public int[] getPosition(){
        return this.pos;
    }

    public Direction getDirection(){
        return compass.getDirection();
    }

    public void setPosition(int [] newPos, Direction newDir){
        this.pos[0] = newPos[0];
        this.pos[1] = newPos[1];
        compass.setPosition(newPos, newDir);
    }

    public int [] getMazeEntrance(){
        return maze.getEntrance();
    }

    public int [] getMazeExit(){
        return maze.getExit();
    }
}