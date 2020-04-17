package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Butterfly extends Animal {

    /**
     * Constructor of Butterfly.
     */
    public Butterfly() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given butterfly on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of butterfly.
     * @return The deplacement of one of the butterly on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        for (Animal animal : animals) {
            pos = pos.next(direction);
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                pos = pos.next(direction);
            }
            if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (board.getSquare(pos.next(direction)).getType() == STAR) {
                animal.setOnStar(true);
                if (isOnStar()) {
                    board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                    butterflyToNull(animals);
                }
            }
        }
        return pos.next(direction);
    }

    /**
     * Nullifies an animal if it's on a star.
     *
     * @param animals a bumbelbee.
     */
    private void butterflyToNull(Animal... animals) {
        Animal butterfly = new Butterfly(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                butterfly = null;
            }
        }
    }
}
