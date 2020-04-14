
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Grasshopper extends Animal{

    public Grasshopper() {
    }
    
    

     /**
     * Construcor of positionOnBoard. 
     * @param positionOnBoard the current position of the animals.
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }

     /**
     * Moves the given grasshoppers on the gaming board.
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of grasshoppers.
     * @return The deplacement of one of the grasshoppers on the board.
     */
    @Override
    public Position move(Board board, Direction direction,/*int level,*/ Animal... animals) {
        Position pos = super.getPositionOnBoard();
        //boolean isFree = true;
        for (Animal animal : animals) {
           
             while (animal.getPositionOnBoard().equals(pos.next(direction))) {
                pos = pos.next(direction);
                //if(animal.getPositionOnBoard().equals(pos.next(direction))){
                    // pos = pos.next(direction);
               // }
                 
                if (!board.isInside(pos.next(direction))) {
                return null;
                }
                
             }
              if (board.getSquareType(pos.next(direction)) == STAR) {
                  //pos=pos.next(direction);
                    animal.setOnStar(true);
                    if (isOnStar()) {
                        board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                        grasshopperToNull(animals);
                    }
                }
            
        }
         
     return pos.next(direction);
}
    
    /**
     * Nullifies an animal if it's on a star.
     *
     * @param animals a grasshopper.
     */
    private void grasshopperToNull(Animal... animals) {
        Animal grasshopper = new Snail(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                grasshopper = null;
            }
        }
    }
}
