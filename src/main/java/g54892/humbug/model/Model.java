package g54892.humbug.model;

/**
 * Defines the methods that must be implemented by the Game class
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public interface Model {

    /**
     * Simple getter of board.
     *
     * @return the gaming board.
     */
    Board getBoard();

    /**
     * Simple getter of animals.
     *
     * @return an array of the animals that are present on the board.
     */
    Animal[] getAnimals();
    
    /**
     * Simple getter of getLevelStatus.
     *
     * @return getLevelStatus.
     */
    LevelStatus getGetLevelstatus();

   // void setGetLevelStatus(LevelStatus getLevelStatus);
    
    /**
     * Initializes the board and the animals for the first level.
     *
     * @param level an integer that represents the level.
     */
    void startLevel(int level);

    /**
     * Makes the move if allowed.
     *
     * @param position a given position.
     * @param direction a given direction.
     */
    void move(Position position, Direction direction);

    /**
     * Simple getter of remainingMoves.
     *
     * @return the remaining moves.
     */
    int getRemainingMoves();

    /**
     * Given for each level the current status.
     *
     * @param level an integer.
     * @return the current status.
     */
    LevelStatus getLevelStatus(int level);

}
