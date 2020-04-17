package g54892.humbug.view.text;

import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import g54892.humbug.model.Position;

/**
 * Interface implemented by View.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public interface InterfaceView {

    /**
     * displays the gaming board.
     *
     * @param board a given board.
     * @param animals the given animals.
     */
    void displayBoard(Board board, Animal... animals);

    /**
     * Asks for a position and returns it.
     *
     * @param level an integer.
     * @return the given position.
     */
    Position askPosition(int level);

    /**
     * Asks for a direction and returns it.
     *
     * @return a direction between NORTH, SOUTH, EAST, WEST.
     */
    Direction askDirection();

    /**
     * Displays a message for error.
     *
     * @param message
     */
    void displayError(String message);

    /**
     * Displays the remaining moves.
     *
     * @param remainingMoves an integers
     */
    void displayRemainingMoves(int remainingMoves);
}
