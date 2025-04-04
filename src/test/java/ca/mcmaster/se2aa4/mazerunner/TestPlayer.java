package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer{
    private Maze maze;
    private Player player;

    @BeforeEach
    public void setUp(){
        this.maze = new Maze();
        this.maze.setMaze("src/test/java/ca/mcmaster/se2aa4/mazerunner/dummy.maz.txt");
        this.player = new Player(this.maze, maze.getEntrance());

    }
    //Test to check the Right Hand Algorithm is working properly

@Test
    
    public void testFwd(){
        this.setUp();
        this.player.fwd();
        assertEquals(1, player.getPosition()[0]);
        assertEquals(1, player.getPosition()[1]);

    }

    public void testLeft(){
        this.setUp();
        player.left();
        assertEquals(Direction.N, player.getDirection());
        player.left();
        assertEquals(Direction.W, player.getDirection());
        player.left();
        assertEquals(Direction.S, player.getDirection());
        player.left();
        assertEquals(Direction.E, player.getDirection());

    }

    public void testRight(){
         //Starts at East
        player.right();
        assertEquals(Direction.S, player.getDirection());
        player.right();
        assertEquals(Direction.W, player.getDirection());
        player.right();
        assertEquals(Direction.N, player.getDirection());
        player.right();
        assertEquals(Direction.E, player.getDirection());

    }

    public void testSetPosition(){
        this.setUp();
        player.setPosition(maze.getExit(), Direction.W);
        assertEquals(Direction.W, player.getDirection());
        assertEquals(1, player.getPosition()[0]);
        assertEquals(7, player.getPosition()[1]);

    }

}
