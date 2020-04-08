
package g54892.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it's all.
 * A square doesn't know where it is on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Square {
    private SquareType type;
    private boolean northWall;
    private boolean southWall;
    private boolean westWall;
    private boolean eastWall;

    /**
     * Constructor of Square on the board.
     * @param type Square is grass or star.
     */
    public Square(SquareType type) {
      this.type = type;
      northWall = false;
      southWall = false;
      westWall = false;
      eastWall = false;
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

    /**
     * Simple getter of northWall.
     * @return a boolean value.
     */
    public boolean isNorthWall() {
        return northWall;
    }

     /**
     * Simple getter of southWall.
     * @return a boolean value.
     */
    public boolean isSouthWall() {
        return southWall;
    }

     /**
     * Simple getter of westWall.
     * @return a boolean value.
     */
    public boolean isWestWall() {
        return westWall;
    }

     /**
     * Simple getter of eastWall.
     * @return a boolean value.
     */
    public boolean isEastWall() {
        return eastWall;
    }
    
    /**
     * Simple setter of northWall.
     * @param northWall a boolean.
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Simple setter of southWall.
     * @param southWall a boolean.
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Simple setter of westWall.
     * @param westWall a boolean.
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Simple setter of eastWall.
     * @param eastWall a boolean.
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }
    
    /**
     * Check if there is a wall in a given direction.
     * @param direction a given direction.
     * @return true if there is a wall in the given direction, false otherwise.
     */
    public boolean hasWall(Direction direction) {
        switch (direction) {
            case NORTH:
                if (northWall == true) {
                    return northWall;
                }
                break;
            case SOUTH:
                if (southWall == true) {
                     return southWall;
                }
                break;
            case EAST:
                if (eastWall == true) {
                     return eastWall;
                }
                break;
            case WEST:
                if (westWall == true) {
                     return westWall;
                }
                break;
            default:
                break;
        }
        return false;

    }
    
    /**
     * Represents an object into a String.
     * @return the String itself.
     */
    @Override
    public String toString() {
       return ""+type+"";
    } 
}
