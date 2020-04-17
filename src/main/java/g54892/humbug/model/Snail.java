package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

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
        Position pos = super.getPositionOnBoard();
        boolean isFree = true;
        for (Animal animal : animals) {
            if (board.getSquare(pos).hasWall(direction)) {
                return nextWall(board, direction, animals);
            }
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                return pos;
            } else if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (isFree && board.isInside(pos.next(direction))) {
                if (board.getSquare(pos.next(direction)).hasWall(direction.opposite())) {
                    return pos;
                }
                if (board.getSquareType(pos.next(direction)) == STAR) {
                    animal.setOnStar(true);
                    if (isOnStar()) {
                        board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                        snailToNull(animals);
                    }
                }
            }
        }
        return pos.next(direction);
    }

    /**
     * Nullifies an animal if it's on a star.
     *
     * @param animals a snail.
     */
    private void snailToNull(Animal... animals) {
        Animal snail = new Snail(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                snail.setPositionOnBoard(null);

            }
        }
    }

    /**
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of snails.
     * @return the initial position if there is a wall
     */
    private Position nextWall(Board board, Direction direction, Animal... animals) {
        int i = 0;
        while (i < animals.length) {
            Position posi = animals[i].getPositionOnBoard();
            if (board.getSquare(posi).hasWall(direction)) {
                return posi;
            }
            i++;
        }
        return null;

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
