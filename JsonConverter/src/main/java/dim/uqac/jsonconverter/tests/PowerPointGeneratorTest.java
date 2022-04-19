package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.JSONReader;
import dim.uqac.jsonconverter.PowerPointGenerator;
import dim.uqac.jsonconverter.Presentation;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PowerPointGeneratorTest {
    PowerPointGenerator powerPointGenerator = new PowerPointGenerator();
    JSONReader jsonReader = new JSONReader();
    @Test
    void initializeSlideShow() {
        powerPointGenerator.initializeSlideShow();
        assertNotNull(powerPointGenerator.getSlideShow());
    }
    @Test
    void parseDataToSlides() {
        powerPointGenerator.initializeSlideShow();
        powerPointGenerator.parseDataToSlides(jsonReader.generatePresentation("Tests"));
        assertNotNull(powerPointGenerator.getSlideShow().getSlides().get(0));
    }
    @Test
    void getSlideShow() {
        powerPointGenerator.initializeSlideShow();
        assertNotNull(powerPointGenerator.getSlideShow());
    }

    @Test
    void savePowerPoint() throws IOException {
        powerPointGenerator.initializeSlideShow();
        Presentation p = jsonReader.generatePresentation("Tests");
        powerPointGenerator.parseDataToSlides(p);
        powerPointGenerator.SavePowerPoint(p);
        assertTrue(new File(powerPointGenerator.FILE_OUT_PATH + p.getFilename() + powerPointGenerator.FILE_TYPE).isFile());
    }
}