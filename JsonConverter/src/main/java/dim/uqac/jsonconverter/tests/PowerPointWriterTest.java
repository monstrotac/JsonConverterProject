package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.JSONReader;
import dim.uqac.jsonconverter.PowerPointGenerator;
import dim.uqac.jsonconverter.PowerPointWriter;
import dim.uqac.jsonconverter.Presentation;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PowerPointWriterTest {
    PowerPointWriter pointWriter = new PowerPointWriter();
    PowerPointGenerator pointGenerator = new PowerPointGenerator();
    JSONReader jsonReader = new JSONReader();

    @Test
    void savePowerPoint() throws IOException {
        pointGenerator.initializeSlideShow();
        Presentation p = jsonReader.generatePresentation("Tests");
        pointGenerator.parseDataToSlides(p);
        pointWriter.SavePowerPoint(pointGenerator.getSlideShow(), p);
        assertTrue(new File(pointWriter.FILE_OUT_PATH + p.getFilename() + pointWriter.FILE_TYPE).isFile());
    }
}