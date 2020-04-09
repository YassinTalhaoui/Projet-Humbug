
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Bumbelbee extends Animal{

    /**
     * Construcor of positionOnBoard. 
     * @param positionOnBoard the current position of the animals.
     */
    public Bumbelbee(Position positionOnBoard) {
        super(positionOnBoard);
    }

     /**
     * Moves the given bumbelbees on the gaming board.
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of bumbelbees.
     * @return The deplacement of one of the bumbelbees on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
       // boolean isFree=true;
        pos=pos.next(direction);
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
               pos=pos.next(direction);
            return  pos.next(direction);
             }
            /*if (board.getSquareType(pos.next(direction)) == STAR) {
                  //pos=pos.next(direction);
                    animal.setOnStar(true);
                    if (isOnStar()) {
                        board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                        bumbelbeeToNull(animals);
                    }
                }*/
             if (!board.isInside(pos.next(direction))) {
                return null;
                }
               if (board.getSquareType(pos.next(direction)) == STAR) {
                  //pos=pos.next(direction);
                    animal.setOnStar(true);
                    if (isOnStar()) {
                        board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                        bumbelbeeToNull(animals);
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
    private void bumbelbeeToNull(Animal... animals) {
        Animal bumbelbee = new Bumbelbee(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                bumbelbee = null;
            }
        }
    }
    
}
