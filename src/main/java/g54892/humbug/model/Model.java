
package g54892.humbug.model;

/**
 * Defines the methods
 * that must be implemented by the Game class
 * @author Talhaoui Yassin (YT) <54892@etu.he2b.be>
 */
public interface Model {
    Board getBoard();

    Animal[] getAnimals();

    void startLevel(int level);

    boolean levelIsOver();

    void move(Position position, Direction direction);

    
}
