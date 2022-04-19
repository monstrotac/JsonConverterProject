package dim.uqac.jsonconverter.tests;

import dim.uqac.jsonconverter.Content;
import dim.uqac.jsonconverter.ContentList;
import dim.uqac.jsonconverter.Text;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContentListTest {

    ContentList tmpList = new ContentList(new ArrayList<Content>());



    @Test
    void getIdentity() {
        assertEquals("LIST",tmpList.getIdentity());
    }


    @Test
    void getData() {
        assertEquals(new ArrayList<Content>(),tmpList.getData());
    }
    @Test
    void setData() {
        List<Content> secondData = new ArrayList<Content>();
        secondData.add(new Text("test",Color.RED,"test",50));

        tmpList.setData(secondData);

        assertEquals(secondData,tmpList.getData());
    }



}