package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Content;
import dim.uqac.jsonconverter.Slide;
import dim.uqac.jsonconverter.Text;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest {

    Slide tmpSlide = new Slide();

    @Test
    void getLayout() {
        assertEquals(SlideLayout.BLANK,tmpSlide.getLayout());
    }

    @Test
    void setLayout() {
        assertEquals(SlideLayout.BLANK,tmpSlide.getLayout());
        tmpSlide.setLayout(SlideLayout.TITLE_AND_CONTENT);
        assertEquals(SlideLayout.TITLE_AND_CONTENT,tmpSlide.getLayout());
    }

    List<Content> data = new ArrayList<Content>();

    Slide tmpContentSlide = new Slide(SlideLayout.TITLE_AND_CONTENT,data);

    @Test
    void getContent() {
        assertEquals(data,tmpContentSlide.getContent());
    }

    @Test
    void setContent() {
        List<Content> secondData = new ArrayList<Content>();
        secondData.add(new Text("test", Color.RED,"test",50));

        tmpContentSlide.setContent(secondData);

        assertEquals(secondData,tmpContentSlide.getContent());
        assertEquals("test",((Text)tmpContentSlide.getContent().get(0)).getData());
    }
}