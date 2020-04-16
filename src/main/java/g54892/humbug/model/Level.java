
package g54892.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Provides a level of game.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Level {
    private Board board;
    private Animal[] animals;
    private int nMoves;

    public Level() {
    }
    
    

    /**
     * Constructor of Level.
     * @param board the gaming board.
     * @param animals the animals.
     * @param nMoves the number of allowed moves.
     */
    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Simple getter of board.
     * @return the board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Simple getter of animals.
     * @return the animals.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Simple getter of nMoves.
     * @return the number of moves allowed.
     */
    public int getnMoves() {
        return nMoves;
    }
   
    /**
     * Gives the playing level.
     * @param level an integer.
     * @return playing level.
     */
    public static Level getLevel(int level){
       /* switch(level){
            case 1:
            Board board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
            Animal[] animals = new Animal[] {
            new Snail(new Position(0, 0))
                
        };
           int nMoves=4;
          
       Level l=new Level(board, animals, nMoves);
       
        return l;
            case 2:
                  board = new Board(new Square[][]{
            {new Square(GRASS),new Square(GRASS),null},
            {null, new Square(STAR), null},
            {new Square(STAR), new Square(GRASS), new Square(STAR)},
            {null, new Square(GRASS), null}
        });
             animals = new Animal[] {
           new Snail(new Position(0, 0)),
           new Snail(new Position(2, 1)),
           //new Snail(new Position(3, 1))
        };
            nMoves=5;
              l=new Level(board, animals, nMoves);
              return l;
            case 3:
                        board = new Board(new Square[][]{
                         
            {new Square(GRASS),new Square(GRASS),new Square(GRASS)},
            {new Square(GRASS), null,new Square(GRASS)},
            {new Square(GRASS), null,new Square(GRASS)},
            {new Square(STAR), new Square(GRASS), new Square(GRASS)}
            
        });
                        Position pos=new Position(0,0);
                        board.getSquare(pos).setNorthWall(true);
                        pos = new Position(0, 2);
                        board.getSquare(pos).setEastWall(true);
                         pos = new Position(3, 0);
                        board.getSquare(pos).setWestWall(true);
                         pos = new Position(3, 2);
                        board.getSquare(pos).setSouthWall(true);
                        
             animals = new Animal[] {
                 
            new Snail(new Position(2, 0)),
         
        };
            nMoves=4;
              l=new Level(board, animals, nMoves);
              return l;
    
        case 4 :
                      
                         
             board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS),null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
                    
                        
             animals = new Animal[] {
                 
            new Snail(new Position(2, 0)),
         
        };
            nMoves=4;
              l=new Level(board, animals, nMoves);
              return l;
        }*/
        return readLevel(level);
        
    }

    @Override
    public String toString() {
        return "Level{" + "board=" + board + ", animals=" + animals + ", nMoves=" + nMoves + '}';
    }
    
    private static Level readLevel(int n) {
        try {
            var objectMapper = new ObjectMapper();
            var file=new File("src/main/ressources/data/level-"+n+".json");
           /* var inputStream = Level.class.getResourceAsStream(
                    "data/level-" + n + ".json");*/
            var level = objectMapper.readValue(file, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("level2 "+ getLevel(2));
        System.out.println( readLevel(100));
    }

}
