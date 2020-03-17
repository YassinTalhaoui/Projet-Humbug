
package g54892.humbug.view.text;

import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Position;
import g54892.humbug.model.SquareType;
import java.util.Scanner;

/**
 * This class regroups every interaction with the user 
 * and any view details.
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class View {
    
    /**
     * displays the gaming board.
     * @param board a given board.
     */
    public void displayBoard(Board board) {
        String[][] game = new String[board.getNbRow()][board.getNbColumn()];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                Position pos = new Position(i, j);
                if (SquareType.GRASS != board.getSquareType(pos)
                        && SquareType.STAR != board.getSquareType(pos)) {
                    System.out.printf(" %3d", "|");
                }
            }
        }
    }
    
    /**
     * Displays a message for error. 
     * @param message a String to display;
     */
    public void displayError(String message){
        
        message ="Veuillez entrer une position ";
    }
    
    /**
     * Asks for a position and returns it.
     * @return the given position.
     */
    public Position askPosition() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de ligne");
        int line = kbd.nextInt();
        System.out.println("Veuillez entrer un numero de colonne");
        int column = kbd.nextInt();
        Position pos = new Position(line, column);
        return pos;
        
    }
    
    /**
     * Asks for a direction and returns it.
     * @return a direction between NORTH, SOUTH, EAST, WEST.
     */
    public Direction askDirection() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer une valeur parmi: " + "1=" + Direction.EAST
                + " 2=" + Direction.NORTH + " 3=" + Direction.SOUTH + " 4=" + Direction.WEST);
        int nb = kbd.nextInt();
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

