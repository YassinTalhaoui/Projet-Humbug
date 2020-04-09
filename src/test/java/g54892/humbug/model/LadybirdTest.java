
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Test Ladybird.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class LadybirdTest {
    
   /* public LadybirdTest() {
    }*/

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
            new Ladybird(new Position(0, 0)),
            new Spider(new Position(1, 2)),
            new Snail(new Position(1, 1))
        };
    }
    
    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notInside() {
        System.out.println("next case not inside");
         board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
      /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 2));
        Position expResult = new Position(0, 1); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_pass_onstar() {
        System.out.println("move pass on star and fall");
         board = new Board(new Square[][]{
            {new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
         animals = new Animal[] {
            new Ladybird(new Position(1, 2)),
            new Spider(new Position(0, 1)),
            new Snail(new Position(1, 1))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertFalse(instance.isOnStar());
        assertFalse(board.getSquareType(new Position(0, 0)) == GRASS);
    }
    
    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_nextOnStar() {
        System.out.println("move, next on star and win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(STAR), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[] {
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 3))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }
    
     /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_wall() {
        System.out.println("move next wall");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Position pos = new Position(0, 1);
        board.getSquare(pos).setEastWall(true);
        animals = new Animal[]{
            new Spider(new Position(1, 1)),
            new Ladybird(new Position(0, 2))
        };
        Ladybird instance = (Ladybird) animals[1];
        Position expResult = new Position(0, 2); //don't move.
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

     /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_opposite_wall() {
        System.out.println("move opposite wall");
        Position pos = new Position(1, 2);
        board.getSquare(pos).setWestWall(true);
        animals = new Animal[]{
            new Spider(new Position(0, 0)),
            new Ladybird(new Position(1, 1))
        };
        Ladybird instance = (Ladybird) animals[1];
        Position expResult = new Position(1, 1); //don't move.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    
    
}
