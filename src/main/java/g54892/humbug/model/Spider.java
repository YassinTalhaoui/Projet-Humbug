
package g54892.humbug.model;

import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

/**
 *
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
       
    
       for(int i = 0;i < animals.length; i++){
            
            if (animals[i].getPositionOnBoard().equals(pos.next(direction))) {
                isFree= false;
            }
            if(!isFree){
                return getPositionOnBoard();
            }
            if (!Board.getInitialBoard().isInside(pos.next(direction))) {
                return null;
            }
            while (isFree && Board.getInitialBoard().isInside(pos.next(direction))) {
               if (board.getSquareType(pos.next(direction)) == GRASS||board.getSquareType(pos.next(direction)) == STAR) {
                    setPositionOnBoard(pos.next(direction));
                    
                    if(animals[i].getPositionOnBoard().equals(pos.next(direction))){
                        
                        setPositionOnBoard(pos);
                        getPositionOnBoard();
                        break;
                        
                    }else
                setPositionOnBoard(pos.next(direction));
          return getPositionOnBoard();
          
       }
            }  
            if(Board.getInitialBoard().getSquares()[pos.next(direction).getRow()][pos.getColumn()].equals(pos.next(direction))){
                setPositionOnBoard(pos.next(direction));
                pos.next(direction);
                return getPositionOnBoard();
            }
       }
        //setPositionOnBoard(pos.next(direction));
        return null;
} 
    
    
    public static void main(String[] args) {
        
    }
}
    
   

