package g54892.humbug.model;

/**
 * This class represents snails on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Snail extends Animal {

    /**
     * Constructor of Snail.
     */
    public Snail() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given snails on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of snails.
     * @return The deplacement of one of the snails on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {  
        return moveOneCrawling(board, direction, animals);
    }

    /**
     * Represents an object into a String.
     * @return the String itself.
     */
    @Override
    public String toString() {
        return "Snail{" + '}';
    }

}
