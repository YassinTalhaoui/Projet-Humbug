
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test Bumbelbee.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class BumbelbeeTest {
    
   /* public BumbelbeeTest() {
    }*/

    private Board board;
    private Animal[] animals;
    
    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),null },
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Bumbelbee(new Position(0, 0)),
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
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
           animals = new Animal[] {
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        animals[1].setPositionOnBoard(new Position(1, 1));
        Position expResult = new Position(0, 2); // move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null");
         board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),null },
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
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
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),new Square(GRASS) },
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
           animals = new Animal[] {
            new Bumbelbee(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
        Bumbelbee instance = (Bumbelbee) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 2));
        Position expResult = new Position(0, 3); // move to free.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of move method, of class Bumbelbee.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
         board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
         animals = new Animal[] {
            new Bumbelbee(new Position(0, 2)),
            new Spider(new Position(1,2 )),
            new Snail(new Position(1, 1))
        };
         
        Bumbelbee instance = (Bumbelbee) animals[0];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }
    
}
