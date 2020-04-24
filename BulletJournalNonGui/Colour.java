public class Colour {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static String convertColour(String colour) {
        if (colour.equals("r"))
            colour = Colour.ANSI_RED;
        else if (colour.equals("y"))
            colour = Colour.ANSI_YELLOW;
        else if (colour.equals("g"))
            colour = Colour.ANSI_GREEN;
        else if (colour.equals("c"))
            colour = Colour.ANSI_CYAN;
        else if (colour.equals("b"))
            colour = Colour.ANSI_BLUE;
        else if (colour.equals("p"))
            colour = Colour.ANSI_PURPLE;

        return colour;
    }
}