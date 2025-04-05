package ca.mcmaster.se2aa4.mazerunner;
/*
 * File: TestFollowPathCommand.java
 * Author: Tasnim Ayderus Abdulhakim
 * Decription: A class that test the FollowPathCommand class
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.command.FollowPathCommand;
import ca.mcmaster.se2aa4.mazerunner.mazelogic.Maze;
import ca.mcmaster.se2aa4.mazerunner.navigation.Player;

public class TestFollowPathCommand{
    private Maze maze;
    private Player player;
    private FollowPathCommand followPathCommand;


    @BeforeEach
    public void setUp(){
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
        this.player = new Player(this.maze, maze.getEntrance());
         this.followPathCommand = new FollowPathCommand("FFFFFFF", this.player);
    }

    //Test follow path starting from east side
    @Test
    public void testFollowPathEastSide(){
        this.setUp();
        assertEquals(true, followPathCommand.followPathEastSide() );
    }
 //Test follow path starting from west side
    @Test
    public void testFollowPathWestSide(){
        this.setUp();
        assertEquals(true, followPathCommand.followPathWestSide() );
    }






}