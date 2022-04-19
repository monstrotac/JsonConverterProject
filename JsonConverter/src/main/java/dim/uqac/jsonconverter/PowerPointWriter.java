package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPointWriter {

    public final String FILE_OUT_PATH = "src\\main\\resources\\OutputFolder\\";
    public final String FILE_TYPE = ".pptx";

    //Saves the slideShow into a new Microsoft PowerPoint file with the name from the presentation.
    public void SavePowerPoint(XMLSlideShow slideShow, Presentation presentation) throws IOException {
        String fullFile = FILE_OUT_PATH+presentation.getFilename()+FILE_TYPE;
        FileOutputStream out = new FileOutputStream(fullFile);
        slideShow.write(out);
        out.close();
    }
}