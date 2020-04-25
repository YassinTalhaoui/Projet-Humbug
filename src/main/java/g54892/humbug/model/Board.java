package g54892.humbug.model;

import java.util.Arrays;

/**
 * Represents de game board made up of squares when there are any.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Board {

    private Square[][] squares;

    /**
     * Constructor of Board.
     */
    public Board() {
    }

    /**
     * Simple getter of Squares[][].
     *
     * @return a two dimensional squares array.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Constructor of the Board.
     *
     * @param squares a 2-dimensional array.
     */
    public Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Returns the board of the first level.
     *
     * @param level an integer.
     * @return the gaming board.
     */
    public static Board getInitialBoard(int level) {
        Board board = Level.getLevel(level).getBoard();
        return board;
    }

    /**
     * Cheks that the given position is in the board.
     *
     * @param pos a given position.
     * @return true if the position is in the board, false otherwise.
     */
    public boolean isInside(Position pos) {
        if (pos.getRow() < 0 || pos.getRow() >= squares.length
                || pos.getColumn() < 0 || pos.getColumn() >= squares[0].length
                || pos == null) {
            return false;
        }
        return squares[pos.getRow()][pos.getColumn()] != null;
    }

    /**
     * Returns the type of the square whose position is given.
     *
     * @param pos a given position.
     * @return the position of the given square.
     */
    public SquareType getSquareType(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("position en dehors du plateau de jeu " + pos);
        }
        SquareType type = squares[pos.getRow()][pos.getColumn()].getType();
        return type;
    }

    /**
     * Counts the numbers of rows of the gaming board.
     *
     * @return the numbeer of rows
     */
    public int getNbRow() {

        return squares.length;
    }

    /**
     * Counts the numbers of columns of the gaming board.
     *
     * @return numbers of columns.
     */
    public int getNbColumn() {
        int j = 0;
        for (Square[] square : squares) {
            for (j = 0; j < square.length; j++) {
            }
        }
        return j;
    }

    /**
     * Gives the square we are looking for
     *
     * @param pos a given Position.
     * @return the desired square.
     */
    public Square getSquare(Position pos) {
        return squares[pos.getRow()][pos.getColumn()];
    }

    /**
     * This object (which is already a string!) is itself returned.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return "Board{" + "squares=" + Arrays.deepToString(squares) + '}';
    }

}
