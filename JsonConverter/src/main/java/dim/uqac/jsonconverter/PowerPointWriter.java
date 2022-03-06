package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPointWriter {

    private final String FILE_OUT_PATH = "src\\main\\resources\\OutputFolder\\";
    private final String FILE_TYPE = ".pptx";

    public void SavePowerPoint(XMLSlideShow slideShow, String fileName) throws IOException {
        String fullFile = FILE_OUT_PATH+fileName+FILE_TYPE;
        FileOutputStream out = new FileOutputStream(fullFile);
        slideShow.write(out);
        out.close();
    }
}