
package g54892.humbug.controller;

import g54892.humbug.model.Direction;
import g54892.humbug.model.Game;
import g54892.humbug.model.Model;
import g54892.humbug.model.Position;
import g54892.humbug.view.text.InterfaceView;
import g54892.humbug.view.text.View;

/**
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Controller {
    Model game;
    InterfaceView view;

    /**
     * Constructor of Controller.
     * @param game represents the model.
     * @param view the view of the board.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }
    
    /**
     * Starts the game while level isn't finish and 
     * no animals has fallen.
     */
    public void startGame(){
        game.startLevel(1);
        while(!game.levelIsOver() && game.getAnimals() != null){
            view.displayBoard(game.getBoard(), game.getAnimals());
            try{
                Position pos = view.askPosition();               
                Direction direction = view.askDirection();
                game.move(pos, direction);
            } catch (Exception e){
                view.displayError("erreur !!!");
            }
        }
    }
    public static void main(String[] args) {
        Object object = new Object();
        Game game = new Game();
        View view = new View();
        Controller controller = new Controller(game, view);
        controller.startGame();
        
        
    }

    @Override
    public String toString() {
        return "Controller{" + "game=" + game + ", view=" + view + '}';
    }
    
    
}
