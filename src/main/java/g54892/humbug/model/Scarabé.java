/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.humbug.model;

/**
 *
 * @author Yassin
 */
public class Scarabé extends Animal {

    /**
     * Constructor of Scarabé.
     *
     * @param positionOnBoard the current position of the animals.
     */
    public Scarabé(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     *
     * @param board the gaming board.
     * @param direction the direction of the movement.
     * @param animals the animals on the board.
     * @return the new position of the Scarabé.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position pos = getPositionOnBoard();
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(pos.next(direction))) {
                animals[1].move(board, direction, animals).next(direction);
                return animal.getPositionOnBoard().next(direction);
            }
        }
        return moveOneCrawling(board, direction, animals);
    }

}
