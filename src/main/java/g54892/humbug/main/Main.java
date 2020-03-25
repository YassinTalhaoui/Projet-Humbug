
package g54892.humbug.main;

import g54892.humbug.controller.Controller;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import g54892.humbug.model.Game;
import g54892.humbug.model.Position;
import g54892.humbug.model.Square;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import g54892.humbug.view.text.View;

/**
 * Creates the contoller and starts the game.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Main {  
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
      
        /*Position position1 =new Position(2,2);
       
         System.out.println(position1.next(Direction.EAST));
         System.out.println(position1.next(Direction.NORTH));
         System.out.println(position1.getRow()+Direction.NORTH.getDeltaRow());
         System.out.println(Board.getInitialBoard());
         System.out.println(Board.getInitialBoard().isInside(position1));
        
         System.out.println(Board.getInitialBoard().getSquareType(position1));
         System.out.println(Board.getInitialBoard().getNbColumn());
         System.out.println(Board.getInitialBoard().getNbRow());*/
         
         
         
        
        
    }
    
   
    
}



