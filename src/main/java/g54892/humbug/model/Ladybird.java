package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
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
        boolean isFree = true;

        if (isFree && board.isInside(pos.next(direction))) {
            if (board.getSquare(pos.next(direction)).hasWall(direction.opposite())) {
                return pos;
            }
        }
        pos = pos.next(direction);

        for (Animal animal : animals) {
            if (board.getSquare(pos).hasWall(direction)) {
                return nextWall(board, direction, animals);
            }
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                return pos;
            }
            if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (board.getSquareType(pos.next(direction)) == STAR) {
                animal.setOnStar(true);
                if (isOnStar()) {
                    board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                    ladyBirdToNull(animals);
                }
            }
        }
        return pos.next(direction);
    }

    /**
     * Nullifies an animal if it's on a star.
     *
     * @param animals a ladybird.
     */
    private void ladyBirdToNull(Animal... animals) {
        Animal ladybird = new Ladybird(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                ladybird = null;
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

}
