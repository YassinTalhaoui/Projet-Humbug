package g54892.humbug.controller;

import g54892.humbug.model.Direction;
import g54892.humbug.model.Level;
import g54892.humbug.model.LevelStatus;
import g54892.humbug.model.Model;
import g54892.humbug.model.Position;
import g54892.humbug.view.text.InterfaceView;

/**
 * This class is responsible for the dynamics of the game and the updating of
 * sight as you go.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Controller {

    Model game;
    InterfaceView view;

    /**
     * Constructor of Controller.
     *
     * @param game represents the model.
     * @param view the view of the board.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Starts the game while level isn't finish and no animals has fallen.
     * @param level an integer.
     */
    public void startGame(int level) {
        game.startLevel(level);
        System.out.println("");
        System.out.println("Niveau : "+level);
        System.out.println("");
        System.out.println(LevelStatus.NOT_STARTED);
        //int i = game.getAnimals().length - 1;
        int i=0;
        int remainingMoves = Level.getLevel(level).getnMoves();
        while (i < game.getAnimals().length && remainingMoves > 0) {
            game.getAnimals()[i].setOnStar(false);
            while (!this.game.getAnimals()[i].isOnStar()) {
                {
                    view.displayRemainingMoves(remainingMoves);
                    view.displayBoard(this.game.getBoard(), this.game.getAnimals());
                    System.out.println("");
                    try {
                        Position pos = view.askPosition(level);
                        Direction direction = view.askDirection();
                        game.move(pos, direction);
                  
                        game.getLevelStatus(level);
                    } catch (Exception e) {
                        view.displayError("erreur !!!");
                    }
                    remainingMoves--;
                }
            }
            if (game.getAnimals()[i].isOnStar()) {
                System.out.println(LevelStatus.WIN);

            }
            i++;
        }
    }

    /**
     * This object (which is already a string!) is itself returned.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return "Controller{" + "game=" + game + ", view=" + view + '}';
    }

}
