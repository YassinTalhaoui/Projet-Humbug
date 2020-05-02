package g54892.humbug.model;

/**
 * This class represents grasshoppers on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Bumbelbee extends Animal {

    /**
     * Constructor of Bumbelbee.
     */
    public Bumbelbee() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given bumbelbees on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of bumbelbees.
     * @return The deplacement of one of the bumbelbees on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        pos = pos.next(direction);
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                return pos.next(direction).next(direction);
            }
        }
        return moveOneFlying(direction, board, animals);
    }
}
