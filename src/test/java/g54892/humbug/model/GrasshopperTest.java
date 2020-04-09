/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test Grasshopper.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class GrasshopperTest {
    
    private Board board;
    private Animal[] animals;
    
     @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(0, 0)),
            new Spider(new Position(1, 2)),
            new Snail(new Position(1, 1))
        };
    }
    /*public GrasshopperTest() {
    }*/

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notInside() {
        System.out.println("move next case not Inside");
         board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Grasshopper instance = (Grasshopper) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = null; // move and fall.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_Inside() {
        System.out.println("move next case Inside");
         board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
          animals = new Animal[] {
            new Grasshopper(new Position(0, 1)),
            new Snail(new Position(1, 1)),
            new Spider(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(2, 1); // move and to next free position.
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
         animals = new Animal[] {
            new Grasshopper(new Position(1, 2)),
            new Spider(new Position(0, 1)),
            new Snail(new Position(1, 1))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

}
    

