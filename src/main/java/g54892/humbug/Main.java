
package g54892.humbug;

import g54892.humbug.controller.Controller;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Game;
import g54892.humbug.model.Square;
import static g54892.humbug.model.SquareType.GRASS;
import g54892.humbug.view.text.View;

/**
 * Creates the contoller and starts the game.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Main {

    public static void main(String[] args) {
        int i =1;
         while(i<50){
        Controller controller = new Controller(new Game(), new View());
        controller.startGame(i);
        i++;
    }
         
         /*System.out.println(SOUTH.opposite());
        System.out.println(EAST.opposite());
        System.out.println(WEST.opposite());
        System.out.println(NORTH.opposite());
        Square object = new Square(GRASS);
        
        System.out.println(object.hasWall(NORTH));
        System.out.println(object.hasWall(SOUTH));
         System.out.println(object.hasWall(WEST));
          System.out.println(object.hasWall(EAST));*/
      
    }

}
