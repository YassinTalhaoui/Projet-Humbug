/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Yassin
 */
public class ScarabéTest {

    public ScarabéTest() {
    }

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });

        animals = new Animal[]{
            new Scarabé(new Position(0, 0)),
            new Snail(new Position(0, 1))
        };
    }

    /**
     * Test of move method, of class Scarabé.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Scarabé instance = (Scarabé) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 2);
        Position expResult1 = new Position(0, 1);

        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertEquals(expResult1, animals[1].getPositionOnBoard());
    }

    /**
     * Test of move method, of class Scarabé.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Scarabé instance = (Scarabé) animals[0];
        animals[1].setPositionOnBoard(new Position(1, 1));
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Scarabé.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Scarabé instance = (Scarabé) animals[0];
        animals[0].setPositionOnBoard(new Position(1, 2));
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Opposite wall, of class Scarabé.
     */
    @Test
    public void testMove_opposite_wall() {
        System.out.println("move opposite wall");
        Position pos = new Position(1, 2);
        board.getSquare(pos).setWestWall(true);

        animals = new Animal[]{
            new Scarabé(new Position(0, 0)),
            new Snail(new Position(1, 1))
        };
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(1, 1); //don't move.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test next wall, of class Scarabé.
     */
    @Test
    public void testMove_next_wall() {
        System.out.println("move next wall");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Position pos = new Position(1, 2);

        board.getSquare(pos).setNorthWall(true);
        animals = new Animal[]{
            new Spider(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(1, 2); //don't move.
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

}
