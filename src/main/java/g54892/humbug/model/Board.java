
package g54892.humbug.model;

import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.util.Arrays;

/**
 * Represents de game board made up of squares when there are any.
 * 
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Board {
    private Square[][] squares;

    /**
     * Simple getter of Squares[][].
     * @return a two dimensional squares array.
     */
    public Square[][] getSquares() {
        return squares;
    }
    
    /**
     * Constructor of the Board.
     * @param squares a 2-dimensional array. 
     */
    public Board(Square[][] squares) {
        this.squares = squares;
    }
    
    /**
     * Returns the board of the first level.
     * @return the gaming board.
     */
    public static Board getInitialBoard(){
        Board board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Position pos = new Position(0, 1);
        board.getSquare(pos).setNorthWall(true);
        Position posi = new Position(1, 1);
        board.getSquare(posi).setEastWall(true);
        Position posis = new Position(1, 2);
        board.getSquare(posis).setEastWall(true);

        return board;
    }
    
    /**
     * Cheks that the given position is in the board.
     * @param pos a given position.
     * @return true if the position is in the board, false otherwise.
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("position invalide " + pos);
        }
        if (pos.getRow() < 0 || pos.getRow() >= squares.length) {
            return false;
        }
        if (pos.getColumn() < 0 || pos.getColumn() >= squares[0].length) {
            return false;
        }
        return squares[pos.getRow()][pos.getColumn()] != null;

    }

    /**
     * Returns the type of the square whose position is given.
     * @param pos a given position.
     * @return the position of the given square.
     */
    
    public SquareType getSquareType(Position pos) {
        if (squares[pos.getRow()][pos.getColumn()] == null) {
            throw new IllegalArgumentException("position en dehors du plateau de jeu " + pos);
        }
        SquareType type = squares[pos.getRow()][pos.getColumn()].getType();
        Position currentPos = null;
        
        for (Square[] square : squares) {
            for (Square square1 : square) {
                if (pos == currentPos) {
                    type = squares[pos.getRow()][pos.getColumn()].getType();
                }
            }
        }
        return type;
    }

    /**
     * Counts the numbers of rows of the gaming board.
     * @return the numbeer of rows
     */
    public int getNbRow(){
        int i;
         for( i = 0; i<squares.length; i++){
            for (Square square : squares[i]) {
            }
        }
        return i;
    }
    
    /**
     * Counts the numbers of columns of the gaming board.
     * @return numbers of columns.
     */
    public int getNbColumn(){
        int j = 0;
        for (Square[] square : squares) {
            for (j =0; j < square.length; j++) {
            }
        }
        return j;        
    }
    
    public Square getSquare(Position pos) {
    return squares[pos.getRow()][pos.getColumn()];
}
       
    /**
     * This object (which is already a string!) is itself returned.
     * @return  the string itself.
     */ 
    @Override
    public String toString() {
        return "Board{" + "squares=" + Arrays.deepToString(squares) + '}';
    }
    
}
