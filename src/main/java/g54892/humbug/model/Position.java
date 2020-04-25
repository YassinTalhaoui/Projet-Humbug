package g54892.humbug.model;

/**
 * Position represents our current position on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Position {

    private int row;
    private int column;

    /**
     * Constructor of Position.
     */
    public Position() {

    }

    /**
     * Constructor of Position on the board.
     *
     * @param row an integer that represents the row.
     * @param column integer that represents the column.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Simple getter of row.
     *
     * @return row of Position.
     */
    public int getRow() {
        return row;
    }

    /**
     * Simple getter of column.
     *
     * @return column of Position.
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return the hash code of a Position.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.row;
        hash = 97 * hash + this.column;
        return hash;
    }

    /**
     * Determines if two positions are equal.
     *
     * @param obj
     * @return true if the positions are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     * This object (which is already a string!) is itself returned.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return "Position{" + "row=" + row + ", column=" + column + '}';
    }

    /**
     * returns the position north, south, east, west of our position.
     *
     * @param direction a direction among the 4.
     * @return the position that comes next the current position.
     */
    public Position next(Direction direction) {
        return new Position(row + direction.getDeltaRow(),
                column + direction.getDeltaColumn());
    }
}
