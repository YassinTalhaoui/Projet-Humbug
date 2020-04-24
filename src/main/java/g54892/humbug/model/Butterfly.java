package g54892.humbug.model;

import static g54892.humbug.model.SquareType.STAR;

/**
 * This class represents grasshoppers on the board.
 *
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public class Butterfly extends Animal {

    /**
     * Constructor of Butterfly.
     */
    public Butterfly() {
    }

    /**
     * Construcor of positionOnBoard.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the given butterfly on the gaming board.
     *
     * @param board the gaming board.
     * @param direction the direction of the deplacement.
     * @param animals represents one or a lot of butterfly.
     * @return The deplacement of one of the butterly on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = super.getPositionOnBoard();
        pos=pos.next(direction).next(direction);
        for (Animal animal : animals) {
            if(!board.isInside(pos)){
                return null;
            }
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                 return pos.next(direction).next(direction);      
            }
             if (board.getSquareType(pos.next(direction)) == STAR) {
                animalToNull(direction, pos, board, animals);
            }           
        }
       return moveOneFlying(direction, board, animals).next(direction);
    }
}
