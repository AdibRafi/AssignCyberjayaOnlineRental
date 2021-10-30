import Ariez.MainDisplay;

import java.io.IOException;

/**
 * Represent the start of the program
 * @author Adib
 */
public class startProgram {
    /**
     * Start of the program
     * @throws IOException Occurred when I/O operations is interrupted or failed
     * @author Adib
     */
    public static void main(String[] args) throws IOException {
        new MainDisplay(false, MainDisplay.resetAllInfo(),"TN0000");
    }
}
