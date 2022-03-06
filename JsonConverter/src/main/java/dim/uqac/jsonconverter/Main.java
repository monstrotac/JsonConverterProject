package dim.uqac.jsonconverter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        PowerPointGenerator pointGenerator = new PowerPointGenerator();
        pointGenerator.initializeSlideShow();
        PowerPointWriter pointWriter = new PowerPointWriter();
        pointWriter.SavePowerPoint(pointGenerator.getSlideShow(), "BingChilling");

    }
}
