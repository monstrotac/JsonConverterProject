package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;

public class Main {
    public static void main(String[] args) {
        //We start by inializing our variables.
        XMLSlideShow powerPoint = new XMLSlideShow();
        powerPoint.createSlide();

        XSLFSlideMaster defaultMaster = powerPoint.getSlideMasters().get(0);
        XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

        //Here we construct our powerpoints.

    }
}
