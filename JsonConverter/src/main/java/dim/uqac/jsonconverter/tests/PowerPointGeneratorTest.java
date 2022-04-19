package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.JSONReader;
import dim.uqac.jsonconverter.PowerPointGenerator;
import dim.uqac.jsonconverter.Presentation;
import org.junit.jupiter.api.Test;

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
}