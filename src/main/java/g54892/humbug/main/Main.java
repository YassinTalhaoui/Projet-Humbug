
package g54892.humbug.main;

import g54892.humbug.controller.Controller;
import g54892.humbug.model.Game;
import g54892.humbug.view.text.View;

/**
 * Creates the contoller and starts the game.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();

    }

}



