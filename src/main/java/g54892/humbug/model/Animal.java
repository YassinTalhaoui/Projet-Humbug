
package g54892.humbug.model;

/**
 * Represents the different animals that are moving 
 * in the gaming board.
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
     * Simple getter of positionOnBoard.
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
    
    /**
     * Moves animals on the gaming board.
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals the given animals.
     * @return the movement of the animals on the board.
     */
    public abstract Position move(Board board,
            Direction direction, Animal... animals);
    
}
