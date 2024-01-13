package me.araopj.cscreen.components;

import me.araopj.cscreen.classes.CharSets;

/**
 * The abstract class `Components` serves as a base class for screen components.
 * It contains common properties and methods that subclasses must implement.
 */
abstract class Components {

    // Row and column positions of the component
    protected int r;
    protected int c;

    // Character sets used for drawing components
    protected CharSets charSets;

    /**
     * Abstract method to place the component on the screen.
     * Subclasses must implement this method to define their specific placement logic.
     *
     * @param screen The `Screen` object on which the component is placed.
     */
    abstract void place(Screen screen);

    // The following commented code is an example of potential properties for drawing components
    // You can uncomment and modify these properties based on the desired appearance of the components.

    /*
        Example using Unicode box-drawing characters

        protected char horizontal = '┈';
        protected char vertical = '│';
        char[] corners = {'╭','╮','╰','╯'};

        Example using simple ASCII characters

        protected char horizontal = '-';
        protected char vertical = '|';
        char[] corners = {'+','+','+','+'};
     */

}
