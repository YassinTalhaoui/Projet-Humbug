package g54892.humbug;

import g54892.humbug.controller.Controller;
import g54892.humbug.model.Game;
import g54892.humbug.view.text.View;

/**
 * Creates the contoller and starts the game.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Main {

    public static void main(String[] args) {
        int i = 100;  //Entrez ici le niveau a partir duquel vous désirez commencer.☕
        while (i < 101) {
            Controller controller = new Controller(new Game(), new View());
            controller.startGame(i);
            i++;
        }
    }
}