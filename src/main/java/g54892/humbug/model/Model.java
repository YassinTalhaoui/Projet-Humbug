
package g54892.humbug.model;

/**
 * Defines the methods
 * that must be implemented by the Game class
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public interface Model {
    
    /**
     * Simple getter of board.
     * @return the gaming board.
     */
    Board getBoard();

    /**
     * Simple getter of animals.
     * @return an array of the animals that are present on the board.
     */
    Animal[] getAnimals();

    /**
     * Initializes the board and the animals for the first level.
     * @param level an integer that represents the level.
     */
    void startLevel(int level);

    /**
     * Indicates if the level is over.
     * @return true if the level is over, false otherwise.
     */
    boolean levelIsOver();

    /**
     * Makes the move if allowed.
     * @param position a given position.
     * @param direction a given direction.
     */
    void move(Position position, Direction direction);

}
