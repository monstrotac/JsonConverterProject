package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.*;
import dim.uqac.jsonconverter.Image;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {

    JSONReader reader = new JSONReader();

    @Test
    void generatePresentation() {
        Presentation data = reader.generatePresentation("Tests");
        //Title slide
        assertEquals(((Slide)data.slides.get(0)).getLayout(), SlideLayout.TITLE_ONLY);
        //Title type
        assertEquals(((Title)((Slide)data.slides.get(0)).getContent().get(0)).getIdentity(),"TITLE");
        //Title data
        assertEquals(((Title)((Slide)data.slides.get(0)).getContent().get(0)).getData(),"HELLO, THIS IS MY PRENSENTATION");
        //Title color
        assertEquals(((Title)((Slide)data.slides.get(0)).getContent().get(0)).getColor(), Color.WHITE);

        //Second Slide
        assertEquals(((Slide)data.slides.get(1)).getLayout(),SlideLayout.TITLE_AND_CONTENT);
        //Slide type
        assertEquals(((Title)((Slide)data.slides.get(1)).getContent().get(0)).getIdentity(),"TITLE");
        //Slide Font Size
        assertEquals(((Title)((Slide)data.slides.get(1)).getContent().get(0)).getSize(),24.0);

        //Slide type
        assertEquals(((Text)((Slide)data.slides.get(1)).getContent().get(1)).getIdentity(),"TEXT");
        //Slide Font Size
        assertEquals(((Text)((Slide)data.slides.get(1)).getContent().get(1)).getSize(),12.0);
        //Slide Is Italic
        assertEquals(((Text)((Slide)data.slides.get(1)).getContent().get(1)).isItalic(),true);
        //Slide Is Italic
        assertEquals(((Text)((Slide)data.slides.get(1)).getContent().get(1)).isBold(),false);

        //Third Slide
        assertEquals(((Slide)data.slides.get(2)).getLayout(),SlideLayout.TITLE_AND_CONTENT);
        //Slide type
        assertEquals(((Image)((Slide)data.slides.get(2)).getContent().get(1)).getIdentity(),"IMAGE");
        //Slide Image Url
        assertEquals(((Image)((Slide)data.slides.get(2)).getContent().get(1)).getImageUrl(),"https://cdn.slidemodel.com/wp-content/uploads/13071-01-folded-powerpoint-templates-1-640x360.jpg");
        //Slide Image Url
        assertEquals(((Image)((Slide)data.slides.get(2)).getContent().get(1)).getHeight(),250);

        //Forth Slide
        assertEquals(((Slide)data.slides.get(3)).getLayout(),SlideLayout.TITLE_AND_CONTENT);
        //Slide type
        assertEquals(((ContentList)((Slide)data.slides.get(3)).getContent().get(1)).getIdentity(),"LIST");
        //Slide ContentList Content type
        assertEquals(((Text)((ContentList)((Slide)data.slides.get(3)).getContent().get(1)).getData().get(0)).getIdentity(),"TEXT");
        //Slide ContentList Content data
        assertEquals(((Text)((ContentList)((Slide)data.slides.get(3)).getContent().get(1)).getData().get(0)).getData(),"R");
        //Slide ContentList Content color
        assertEquals(((Text)((ContentList)((Slide)data.slides.get(3)).getContent().get(1)).getData().get(0)).getColor(),Color.RED);



    }
}