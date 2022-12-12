package agh.ics.oop;

/**
 * The interface responsible for interacting with elements of the map.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author aglow123
 *
 */
public interface IMapElement {
    /**
     * Return position of the object.
     *
     * @return Vector2d containing position of the object.
     */
     Vector2d getPosition();

    /**
     * Return string containing representation of the object.
     *
     * @return String containing representation of the object.
     */
    String toString();

    /**
     * Return name of element.
     *
     * @return String containing name of element.
     */
    String getElementName();
}
