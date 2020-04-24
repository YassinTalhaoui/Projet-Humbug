package g54892.humbug.model;

import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents spiders on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Spider extends Animal {

    /**
     * Constructor of Spider.
     */
    public Spider() {
    }

    /**
     * Constructor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given spiders on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of spiders.
     * @return The deplacement of one of the spiders on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        pos = pos.next(direction);
        int a = 0;
        while (a < animals.length) {
            if (pos.next(direction).equals(animals[a].getPositionOnBoard())) {
                return pos;
            }
            a++;
        }
        if (board.isInside(pos.next(direction))) {
            if (board.getSquare(pos.next(direction)).hasWall(direction.opposite())) {
                return pos.next(direction.opposite());
            }
            if (!board.isInside(pos)) {
                return pos.next(direction.opposite());
            }
            if (board.getSquareType(pos.next(direction)).equals(STAR)) {
                animalToNull(direction, pos, board, animals);
            }
            pos = pos.next(direction);
            setPositionOnBoard(pos);
        }
        if (!board.isInside(pos)) {
            return null;
        }
        return moveOneCrawling(board, direction, animals);
    }
}
