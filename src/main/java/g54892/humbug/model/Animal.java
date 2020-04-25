package g54892.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import static g54892.humbug.model.SquareType.GRASS;
import static g54892.humbug.model.SquareType.STAR;

@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})

/**
 * Represents the different animals that are moving in the gaming board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Constructor of Animal.
     */
    public Animal() {
    }

    /**
     * Constructor of Animal.
     *
     * @param positionOnBoard the position of the animal.
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * Simple getter of positionOnBoard.
     *
     * @return the position of the animal.
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Simple getter of onStar.
     *
     * @return true, if the animal is on a star square, false otherwise.
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Simple setter of positionOnBoard.
     *
     * @param positionOnBoard the position of the animal.
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Simple setter of onStar.
     *
     * @param onStar indicates if the animal is on a star square.
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Moves animals on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals the given animals.
     * @return the movement of the animals on the board.
     */
    public abstract Position move(Board board,
            Direction direction, Animal... animals);

    /**
     * Moves ramping animals on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of animals.
     * @return The deplacement of one of the ramping animals on the board.
     */
    protected Position moveOneCrawling(Board board,
            Direction direction, Animal... animals) {
        Position pos = getPositionOnBoard();
        for (Animal animal : animals) {
            if (board.getSquare(pos).hasWall(direction)) {
                return nextWall(board, direction, animals);
            }
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                return pos;
            } else if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (board.getSquare(pos.next(direction)).hasWall(direction.opposite())) {
                return pos;
            }
            if (board.getSquareType(pos.next(direction)).equals(STAR)) {
                this.animalToNull(direction, pos, board, animals);
            }
        }
        return pos.next(direction);
    }

    /**
     * Moves flying animals on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of animals.
     * @return The deplacement of one of the flying animals on the board.
     */
    protected Position moveOneFlying(Direction direction, Board board, Animal... animals) {
        Position pos = getPositionOnBoard();
        pos = pos.next(direction);
        for (Animal animal : animals) {
            if (!board.isInside(pos.next(direction))) {
                return null;
            }
            if (board.getSquareType(pos.next(direction)).equals(STAR)) {
                animal.setOnStar(true);
                if (isOnStar()) {
                    board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                    this.animalToNull(direction, pos, board, animals);
                }
            }
        }
        return pos.next(direction);
    }

    /**
     * Nullifies an animal if it's on a star.
     *
     * @param board the gaming board.
     * @param pos a given Position.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of animals.
     */
    protected void animalToNull(Direction direction, Position pos, Board board, Animal... animals) {
        for (Animal animal : animals) {
            animal.setOnStar(true);
            if (animal.isOnStar()) {
                board.getSquares()[pos.next(direction).getRow()][pos.next(direction).getColumn()].setType(GRASS);
                animal = null;
            }
        }
    }

    /**
     * Returns the same position if there is a wall in the given direction?
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of animals.
     * @return the new position.
     */
    protected Position nextWall(Board board, Direction direction, Animal... animals) {
        int i = 0;
        while (i < animals.length) {
            Position posi = animals[i].getPositionOnBoard();
            if (board.getSquare(posi).hasWall(direction)) {
                return posi;
            }
            i++;
        }
        return null;
    }
}
