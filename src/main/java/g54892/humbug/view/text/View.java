
package g54892.humbug.view.text;

import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Position;
import g54892.humbug.model.Snail;
import g54892.humbug.model.Square;
import g54892.humbug.model.SquareType;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;


/**
 * This class regroups every interaction with the user 
 * and any view details.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class View implements InterfaceView{
     public static final String BLACK_BOLD = "\033[1;30m";
    /**
     * displays the gaming board.
     * @param board a given board.
     */
    public void displayBoard(Board board, Animal... animals) {
        String[][] game = new String[board.getNbRow()][board.getNbColumn()];
        for (int i = 0; i < game.length; i++) {
            System.out.println("");
            System.out.println("________________________");
            for (int j = 0; j < game[i].length; j++) {
                Position pos = new Position(i, j);
                if (board.isInside(pos) && board.getSquareType(pos).equals(GRASS)) {
                    if (pos.equals(animals[0].getPositionOnBoard())) {
                        System.out.format(" %2s ", " | S |");
                    } else {
                        System.out.format(" %2s ", " |   |");
                    }
                    
                } else if (board.isInside(pos) && board.getSquareType(pos).equals(STAR)) {
                    System.out.format(" %2s ", " | * |");
                } else if (!board.isInside(pos)) {
                    System.out.format(" %2s ", " | X |");
                }

            }
        }
    }


    
    /**
     * Displays a message for error. 
     * @param message a String to display;
     */
    public void displayError(String message){
        message ="ERREUR !!!";
        
    }
    
    /**
     * Asks for a position and returns it.
     * @return the given position.
     */
    public Position askPosition() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de ligne");
        int line = kbd.nextInt();
         while ( line>2 || line<0 ) {
            //kbd.next();
           
           String message ="Le nombre saisi n'est pas correct. "
                + "Veuillez entrer un nombre entier entre 0 et 2 compris. ";
             System.out.println(message);
           line = kbd.nextInt();
        }
        
        Scanner kbd1 = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de colonne");
        int column = kbd1.nextInt();
         while ( column>2 || column<0 ) {
            
             String message ="Le nombre saisi n'est pas correct. "
                + "Veuillez entrer un nombre entier entre 0 et 2 compris. ";
             System.out.println(message);
           column = kbd1.nextInt();
        }
        Position pos = new Position(line, column);
        return pos;
        
    }
    
    /**
     * Asks for a direction and returns it.
     * @return a direction between NORTH, SOUTH, EAST, WEST.
     */
    public Direction askDirection() {
        Scanner kbd = new Scanner(System.in);
       // System.out.println("Veuillez entrer une valeur parmi: 1, 2, 3, ou 4" );
        System.out.println("Veuillez entrer un chiffre parmi:"+ 1+" EAST");
        System.out.println("                                 "+ 2+" NORTH");
        System.out.println("                                 "+ 3+" SOUTH");
        System.out.println("                                 "+ 4+" WEST");
        int nb = kbd.nextInt();
         while (  nb<=0 || nb>4) {
             String message ="Le nombre saisi n'est pas correct. "
                + "Veuillez entrer un nombre entier entre 0 et 4 compris. ";
             System.out.println(message);
              nb = kbd.nextInt();
    }
        Direction[] d = {EAST, NORTH, SOUTH, WEST};
        switch (nb) {
            case 1:
                return d[0];
            case 2:
                return d[1];
            case 3:
                return d[2];
            case 4:
                return d[3];
            default:
                break;
        }
     
        return d[nb];
    }

    public static void main(String[] args) {
       // Position pos = new Position(0, 0);
       // Position p= new Position(0, 0);
        View obj = new View();
    
            /*  Board board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });*/
              View view = new View();
              
              Animal[] animals = new Animal[] {
            new Snail(new Position(0, 0)),
                  
            //new Snail(new Position(1, 2))
        };
              
               Board bd = Board.getInitialBoard();
               view.displayBoard(bd,animals);
              //view.displayBoard(bd,animals[0],animals[1]);
              //obj.displayBoard(board);

              //System.out.println("\033[34m" + "Hello, World" + "\033[m");
             System.out.println("");
             System.out.println("");
             System.out.println(view.askPosition());
             System.out.println(view.askDirection());
       
}

    public View() {
        
    }

    @Override
    public String toString() {
               //Board bd = Board.getInitialBoard();
        return "View ";
    }
    
}
