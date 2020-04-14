
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.STAR;
import g54892.humbug.view.text.View;
import java.util.Arrays;

/**
 * Gathers the elements necessary for the game
 * to present a facade to the view. 
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Game implements Model{
    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;

    /**
     * Simple getter of currentLevel.
     * @return the current level.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Simple getter of remainingMoves.
     * @return an interger, remainingMoves.
     */
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * Simple getter of board.
     * @return the gaming board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Simple getter of animals.
     * @return an array of the animals that are present on the board.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }
    
    
    
    /**
     * Initializes the board and the animals for the first level.
     * @param level an integer that represents the level.
     */
    public void startLevel(int level) {
 this.animals= Level.getLevel(level).getAnimals();
        /*this.animals = new Animal[]{
           new Snail(new Position(0, 0)),
           new Snail(new Position(1, 1)),
          // new Snail(new Position(1, 2)),
       };*/

        //this.board = Board.getInitialBoard();
         this.board= Level.getLevel(level).getBoard();
        //this.animals = animals;
      
      
        //this.animals = new Animal[]{ new Snail(new Position(0, 0))};
       
       
    }
    
    /**
     * Indicates if the level is over.
     * @param position
     * @param direction
     * @return true if the level is over, false otherwise.
     */
    public boolean levelIsOver() {
        if (board == null) {
            throw new IllegalArgumentException("board ne peut pas etre null " + board);
        }
        if (animals == null || animals.length == 0) {
            throw new IllegalArgumentException("animals ne peut pas etre null " + Arrays.toString(animals));
        }
        
      /*  boolean onStar = false;
        int i = 0;
        while (i < animals.length && board.isInside(animals[i].getPositionOnBoard())
                && board.getSquareType(animals[i].getPositionOnBoard()) == STAR) {
            animals[i] = null;
            animals[i] = animals[i++];
        }
        if (animals.length == i) {
            onStar = true;
        }
        return onStar;*/
 for (Animal animal : animals) {
            if (!animal.isOnStar()){
                return false;
            }
        }
        return true;

    }

    /**
     * Makes the move if allowed.
     * @param position a given position.
     * @param direction a given direction.
     */
    public void move(Position position, Direction direction, int level) {
        if (board == null) {
            throw new IllegalArgumentException("board ne peut pas etre null " + board);
        }
        if (animals == null || animals.length == 0) {
            throw new IllegalArgumentException("animals ne peut pas etre null " + Arrays.toString(animals));

        }
        if (position == null || direction == null) {
            throw new IllegalArgumentException("valeurs incorrectes");
        }
        int i = 0;
        
        while (i < animals.length) {
            
            if (this.animals[i].move(board, direction,/*level,*/ animals) == null || !this.board.isInside(position)/*Level.getLevel(level).getBoard().isInside(position)*/) {
                //System.out.println("l' animal tombe!");
                System.out.println(LevelStatus.FAIL);
                
            } else {
                
                if(animals[i].getPositionOnBoard().equals(position)/*Level.getLevel(level).getAnimals()[i].getPositionOnBoard().equals(position)*/){
                position = this.animals[i].move(board, direction,/* level,*/ animals);
               // position = Level.getLevel(level).getAnimals()[i].move(board, direction, animals);
                //position = animals[i].getPositionOnBoard();
               
               // position = animals[i].move(board, direction, animals);
                //animals[i].setPositionOnBoard(position);
                 
                this.animals[i].setPositionOnBoard(position);
               // Level.getLevel(level).getAnimals()[i].setPositionOnBoard(position);
                System.out.println(LevelStatus.IN_PROGRESS);
                remainingMoves++;
                }
            }
            
            i++;
        }

    }

    /**
     * This object (which is already a string!) is itself returned.
     * @return  the string itself.
     */
    @Override
    public String toString() {
        return "Game{" + "board=" + board + ", animals=" + Arrays.toString(animals) + '}';
    }

    @Override
    public LevelStatus getLevelStatus() {
        
        return null;
    }

   

    
    
}
