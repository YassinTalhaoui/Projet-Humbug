package g54892.humbug.model;

import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Ladybird extends Animal {

    /**
     * Constructor of Ladybird.
     */
    public Ladybird() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given ladybirds on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of ladybirds.
     * @return The deplacement of one of the ladybirds on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        if (board.getSquare(pos.next(direction)).hasWall(direction.opposite())) {
            return pos;
        }
        pos = pos.next(direction);
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                return pos;
            }
            if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (board.getSquareType(pos.next(direction)).equals(STAR)) {
                animalToNull(direction, pos, board, animals);
            }
        }
        return pos.next(direction);
    }
}
