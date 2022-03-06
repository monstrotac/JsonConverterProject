package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.*;

import java.awt.*;

public class PowerPointGenerator {

    //We start by inializing our variables.
    private XMLSlideShow slideShow;
    private XSLFSlideMaster defaultMaster;
    private XSLFSlideLayout layout;
    //Here we construct our powerpoints.
    public void initializeSlideShow(){
        setSlideShow(new XMLSlideShow());
        getSlideShow().createSlide();
        setDefaultMaster(getSlideShow().getSlideMasters().get(0));
        setLayout(getDefaultMaster().getLayout(SlideLayout.TITLE_AND_CONTENT));
        XSLFSlide slide = getSlideShow().createSlide(getLayout());

        XSLFTextShape titleShape = slide.getPlaceholder(0);
        XSLFTextShape contentShape = slide.getPlaceholder(1);

        XSLFTextBox shape = slide.createTextBox();
        XSLFTextParagraph p = shape.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();
        r.setText("Baeldung");
        r.setFontColor(Color.green);
        r.setFontSize(24.);
    }

    public XMLSlideShow getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(XMLSlideShow slideShow) {
        this.slideShow = slideShow;
    }

    public XSLFSlideMaster getDefaultMaster() {
        return defaultMaster;
    }

    public void setDefaultMaster(XSLFSlideMaster defaultMaster) {
        this.defaultMaster = defaultMaster;
    }

    public XSLFSlideLayout getLayout() {
        return layout;
    }

    public void setLayout(XSLFSlideLayout layout) {
        this.layout = layout;
    }
}