package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Image;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    Image tmpImage = new Image("FirstTest",50,50,50,50);

    @Test
    void getImageUrl() {
        assertEquals("FirstTest",tmpImage.getImageUrl());
    }

    @Test
    void setImageUrl() {
        assertEquals("FirstTest",tmpImage.getImageUrl());
        tmpImage.setImageUrl("UpdateTest");
        assertEquals("UpdateTest",tmpImage.getImageUrl());
    }

    @Test
    void getHeight() {
        assertEquals(50,tmpImage.getHeight());
    }

    @Test
    void setHeight() {
        assertEquals(50,tmpImage.getHeight());
        tmpImage.setHeight(90);
        assertEquals(90,tmpImage.getHeight());
    }

    @Test
    void getWidth() {
        assertEquals(50,tmpImage.getWidth());
    }

    @Test
    void setWidth() {
        assertEquals(50,tmpImage.getWidth());
        tmpImage.setWidth(90);
        assertEquals(90,tmpImage.getWidth());
    }

    @Test
    void getX() {
        assertEquals(50,tmpImage.getX());
    }

    @Test
    void setX() {
        assertEquals(50,tmpImage.getX());
        tmpImage.setX(90);
        assertEquals(90,tmpImage.getX());
    }

    @Test
    void getY() {
        assertEquals(50,tmpImage.getY());
    }

    @Test
    void setY() {
        assertEquals(50,tmpImage.getY());
        tmpImage.setY(90);
        assertEquals(90,tmpImage.getY());
    }

    @Test
    void getIdentity() {
        assertEquals("IMAGE",tmpImage.getIdentity());
    }
}