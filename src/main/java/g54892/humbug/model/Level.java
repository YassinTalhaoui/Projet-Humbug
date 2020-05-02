package g54892.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Provides a level of game.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Level {

    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     * Constructor of Level.
     */
    public Level() {
    }

    /**
     * Constructor of Level.
     *
     * @param board the gaming board.
     * @param animals the animals.
     * @param nMoves the number of allowed moves.
     */
    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Simple getter of board.
     *
     * @return the board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Simple getter of animals.
     *
     * @return the animals.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Simple getter of nMoves.
     *
     * @return the number of moves allowed.
     */
    public int getnMoves() {
        return nMoves;
    }

    /**
     * Gives the corresponding playing level.
     *
     * @param level an integer.
     * @return playing level.
     */
    public static Level getLevel(int level) {
        return readLevel(level);
    }

    /**
     * Represents an object into a String.
     *
     * @return the String itself.
     */
    @Override
    public String toString() {
        return "Level{" + "board=" + board + ", animals="
                + Arrays.toString(animals) + ", nMoves=" + nMoves + '}';
    }

    /**
     * Reads a level from a file and returns it.
     *
     * @param nLevel an integer.
     * @return the corresponding level
     */
    private static Level readLevel(int nLevel) {
        try {
            var objectMapper = new ObjectMapper();
            var file = new File("src/main/ressources/data/level-" + nLevel + ".json");
            var level = objectMapper.readValue(file, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
