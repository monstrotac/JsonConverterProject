package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Text;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    Text tmpText = new Text("FirstTest", Color.RED,"TestFont",50);

    @Test
    void getData() {
        assertEquals("FirstTest",tmpText.getData());
    }

    @Test
    void setData() {
        assertEquals("FirstTest",tmpText.getData());
        tmpText.setData("SecondTest");
        assertEquals("SecondTest",tmpText.getData());
    }

    @Test
    void getColor() {
        assertEquals(Color.RED,tmpText.getColor());
    }

    @Test
    void setColor() {
        assertEquals(Color.RED,tmpText.getColor());
        tmpText.setColor(Color.GRAY);
        assertEquals(Color.GRAY,tmpText.getColor());
    }

    @Test
    void getFont() {
        assertEquals("TestFont", tmpText.getFont());
    }

    @Test
    void setFont() {
        assertEquals("TestFont", tmpText.getFont());
        tmpText.setFont("SecondFont");
        assertEquals("SecondFont", tmpText.getFont());
    }

    @Test
    void getSize() {
        assertEquals(50,tmpText.getSize());
    }

    @Test
    void setSize() {
        assertEquals(50,tmpText.getSize());
        tmpText.setSize(40);
        assertEquals(40,tmpText.getSize());
    }

    @Test
    void isBold() {
        assertFalse(tmpText.isBold());
    }

    @Test
    void setBold() {
        assertFalse(tmpText.isBold());
        tmpText.setBold(true);
        assertTrue(tmpText.isBold());
    }

    @Test
    void isItalic() {
        assertFalse(tmpText.isItalic());
    }

    @Test
    void setItalic() {
        assertFalse(tmpText.isItalic());
        tmpText.setItalic(true);
        assertTrue(tmpText.isItalic());
    }

    @Test
    void isUnderlined() {
        assertFalse(tmpText.isUnderlined());
    }

    @Test
    void setUnderlined() {
        assertFalse(tmpText.isUnderlined());
        tmpText.setUnderlined(true);
        assertTrue(tmpText.isUnderlined());
    }

    @Test
    void isStrikethrough() {
        assertFalse(tmpText.isStrikethrough());
    }

    @Test
    void setStrikethrough() {
        assertFalse(tmpText.isStrikethrough());
        tmpText.setStrikethrough(true);
        assertTrue(tmpText.isStrikethrough());
    }

    @Test
    void getIdentity() {
        assertEquals("TEXT",tmpText.getIdentity());
    }
}