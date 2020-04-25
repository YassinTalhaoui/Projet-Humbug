package g54892.humbug.model;

import g54892.humbug.view.text.View;
import java.util.Arrays;

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
    LevelStatus getLevelstatus;

    /**
     * Simple getter of currentLevel.
     *
     * @return the current level.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

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

    public LevelStatus getGetLevelstatus() {
        return getLevelstatus;
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
        if (board == null) {
            throw new IllegalArgumentException("board ne peut pas etre null " + board);
        }
        if (animals == null || animals.length == 0) {
            throw new IllegalArgumentException("animals ne peut pas etre null " + Arrays.toString(animals));
        }
        if (position == null || direction == null) {
            throw new IllegalArgumentException("valeurs incorrectes");
        }
        int i = 0;
        while (i < animals.length) {
            if (this.animals[i].move(board, direction, animals) == null /*|| !this.board.isInside(position)*/) {
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

    @Override
    public LevelStatus getLevelStatus(int level) {
        View w = new View();
        for (Animal animal : animals) {
            if (animal.isOnStar() && remainingMoves <= Level.getLevel(level).getnMoves()) {
                return LevelStatus.WIN;
            } else if (getRemainingMoves() >= Level.getLevel(level).getnMoves() && !animal.isOnStar()) {
                animal.setOnStar(true);
                System.out.println(LevelStatus.FAIL + ": Nombres de deplacement autorisés atteind!");
            }
        }
        return null;
    }
 
}
