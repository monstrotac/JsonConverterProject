package dim.uqac.jsonconverter;

import java.io.IOException;
//GITHUB: https://github.com/monstrotac/JsonConverterProject
public class Main {
    public static void main(String[] args) throws IOException {
        //Here we initialize the JSON array and send the data in a new presentation.
        JSONReader jsonReader = new JSONReader();
        Presentation presentation = jsonReader.generatePresentation("Data");
        //Over here we initialize the PowerPointGeneratorObject and parse the data from the presentation field which will in turn generate the powerpoint slides.
        PowerPointGenerator pointGenerator = new PowerPointGenerator();
        pointGenerator.initializeSlideShow();
        pointGenerator.parseDataToSlides(presentation);
        //Saves the file in the resources's OutputFolder.
        PowerPointWriter pointWriter = new PowerPointWriter();
        pointWriter.SavePowerPoint(pointGenerator.getSlideShow(), presentation);

    }
}
