
package g54892.humbug.view.text;


import g54892.humbug.model.Animal;
import g54892.humbug.model.Board;
import g54892.humbug.model.Direction;
import g54892.humbug.model.Position;

/**
 * 
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public interface InterfaceView{
    
    /**
     * 
     * @param board 
     */
    void displayBoard(Board board, Animal... animals);

    /**
     *
     * @return 
     */
    Position askPosition();
    
    /**
     *
     * @return 
     */
    Direction askDirection();
        
    /**
     *
     * @param s
     */
    void displayError(String s);
        
      

}
    
            