
package g54892.humbug.model;

import java.util.Arrays;

/**
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Game implements Model{
    Board board;
    Animal[] animals;

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
    
    /**
     * Initializes the board and the animals for the first level.
     * @param level an integer that represents the level.
     */
    public void startLevel(int level){
        
    }
    
    /**
     * Indicates if the level is over.
     * @return true if the level is over, false otherwise.
     */
    public boolean levelIsOver(){
          if(board == null){
            throw new IllegalArgumentException("board ne peut pas etre null "+board);
        }
         if(animals == null || animals.length == 0){
            throw new IllegalArgumentException("animals ne peut pas etre null "+Arrays.toString(animals));
        }
         
         for(int i = 0; i<animals.length; i++){
             while(animals[i].isOnStar());
             return false;
         }
        return true;
        
    }
    
    /**
     * Makes the move if allowed.
     * @param position a given position.
     * @param direction a given direction.
     */
    public void move(Position position, Direction direction){
        if(board == null){
            throw new IllegalArgumentException("board ne peut pas etre null "+board);
        }
         if(animals == null || animals.length == 0){
            throw new IllegalArgumentException("animals ne peut pas etre null "+Arrays.toString(animals));
        }
    }
    
}
