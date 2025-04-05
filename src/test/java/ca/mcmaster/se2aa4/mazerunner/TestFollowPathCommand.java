package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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