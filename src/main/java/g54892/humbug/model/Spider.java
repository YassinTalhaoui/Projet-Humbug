
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
       for(int i = 0;i < animals.length && isFree; i++){
           if (animals[i].getPositionOnBoard().equals(pos.next(direction))) {  
               //isFree = false;
                return pos;
            }
             pos = pos.next(direction);
             setPositionOnBoard(pos); 
       }

          return null;
}
    
     private void spiderToNull(Animal... animals) {
        Animal spider = new Spider(getPositionOnBoard());
        for (Animal animal : animals) {
            if (animal.isOnStar()) {
                spider = null;
            }
        }
    }
    
    
    public static void main(String[] args) {
        
    }
}
    
   

