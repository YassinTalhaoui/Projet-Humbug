
package g54892.humbug.controller;

import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import g54892.humbug.model.Level;
import g54892.humbug.model.LevelStatus;
import g54892.humbug.model.Model;
import g54892.humbug.model.Position;
import g54892.humbug.model.SquareType;
import g54892.humbug.view.text.InterfaceView;

/**
 * This class is responsible for the dynamics of the game and the updating of
 * sight as you go.
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
    public void startGame(int level){
        game.startLevel(level);
        //Level.getLevel( level);
        //Level.getLevel(1);
        System.out.println(LevelStatus.NOT_STARTED);
        //Level.getLevel(level).getAnimals();
       //int i=0;
       //while(i<game.getAnimals().length){
      int i=game.getAnimals().length-1;
     //int i = Level.getLevel(level).getAnimals().length-1;
        while(i>=0){
        /* if(game.getAnimals()[i].isOnStar()){
                i--;
            }*/
       // Level.getLevel(level).getAnimals()[i].setOnStar(false);
       // System.out.println(LevelStatus.NOT_STARTED);
        game.getAnimals()[i].setOnStar(false);
//         game.getAnimals()[i--].setOnStar(false);
        
        while(/*!game.levelIsOver()*/  !this.game.getAnimals()[i].isOnStar()/*! Level.getLevel(level).getAnimals()[i].isOnStar() */){
       
            // game.getAnimals()[i].setOnStar(false);
            view.displayBoard(this.game.getBoard(), this.game.getAnimals());
            //view.displayBoard(game.getBoard(), this.game.getAnimals());
            System.out.println("");
             /*view.displayBoard(Level.getLevel(level).getBoard(), Level.getLevel(level).getAnimals());
            System.out.println("");*/
            try{
           /*      view.displayBoard(Level.getLevel(level).getBoard(), Level.getLevel(level).getAnimals());
            System.out.println("");*/
                //view.displayBoard(game.getBoard(), game.getAnimals());
             /*   view.displayBoard(Level.getLevel(level).getBoard(), Level.getLevel(level).getAnimals());
            System.out.println("");*/
              
             Position pos = view.askPosition(level); 
             
             Direction direction = view.askDirection();
             //game.move(pos, direction);
               game.move(pos, direction,level);
            } catch (Exception e){
                view.displayError("erreur !!!");
            }
            
           /*if(this.game.getAnimals()[i].isOnStar()){
                i--;
            }*/
        }
         //if(this.game.getAnimals()[i].isOnStar()){
          //      i--;
           // }
          // i--;
        //}
        //System.out.println("Felicitation vous etes le gagnant !!!!!!!!!");
        if(game.getAnimals()[i].isOnStar()/*Level.getLevel(level).getAnimals()[i].isOnStar()*/){
            //System.out.format(" %2s ", " | * |");
                i--;
            }
       
          System.out.println(LevelStatus.WIN);
         
    
    }
      
    }
    /**
     * This object (which is already a string!) is itself returned.
     * @return  the string itself.
     */
    @Override
    public String toString() {
        return "Controller{" + "game=" + game + ", view=" + view + '}';
    }
    
}
