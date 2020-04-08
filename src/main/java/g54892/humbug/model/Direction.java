
package g54892.humbug.model;

/**
 * Direction indicates in which direction the animals
 * are going to move.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public enum Direction {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);
    
    private int deltaRow;
    private int deltaColumn;

    /**
     * Constructor for Direction.
     * @param deltaRow
     * @param deltaColumn 
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }
    
    /**
     * Simple getter of deltaRow
     * @return an integer that represents moving east or west.
     */
    public int getDeltaRow() {
        return deltaRow;
    }
    
    /**
     * Simple getter of deltaColumn.
     * @return an integer that represents moving north or south.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
    
    /**
     * Gives the opposite direction to a direction.
     * @return the opposite direction.
     */
    public Direction opposite() {
        if (null != this) switch (this) {
            case SOUTH:
                return NORTH;
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                break;
        }
        return null;
    }
}
