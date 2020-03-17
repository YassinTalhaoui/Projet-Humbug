
package g54892.humbug.model;

/**
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public abstract class Animal {
    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Constructor of Animal.
     * @param positionOnBoard the position of the animal. 
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * Simple getter of onStar.
     * @return the position of the animal.
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Simple getter of onStar.
     * @return true, if the animal is on a star square, false otherwise.
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Simple setter of positionOnBoard.
     * @param positionOnBoard the position of the animal.
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Simple setter of onStar.
     * @param onStar indicates if the animal is on a star square.
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }
    
    public abstract Position move(Board board,
            Direction direction, Animal... animals);
    
    
    
    
}
