package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.*;

public class PowerPointGenerator {

    //We start by inializing our variables.
    public XMLSlideShow slideShow;
    public XSLFSlideMaster defaultMaster;
    public XSLFSlideLayout layout;

    //Here we construct our powerpoints.
    public void initializeSlideShow(){
        slideShow = new XMLSlideShow();
        slideShow.createSlide();
        defaultMaster = slideShow.getSlideMasters().get(0);
        layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide slide = slideShow.createSlide(layout);
        XSLFTextShape titleShape = slide.getPlaceholder(0);
        XSLFTextShape contentShape = slide.getPlaceholder(1);
    }
}