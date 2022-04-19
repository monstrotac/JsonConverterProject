package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Presentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest {

    Presentation tmpPresentation = new Presentation("TestFile");

    @Test
    void getFilename() {
        assertEquals("TestFile",tmpPresentation.getFilename());
    }

    @Test
    void setFilename() {
        assertEquals("TestFile",tmpPresentation.getFilename());
        tmpPresentation.setFilename("NewTestFile");
        assertEquals("NewTestFile",tmpPresentation.getFilename());
    }
}