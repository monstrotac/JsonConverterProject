package dim.uqac.jsonconverter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JSONReader jsonReader = new JSONReader();
        Presentation presentation = jsonReader.generatePresentation("Data");

        PowerPointGenerator pointGenerator = new PowerPointGenerator();
        pointGenerator.initializeSlideShow();
        pointGenerator.parseDataToSlides(presentation);

        PowerPointWriter pointWriter = new PowerPointWriter();
        pointWriter.SavePowerPoint(pointGenerator.getSlideShow(), presentation);

    }
}
