package g54892.humbug.model;

import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Grasshopper extends Animal {

    /**
     * Constructor of Grasshopper
     */
    public Grasshopper() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given grasshoppers on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of grasshoppers.
     * @return The deplacement of one of the grasshoppers on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        for (Animal animal : animals) {
            while (animal.getPositionOnBoard().equals(pos.next(direction))) {
                pos = pos.next(direction);
                if (!board.isInside(pos.next(direction))) {
                    return null;
                }
            }
            if (board.getSquareType(pos.next(direction)).equals(STAR)) {
                animalToNull(direction, pos, board, animals);
            }
        }
        return pos.next(direction);
    }
}
