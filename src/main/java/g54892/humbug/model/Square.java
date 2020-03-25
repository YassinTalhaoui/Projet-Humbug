
package g54892.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it's all.
 * A square doesn't know where it is on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Square {
    private SquareType type;

    /**
     * Constructor of Square on the board.
     * @param type Square is grass or star.
     */
    public Square(SquareType type) {
      this.type = type;
    }
    
    /**
     * Simple getter of type.
     * @return type of Square.
     */
    public SquareType getType() {
      return type;
    } 

    /**
     * Simple setter of type.
     * @param type type of square.
     */
    public void setType(SquareType type) {
        this.type = type;
    }

    @Override
    public String toString() {
       return ""+type+"";
    } 
}
