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
     *
     * @param level an integer.
     */
    public void startGame(int level) {
        game.startLevel(level);
        view.displayLevel(level);
        int i = 0;
        int remainingMoves = Level.getLevel(level).getnMoves();
        while (i < game.getAnimals().length && remainingMoves > 0) {
            game.getAnimals()[i].setOnStar(false);
            while (!this.game.getAnimals()[i].isOnStar()) {
                whileNotOnStar(level, remainingMoves);
                remainingMoves--;
            }
            if (game.getAnimals()[i].isOnStar()) {
                System.out.println(LevelStatus.WIN);
            }
            i++;
        }
    }

    /**
     * Restars the same level if all conditions are met.
     *
     * @param level the current level.
     * @param remainingMoves the remaining moves of the level.
     */
    private void restartLevel(int level, int remainingMoves) {
        if (remainingMoves < 0 || game.getLevelStatus(level) == LevelStatus.FAIL) {
            remainingMoves = Level.getLevel(level).getnMoves();
            game.startLevel(level);
            whileNotOnStar(level, remainingMoves);
        }
    }

    /**
     * Continues the while all the animals aren't on a star.
     *
     * @param level the current level.
     * @param remainingMoves the remaining moves of the level.
     */
    private void whileNotOnStar(int level, int remainingMoves) {
        view.displayRemainingMoves(remainingMoves);
        view.displayBoard(this.game.getBoard(), this.game.getAnimals());
        try {
            Position pos = view.askPosition(level);
            Direction direction = view.askDirection();
            game.move(pos, direction);
            game.getLevelStatus(level);
        } catch (Exception e) {
            view.displayError("erreur !!!");
        }
        restartLevel(level, remainingMoves);
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
