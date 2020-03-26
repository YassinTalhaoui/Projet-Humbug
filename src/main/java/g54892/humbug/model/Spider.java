
package g54892.humbug.model;

import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents spiders on the board.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Spider extends Animal {

    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        boolean isFree = true;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getPositionOnBoard().equals(pos.next(direction))) {
                return getPositionOnBoard();
            }
            if (animals[1].getPositionOnBoard().equals(pos.next(direction))) {
                return pos;
            }
            pos = pos.next(direction);
            setPositionOnBoard(pos);
        }
        if (!board.isInside(pos.next(direction))) {
            return null;
        }
        int i = 0;
        while (i < animals.length) {
            Spider sp = new Spider(pos);
            if (board.getSquares()[animals[i].getPositionOnBoard().getRow()][animals[i].getPositionOnBoard().getColumn()].getType().equals(STAR)) {
                animals[i].setOnStar(true);
            }
            if (animals[i].isOnStar()) {
                board.getSquares()[animals[i].getPositionOnBoard().getRow()][animals[i].getPositionOnBoard().getColumn()].setType(GRASS);
            } else {
                animals[i].setOnStar(false);
            }
            i++;
        }
        return getPositionOnBoard();
    }

}
    
   

