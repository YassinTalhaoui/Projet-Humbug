
package g54892.humbug.view.text;

import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Position;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.util.Scanner;

/**
 * This class regroups every interaction with the user 
 * and any view details.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class View implements InterfaceView{
   
    /**
     * displays the gaming board.
     * @param board a given board.
     * @param animals the given animals.
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
     *
     * @param message a String to display;
     */
    public void displayError(String message) {
        message = "ERREUR !!!";

    }
    
    /**
     * Asks for a position and returns it.
     * @return the given position.
     */
    public Position askPosition() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de ligne");
        int line = kbd.nextInt();
        while (line > 2 || line < 0) {

            String message = "Le nombre saisi n'est pas correct. "
                    + "Veuillez entrer un nombre entier entre 0 et 2 compris. ";
            System.out.println(message);
            line = kbd.nextInt();
        }

        Scanner kbd1 = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de colonne");
        int column = kbd1.nextInt();
        while (column > 2 || column < 0) {

            String message = "Le nombre saisi n'est pas correct. "
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
}
