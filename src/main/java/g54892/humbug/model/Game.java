package g54892.humbug.model;

import static g54892.humbug.model.LevelStatus.WIN;

/**
 * Gathers the elements necessary for the game to present a facade to the view.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Game implements Model {

    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;
    private LevelStatus getLevelStatus;

    /**
     * Simple getter of remainingMoves.
     *
     * @return an interger, remainingMoves.
     */
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * Simple getter of board.
     *
     * @return the gaming board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Simple getter of animals.
     *
     * @return an array of the animals that are present on the board.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Simple getter of getLevelStatus.
     *
     * @return getLevelStatus.
     */
    public LevelStatus getGetLevelstatus() {
        return getLevelStatus;
    }

    /**
     * Simple setter of getLevelStatus.
     *
     * @param getLevelStatus a status.
     */
    public void setGetLevelStatus(LevelStatus getLevelStatus) {
        this.getLevelStatus = getLevelStatus;
    }
    
    /**
     * Initializes the board and the animals for the first level.
     *
     * @param level an integer that represents the level.
     */
    public void startLevel(int level) {
        this.animals = Level.getLevel(level).getAnimals();
        this.board = Level.getLevel(level).getBoard();
    }

    /**
     * Makes the move if allowed.
     *
     * @param position a given position.
     * @param direction a given direction.
     */
    public void move(Position position, Direction direction) {
        error(position,direction); 
        int i = 0;
        while (i < animals.length ) {
            if (this.animals[i].move(board, direction, animals) == null ) {  
                System.out.println(LevelStatus.FAIL);
            } else if (animals[i].getPositionOnBoard().equals(position)) {
                position = this.animals[i].move(board, direction, animals);
                this.animals[i].setPositionOnBoard(position);
                System.out.println(LevelStatus.IN_PROGRESS);
                remainingMoves++;
            }
            i++;
        }
    }

    /**
     * Changes the status according to the situation.
     *
     * @param level an integer.
     * @return the status of the current level.
     */
    public LevelStatus getLevelStatus(int level) {
        for (Animal animal : animals) {
            if (animal.isOnStar() && remainingMoves <= Level.getLevel(level).getnMoves()) {
                setGetLevelStatus(WIN);
                return LevelStatus.WIN;
            } else if (getRemainingMoves() >= Level.getLevel(level).getnMoves() && !animal.isOnStar()) {
                animal.setOnStar(true);
                System.out.println(LevelStatus.FAIL + ": Nombres de deplacement autorisés atteind!");
                return LevelStatus.FAIL;
            }
        }
        return null;
    }
    
    /**
     * Displays the error message if the conditions are rigth.
     * @param position a position.
     * @param direction a direction.
     */
    private void error(Position position, Direction direction){
        if (board == null || animals == null || animals.length == 0
                || position == null || direction == null) {
            throw new IllegalArgumentException("valeurs incorrectes" );
        }
    }
}
