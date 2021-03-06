package dim.uqac.jsonconverter;

import java.io.IOException;

/**
 * The Main Class acts as the father/mother of all classes.
 * It handles the creation and call of methods required to conceive the presentation file.
 */
//GITHUB: https://github.com/monstrotac/JsonConverterProject
public class Main {
    /**
     * This is the Main method, it takes care of calling our program methods.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //Here we initialize the JSON array and send the data in a new presentation.
        JSONReader jsonReader = new JSONReader();
        Presentation presentation = jsonReader.generatePresentation("Data");
        //Over here we initialize the PowerPointGeneratorObject and parse the data from the presentation field which will in turn generate the powerpoint slides.
        PowerPointGenerator pointGenerator = new PowerPointGenerator();
        pointGenerator.initializeSlideShow();
        pointGenerator.parseDataToSlides(presentation);
        //Saves the file in the resources's OutputFolder.
        pointGenerator.SavePowerPoint(presentation);

    }
}
