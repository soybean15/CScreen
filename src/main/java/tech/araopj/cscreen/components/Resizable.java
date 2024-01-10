package tech.araopj.cscreen.components;

/**
 * The `Resizable` interface defines methods for setting width and height.
 * Classes implementing this interface can be resized dynamically.
 */
public interface Resizable {

    /**
     * Sets the width of the resizable object.
     *
     * @param width The new width to be set.
     */
    void setWidth(int width);

    /**
     * Sets the height of the resizable object.
     *
     * @param height The new height to be set.
     */
    void setHeight(int height);
}
