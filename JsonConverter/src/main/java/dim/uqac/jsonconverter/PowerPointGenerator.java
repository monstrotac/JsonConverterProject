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
        slideShow = new XMLSlideShow();
        defaultMaster = slideShow.getSlideMasters().get(0);

        setLayout(defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT));
        XSLFSlide slide = slideShow.createSlide(layout);

        XSLFTextShape titleShape = slide.getPlaceholder(0);
        XSLFTextShape contentShape = slide.getPlaceholder(1);

        titleShape.setText("OOOOOOGA");
        contentShape.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eu iaculis nisl. Integer consequat purus sem, eget tristique velit maximus et. Praesent sit amet elit magna. Integer sed vulputate est. Donec sit amet enim est. Aliquam non rhoncus sem. Aenean fringilla metus dui, sed tincidunt lectus elementum nec. Nam tempus enim ut elementum fermentum.");

        XSLFTextBox shape = slide.createTextBox();
        XSLFTextParagraph p = shape.addNewTextParagraph();
        XSLFTextRun r = p.addNewTextRun();
        r.setText("Baeldung");
        r.setFontColor(Color.green);
        r.setFontSize(24.);
    }

    public void parseDataToSlides(){

    }

    public void createTitleAndContent(){

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