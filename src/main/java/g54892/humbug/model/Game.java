
package g54892.humbug.model;

import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.util.Arrays;

/**
 * Gathers the elements necessary for the game
 * to present a facade to the view. 
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
       /* if(level ==1){
         board = Board.getInitialBoard();
        animals = new Animal[] {
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
            Game g = new Game();
            g.getBoard();
            g.getAnimals();
            
        }*/
       //board = Board.getInitialBoard();
       /*animals = new Animal[] {
            new Snail(new Position(2, 2)),
            new Snail(new Position(2, 2)),
            new Snail(new Position(2, 2)),
            new Snail(new Position(2, 2))
        };*/
       animals = new Animal[] {
            new Snail(new Position(0, 0))};
       
        this.board= Board.getInitialBoard();
        this.animals =  animals;
        
    }
    
    /**
     * Indicates if the level is over.
     * @return true if the level is over, false otherwise.
     */
    public boolean levelIsOver() {
        if (board == null) {
            throw new IllegalArgumentException("board ne peut pas etre null " + board);
        }
        if (animals == null || animals.length == 0) {
            throw new IllegalArgumentException("animals ne peut pas etre null " + Arrays.toString(animals));
        }
        
        boolean onStar = false;
        int i = 0;
        while (i < animals.length && board.isInside(animals[i].getPositionOnBoard())
                && board.getSquareType(animals[i].getPositionOnBoard()) == STAR) {
            animals[i] = null;
            animals[i] = animals[i++];
        }
        if (animals.length == i) {
            onStar = true;
        }
        return onStar;

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
         if(position ==null || direction == null){
             throw new IllegalArgumentException("valeurs incorrectes");
         }
         int i =0;    
         while(i<animals.length){
             if(animals[i].move(board,direction, animals)== null){
                 System.out.println("l' animal tombe!");
             }else{
                 animals[i].move(board, direction, animals);
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
    
    
    
    public static void main(String[] args) {
        Game ga = new Game();
         Board b = Board.getInitialBoard();
        Board board = Board.getInitialBoard();
     /*  Animal[] animals = new Animal[] {
            new Snail(new Position(2, 2)),
            new Snail(new Position(1, 1)),
            new Snail(new Position(2, 2)),
            new Snail(new Position(2, 2))
        };*/
      
        ga.startLevel(1);
        System.out.println(ga);
        System.out.println(ga.levelIsOver());
        Position pos = new Position(0, 0);
        Object object = new Object();
        Game g = new Game();
        ga.move(pos, Direction.SOUTH);
        
        //ga.move( ga.animals[0].getPositionOnBoard(), Direction.EAST);
        
        //System.out.println(ga);
       
    }

   
    
    
    
    
    
}
