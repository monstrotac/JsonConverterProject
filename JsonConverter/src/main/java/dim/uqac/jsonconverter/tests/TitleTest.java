package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Text;
import dim.uqac.jsonconverter.Title;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TitleTest {

    Title tmpTitle = new Title("FirstTest", Color.RED,"TestFont",50);
    Title empTitle = new Title("NoSizeTest", Color.RED,"TestFont");
    @Test
    void getData() {
        assertEquals("FirstTest",tmpTitle.getData());
    }

    @Test
    void setData() {
        assertEquals("FirstTest",tmpTitle.getData());
        tmpTitle.setData("SecondTest");
        assertEquals("SecondTest",tmpTitle.getData());
    }

    @Test
    void getColor() {
        assertEquals(Color.RED,tmpTitle.getColor());
    }

    @Test
    void setColor() {
        assertEquals(Color.RED,tmpTitle.getColor());
        tmpTitle.setColor(Color.GRAY);
        assertEquals(Color.GRAY,tmpTitle.getColor());
    }

    @Test
    void getFont() {
        assertEquals("TestFont", tmpTitle.getFont());
    }

    @Test
    void setFont() {
        assertEquals("TestFont", tmpTitle.getFont());
        tmpTitle.setFont("SecondFont");
        assertEquals("SecondFont", tmpTitle.getFont());
    }

    @Test
    void getSize() {
        assertEquals(50,tmpTitle.getSize());
    }

    @Test
    void setSize() {
        assertEquals(50,tmpTitle.getSize());
        tmpTitle.setSize(40);
        assertEquals(40,tmpTitle.getSize());
    }

    @Test
    void isBold() {
        assertFalse(tmpTitle.isBold());
    }

    @Test
    void setBold() {
        assertFalse(tmpTitle.isBold());
        tmpTitle.setBold(true);
        assertTrue(tmpTitle.isBold());
    }

    @Test
    void isItalic() {
        assertFalse(tmpTitle.isItalic());
    }

    @Test
    void setItalic() {
        assertFalse(tmpTitle.isItalic());
        tmpTitle.setItalic(true);
        assertTrue(tmpTitle.isItalic());
    }

    @Test
    void isUnderlined() {
        assertFalse(tmpTitle.isUnderlined());
    }

    @Test
    void setUnderlined() {
        assertFalse(tmpTitle.isUnderlined());
        tmpTitle.setUnderlined(true);
        assertTrue(tmpTitle.isUnderlined());
    }

    @Test
    void isStrikethrough() {
        assertFalse(tmpTitle.isStrikethrough());
    }

    @Test
    void setStrikethrough() {
        assertFalse(tmpTitle.isStrikethrough());
        tmpTitle.setStrikethrough(true);
        assertTrue(tmpTitle.isStrikethrough());
    }

    @Test
    void getIdentity() {
        assertEquals("TITLE",tmpTitle.getIdentity());
    }
}