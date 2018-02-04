/**
 * Models a simple line. 
 * This class represents a Line object. When combined with the GameArena class,
 * instances of the Line class can be displayed on the screen.
 */
public class Line 
{
    // The following instance variables define the information needed to represent a Line
    // Feel free to more instance variables if you think it will support your work... 
    
    private double xStart;          // The X coordinate of the start of this Line
    private double xEnd;            // The X coordinate of the end of this Line 
    private double yStart;          // The X coordinate of the start of this Line
    private double yEnd;            // The X coordinate of the end of this Line 
    private double width;           // The colour of this Line
    private String colour;          // The colour of this Line

    /**
     * Obtains the X coordinte of the start of this line.
     * @return the X coordinte of the start of this line within the GameArena.
     */
    public double getStartX()
    {
        return xStart;
    }

    /**
     * Obtains the X coordinte of the end of this line.
     * @return the X coordinte of the end of this line within the GameArena.
     */
    public double getEndX()
    {
        return xEnd;
    }

    /**
     * Obtains the Y coordinte of the start of this line.
     * @return the Y coordinte of the start of this line within the GameArena.
     */
    public double getStartY()
    {
        return yStart;
    }

    /**
     * Obtains the Y coordinte of the end of this line.
     * @return the Y coordinte of the end of this line within the GameArena.
     */
    public double getEndY()
    {
        return yEnd;
    }


    /**
     * Moves the current start position of this Line to the given co-ordinates
     * @param x the new x co-ordinate of the start of this Line
     * @param y the new y co-ordinate of the start of this Line
     */
    public void setStart(double x, double y)
    {
        this.xStart = x;
        this.yStart = y;
    }

    /**
     * Moves the current end position of this Line to the given co-ordinates
     * @param x the new x co-ordinate of the end of this Line
     * @param y the new y co-ordinate of the end of this Line
     */
    public void setEnd(double x, double y)
    {
        this.xEnd = x;
        this.yEnd = y;
    }

    /**
     * Obtains the width of this Line.
     * @return the width of this Line,in pixels.
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Changes the width of this Line to the given value
     * @param w the new width of this line, in pixels.
     */
    public void setWidth(double w)
    {
        width = w;
    }

    /**
     * Obtains the colour of this Line.
     * @return a textual description of the colour of this Line.
     */
    public String getColour()
    {
        return colour;
    }

    /**
     * Changes the colour of this Line to the given value.
     * 
     * @param c The new colour of this Line. 
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
     */
    public void setColour(String c)
    {
        colour = c;
    }

    /**
     *
     * Constructor. Create a new instance of a Line.
     *
     * @param startx The X co-ordinate in the GameArena where this Line will start.
     * @param starty The Y co-ordinate in the GameArena where this Line will start.
     * @param endx The X co-ordinate in the GameArena where this Line will end.
     * @param endy The Y co-ordinate in the GameArena where this Line will end.
     * @param w The thickness of this line, in pixels
     * @param col. The colour of the Line. @see setColour for a description of permissable colours.
     *
     */
    public Line(double startX, double startY, double endX, double endY, double w, String col)
    {
        xStart = startX;
        yStart = startY;
        xEnd = endX;
        yEnd = endY;
        width = w;
        colour = col;
    }    
}
