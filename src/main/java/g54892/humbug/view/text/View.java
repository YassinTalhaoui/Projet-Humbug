package g54892.humbug.view.text;

import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Level;
import g54892.humbug.model.Position;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;
import java.util.Scanner;

/**
 * This class regroups every interaction with the user and any view details.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class View implements InterfaceView {

    /**
     * displays the gaming board.
     *
     * @param board a given board.
     * @param animals the given animals.
     */
    public void displayBoard(Board board, Animal... animals) {
        int s = 0;
        String[][] game = new String[board.getNbRow()][board.getNbColumn()]; 
        for (int i = 0; i < game.length; i++) {
            System.out.println("");
            System.out.println("_______________________________________________");

            for (int j = 0; j < game[i].length; j++) {
                Position pos = new Position(i, j);
                if (board.isInside(pos) && board.getSquareType(pos).equals(GRASS)) {
                    if (pos.equals(animals[s].getPositionOnBoard())) {
                        if (board.isInside(pos) && board.getSquare(pos).hasWall(WEST)) {
                        System.out.format(" %2s ", " ||S |");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(EAST)) {
                        System.out.format(" %2s ", " | S||");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(NORTH)) {
                        System.out.format(" %2s ", " |¯S¯|");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(SOUTH)) {
                        System.out.format(" %2s ", " |_S_|");
                    }else
                        System.out.format(" %2s ", " | S |");
                        if (animals.length > 1&& s<animals.length) {
                            s++;
                        }
                    } else if (board.isInside(pos) && board.getSquare(pos).hasWall(SOUTH)) {
                        System.out.format(" %2s ", " | _ |");
                    } else if (board.isInside(pos) && board.getSquare(pos).hasWall(NORTH)) {
                        System.out.format(" %2s ", " | ¯ |");
                    } else if (board.isInside(pos) && board.getSquare(pos).hasWall(WEST)) {
                        System.out.format(" %2s ", " ||  |");
                    } else if (board.isInside(pos) && board.getSquare(pos).hasWall(EAST)) {
                        System.out.format(" %2s ", " |  ||");
                    } else {
                        System.out.format(" %2s ", " |   |");
                    }
                } else if (board.isInside(pos) && board.getSquareType(pos).equals(STAR)) {
          
                        if (board.isInside(pos) && board.getSquare(pos).hasWall(WEST)) {
                        System.out.format(" %2s ", " ||* |");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(EAST)) {
                        System.out.format(" %2s ", " | *||");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(NORTH)) {
                        System.out.format(" %2s ", " |¯*¯|");
                    }else if (board.isInside(pos) && board.getSquare(pos).hasWall(SOUTH)) {
                        System.out.format(" %2s ", " |_*_|");
                    }else
                    System.out.format(" %2s ", " | * |");
                } else if (!board.isInside(pos)) {
                    System.out.format(" %2s ", " | X |");
                }
            }
        }
    }

    /**
     * Displays the remaining moves.
     *
     * @param remainingMoves an integer.
     */
    public void displayRemainingMoves(int remainingMoves) {
        System.out.println("Nombres de déplacemets restants: " + remainingMoves);

    }

    /**
     * Displays a message for error.
     *
     * @param message a String to display;
     */
    public void displayError(String message) {
        System.out.println("ERREUR !!!");
    }

    /**
     * Asks for a position and returns it.
     * @param level an integer.
     * @return the given position.
     */
    public Position askPosition(int level) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de ligne");
        int line = kbd.nextInt();
        while (line > Level.getLevel(level).getBoard().getNbRow() || line < 0) {

            String message = "Le nombre saisi n'est pas correct. "
                    + "Veuillez entrer un nombre entier entre 0 et " + Level.getLevel(level).getBoard().getNbColumn() + " compris. ";
            System.out.println(message);
            line = kbd.nextInt();
        }

        Scanner kbd1 = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de colonne");
        int column = kbd1.nextInt();
        while (column > Level.getLevel(level).getBoard().getNbColumn() || column < 0) {

            String message = "Le nombre saisi n'est pas correct. "
                    + "Veuillez entrer un nombre entier entre 0 et " + Level.getLevel(level).getBoard().getNbColumn() + " compris. ";
            System.out.println(message);
            column = kbd1.nextInt();
        }
        Position pos = new Position(line, column);

        return pos;

    }

    /**
     * Asks for a direction and returns it.
     *
     * @return a direction between NORTH, SOUTH, EAST, WEST.
     */
    public Direction askDirection() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un chiffre parmi:" + 1 + " EAST");
        System.out.println("                                 " + 2 + " NORTH");
        System.out.println("                                 " + 3 + " SOUTH");
        System.out.println("                                 " + 4 + " WEST");
        int nb = kbd.nextInt();
        while (nb <= 0 || nb > 4) {
            String message = "Le nombre saisi n'est pas correct. "
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
