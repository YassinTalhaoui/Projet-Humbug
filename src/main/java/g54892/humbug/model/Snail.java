
package g54892.humbug.model;

import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.nio.file.Files;


/**
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Snail extends Animal {

    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        boolean isFree = true;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getPositionOnBoard().equals(pos.next(direction))) {
                //isFree=true;
                return pos;
            } else if (!Board.getInitialBoard().isInside(pos.next(direction))) {
                return null;
            }
            if (isFree && Board.getInitialBoard().isInside(pos.next(direction))) {
                if (board.getSquareType(pos.next(direction)) == STAR) {
                    animals[i].setOnStar(true);
                    if (isOnStar()) {
                        board.getSquares()[board.getNbRow()-1][board.getNbColumn()-1].setType(GRASS);
                        snailToNull(animals); 
                    }
                }

            }
        }

        return pos.next(direction);
    }

    private void snailToNull(Animal... animals) {
        Animal snail = new Snail(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                snail = null;
            }
        }
    }
}
    
   

   

 

