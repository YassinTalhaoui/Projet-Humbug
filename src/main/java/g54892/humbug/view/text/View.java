
package g54892.humbug.view.text;

import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import static g54892.humbug.model.Direction.EAST;
import static g54892.humbug.model.Direction.NORTH;
import static g54892.humbug.model.Direction.SOUTH;
import static g54892.humbug.model.Direction.WEST;
import g54892.humbug.model.Game;
import g54892.humbug.model.Level;
import g54892.humbug.model.Position;
import g54892.humbug.model.Snail;
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
    public void displayBoard(Board board/*, Direction direction*/ ,Animal... animals) {
        String[][] game = new String[board.getNbRow()][board.getNbColumn()];
        for ( int i=0 ; i < game.length ; i++) {
            System.out.println("");
            System.out.println("________________________");
            for (int j = 0; j < game[i].length; j++) {
                Position pos = new Position(i, j);
               
              /* if (pos.equals(animals[s].getPositionOnBoard())) {
                   System.out.format(" %2s ", " | s |");
               }
               s++;
                }*/   
                   
              // while(s<animals.length&& board.getSquareType(pos).equals(GRASS)){
                if (board.isInside(pos) && board.getSquareType(pos).equals(GRASS)) {
                //     int s=0;
               // while(s<animals.length){
             /*  if (pos.equals(animals[i].getPositionOnBoard())) {
                   System.out.format(" %2s ", " | s |");
               }*/
              // s++;
                
                   // int s=0;
                   // while(s<animals.length){
                   //  if (pos.equals(animals[s].getPositionOnBoard())) {
                    
                    /*   // System.out.format(" %2s ", " | s |");
                       //System.out.format(" %2s ", "|   | \n | s | ");
                       // System.out.print("");
                    } */
                    
               // }
               /*if(animals[i].isOnStar()==true){
                    System.out.format(" %2s ", " | * |");
               }else*/
                if (pos.equals(animals[0].getPositionOnBoard())) {
                   // if (pos.equals(animals[i].getPositionOnBoard())) {
                        System.out.format(" %2s ", " | s |");
                       //System.out.format(" %2s ", "|   | \n | s | ");
                       // System.out.print("");         
                }  
                else if (board.isInside(pos) &&board.getSquare(pos).hasWall(SOUTH)){
                         System.out.format(" %2s ", " | _ |");
                         // System.out.format(" %2s ", "| _ | \n | s | ");
                   }else if (board.isInside(pos) &&board.getSquare(pos).hasWall(NORTH)){
                  System.out.format(" %2s ", " | ¯ |");
                 // System.out.format(" %2s ", "| - | \n | s | ");
                   }else if (board.isInside(pos) &&board.getSquare(pos).hasWall(WEST)){
                  System.out.format(" %2s ", " ||  |");
                  // System.out.format(" %2s ", "||  | \n | s | ");
                   }else if (board.isInside(pos) &&board.getSquare(pos).hasWall(EAST)){
                  System.out.format(" %2s ", " |  ||");
                 // System.out.format(" %2s ", "|  || \n | s | ");
              }else{
                        System.out.format(" %2s ", " |   |");
                        // System.out.format(" %2s ", "|   | \n |   | ");
                    }    
            }  else if (board.isInside(pos) && board.getSquareType(pos).equals(STAR) ) {                
                    System.out.format(" %2s ", " | * |");
                   /* if(animals[i].isOnStar()==true){
                        System.out.format(" %2s ", " | * |");
                    }*/
                     //System.out.format(" %2s ", "|   | \n | * | ");      
                } else if (!board.isInside(pos)) {
                    //game[i][j]=TerminalColor.BG_GREEN+"  "+TerminalColor.DEFAULT;
                    System.out.format(" %2s ", " | X |");
                    // System.out.format(" %2s ", "| X | \n | X | ");
                   
                }else if(animals[i].isOnStar()==false){
                    System.out.format(" %2s ", " | * |");
                
                 }
            
            
               /*  if(board.getSquareType(pos)!=(null)&& board.getSquareType(pos)!=(GRASS)&& board.getSquareType(pos)!=(STAR)){
                     System.out.format(" %2s ", " | * |");
                }*/
                
              //  s++;
               // }
            
                /*  if (board.isInside(pos) &&board.getSquare(pos).hasWall(SOUTH)){
                  System.out.format(" %2s ", " | _ |");
              }*/
               /* if(board.getSquares()[animals[0].getPositionOnBoard().getRow()][animals[0].getPositionOnBoard().getColumn()].hasWall(SOUTH)){
                   System.out.format(" %2s ", " | _ |");
                       
                    
                }*/
              /*if (board.isInside(pos) &&board.getSquare(pos).hasWall(SOUTH)){
                  System.out.format(" %2s ", " | _ |");
              }*/
              
        
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
    public Position askPosition(int level) {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de ligne");
        int line = kbd.nextInt();
        while (line > /*2*/Level.getLevel(level).getBoard().getNbRow()|| line < 0) {

            String message = "Le nombre saisi n'est pas correct. "
                    + "Veuillez entrer un nombre entier entre 0 et "+Level.getLevel(level).getBoard().getNbColumn()+" compris. ";
            System.out.println(message);
            line = kbd.nextInt();
        }

        Scanner kbd1 = new Scanner(System.in);
        System.out.println("Veuillez entrer un numero de colonne");
        int column = kbd1.nextInt();
        while (column > Level.getLevel(level).getBoard().getNbColumn()/*2*/ || column < 0) {

            String message = "Le nombre saisi n'est pas correct. "
                    + "Veuillez entrer un nombre entier entre 0 et "+Level.getLevel(level).getBoard().getNbColumn()+" compris. ";
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
