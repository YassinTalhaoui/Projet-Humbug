package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test Butterfly.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class ButterflyTest {

    /*public ButterflyTest() {
    }*/
    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {

        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null, null},
            {null, new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        System.out.println("move_generale");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Butterfly instance = (Butterfly) animals[0];
        animals[1].setPositionOnBoard(new Position(1, 1));
        Position expResult = new Position(0, 3); // move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Butterfly instance = (Butterfly) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 3));
        Position expResult = new Position(0, 4); // move to free.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        board = new Board(new Square[][]{
            {new Square(STAR), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(GRASS), new Square(GRASS)},
            {null, null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(1, 2)),
            new Butterfly(new Position(0, 3))
        };

        // Butterfly instance = (Butterfly) animals[0];
        Butterfly instance = (Butterfly) animals[1];
        Position expResult = new Position(3, 3);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

}
