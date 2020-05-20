/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.humbug.main;

import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import g54892.humbug.model.Position;


/**
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Main {  
    public static void main(String[] args) {
      /*  Controller controller = new Controller(new Game(), new View());
        controller.startGame();*/
      
       Position position1 =new Position(2,2);
      
        System.out.println(position1.next(Direction.EAST));
         System.out.println(position1.next(Direction.NORTH));
         System.out.println(position1.getRow()+Direction.NORTH.getDeltaRow());
         System.out.println(Board.getInitialBoard());
         System.out.println(Board.getInitialBoard().isInside(position1));
        
         System.out.println(Board.getInitialBoard().getSquareType(position1));
         System.out.println(Board.getInitialBoard().getNbColumn());
         System.out.println(Board.getInitialBoard().getNbRow());
         
         System.out.println();
        
        
    }
    
   
    
}
