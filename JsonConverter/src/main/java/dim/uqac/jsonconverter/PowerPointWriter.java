package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPointWriter {


    public void SavePowerPoint(XMLSlideShow slideShow, String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(fileName+".pptx");
        slideShow.write(out);
        out.close();
    }
}