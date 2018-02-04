/**
 * Models a single line of text. 
 * This class represents a Text object. When combined with the GameArena class,
 * instances of the Text class can be displayed on the screen.
 */
public class Text 
{
    // The following instance variables define the information needed to represent a Text
    // Feel free to more instance variables if you think it will support your work... 
    
    private double xPosition;           // The X coordinate of this Text
    private double yPosition;           // The Y coordinate of this Text
    private double size;                // The diameter of this Text
    private String colour;              // The colour of this Text
    private String text;                // The text to display 
                                       

    /**
     * Obtains the current position of this Text.
     * @return the X coordinate of this Text within the GameArena.
     */
    public double getXPosition()
    {
        return xPosition;
    }

    /**
     * Obtains the current position of this Text.
     * @return the Y coordinate of this Text within the GameArena.
     */
    public double getYPosition()
    {
        return yPosition;
    }

    /**
     * Moves the current position of this Text to the given co-ordinates
     * @param x the new x co-ordinate of this Text
     */
    public void setXPosition(double x)
    {
        this.xPosition = x;
    }

    /**
     * Moves the current position of this Text to the given co-ordinates
     * @param y the new y co-ordinate of this Text
     */
    public void setYPosition(double y)
    {
        this.yPosition = y;
    }

    /**
     * Obtains the size of this Text.
     * @return the diameter of this Text,in pixels.
     */
    public double getSize()
    {
        return size;
    }

    /** 
     * Changes the size of this Text to the given value.
     * @param s The new size of the Text.
     */
    public void setSize(double s)
    {
        size = s;
    }

    /**
     * Obtains the actual text this object displays.
     * @return a String contianing the text that this object shows.
     */
    public String getText()
    {
        return text;
    }

    /** 
     * Changes the text that this object displays.
     * @param s The new text to display.
     */
    public void setText(String s)
    {
        text = s;
    }

    /**
     * Obtains the colour of this Text.
     * @return a textual description of the colour of this Text.
     */
    public String getColour()
    {
        return colour;
    }

    /**
     * Changes the colour of this Text to the given value.
     * 
     * @param c The new colour of this Text. 
     * <BR><BR>
     * Permissable values are 8 bit hexadecimal RGB values in the format #RRGGBB. e.g.  
     * Pure red is "#FF0000"   <BR>
     * Pure green is "#00FF00" <BR>
     * Pure blue is "#0000FF"  <BR>
     * <BR>
     * Alternativley, named colours are also allowed for the following list. e.g. "AQUA" :
     * <BR><BR>
     * ALICEBLUE ANTIQUEWHITE AQUA AQUAMARINE AZURE BEIGE BISQUE BLACK BLANCHEDALMOND BLUE BLUEVIOLET BROWN BURLYWOOD CADETBLUE CHARTREUSE CHOCOLATE CORAL
     * CORNFLOWERBLUE CORNSILK CRIMSON CYAN DARKBLUE DARKCYAN DARKGOLDENROD DARKGRAY DARKGREEN DARKGREY DARKKHAKI DARKMAGENTA DARKOLIVEGREEN DARKORANGE DARKORCHID
     * DARKRED DARKSALMON DARKSEAGREEN DARKSLATEBLUE DARKSLATEGRAY DARKSLATEGREY DARKTURQUOISE DARKVIOLET DEEPPINK DEEPSKYBLUE DIMGRAY DIMGREY DODGERBLUE FIREBRICK
     * FLORALWHITE FORESTGREEN FUCHSIA GAINSBORO GHOSTWHITE GOLD GOLDENROD GRAY GREEN GREENYELLOW GREY HONEYDEW HOTPINK INDIANRED INDIGO IVORY KHAKI LAVENDER LAVENDERBLUSH
     * LAWNGREEN LEMONCHIFFON LIGHTBLUE LIGHTCORAL LIGHTCYAN LIGHTGOLDENRODYELLOW LIGHTGRAY LIGHTGREEN LIGHTGREY LIGHTPINK LIGHTSALMON LIGHTSEAGREEN LIGHTSKYBLUE LIGHTSLATEGRAY
     * LIGHTSLATEGREY LIGHTSTEELBLUE LIGHTYELLOW LIME LIMEGREEN LINEN MAGENTA MAROON MEDIUMAQUAMARINE MEDIUMBLUE MEDIUMORCHID MEDIUMPURPLE MEDIUMSEAGREEN MEDIUMSLATEBLUE
     * MEDIUMSPRINGGREEN MEDIUMTURQUOISE MEDIUMVIOLETRED MIDNIGHTBLUE MINTCREAM MISTYROSE MOCCASIN NAVAJOWHITE NAVY OLDLACE OLIVE OLIVEDRAB ORANGE ORANGERED ORCHID
     * PALEGOLDENROD PALEGREEN PALETURQUOISE PALEVIOLETRED PAPAYAWHIP PEACHPUFF PERU PINK PLUM POWDERBLUE PURPLE RED ROSYBROWN ROYALBLUE SADDLEBROWN SALMON SANDYBROWN
     * SEAGREEN SEASHELL SIENNA SILVER SKYBLUE SLATEBLUE SLATEGRAY SLATEGREY SNOW SPRINGGREEN STEELBLUE TAN TEAL THISTLE TOMATO TURQUOISE VIOLET WHEAT WHITE
     * WHITESMOKE YELLOW YELLOWGREEN.
     *
     */

    public void setColour(String c)
    {
        colour = c;
    }

    /**
     *
     * Constructor. Create a new instance of a Text.
     *
     * @param s The text to display
     * @param x The X co-ordinate in the GameArena where this Text will initially be located.
     * @param y The Y co-ordinate in the GameArena where this Text will initially be located.
     * @param s The size of the Text in pixels.
     * @param col. The colour of the Text. @see setColour for a description of permissable colours.
     *
     */
    public Text(String s, double x, double y, double diameter, String col)
    {
        text = s;
        xPosition = x;
        yPosition = y;
        size = diameter;
        colour = col;
    }    
}

