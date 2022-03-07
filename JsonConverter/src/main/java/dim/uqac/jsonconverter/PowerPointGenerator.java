package dim.uqac.jsonconverter;

import org.apache.poi.xslf.usermodel.*;

import java.awt.*;

public class PowerPointGenerator {

    //We start by inializing our variables.
    private XMLSlideShow slideShow;
    private XSLFSlideMaster defaultMaster;

    //Here we initialize our SlideShow Object and assign the defaultMaster.
    public void initializeSlideShow(){
        slideShow = new XMLSlideShow();
        defaultMaster = slideShow.getSlideMasters().get(0);
    }

    //This function is quite literally only used to parse all of the slides in the current presentation to then send them to addNewSlide().
    public void parseDataToSlides(Presentation presentation){
        presentation.slides.forEach(this::addNewSlide);
    }

    //Create and add new slides into the slideShow with the help of the slideObject data.
    public void addNewSlide(Slide slideObject){
        XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFSlide newSlide = slideShow.createSlide(layout); // Create a new slide with the previously created layout here.
        //Create the content's shapes.
        XSLFTextShape titleShape = newSlide.getPlaceholder(0);
        XSLFTextShape contentShape = newSlide.getPlaceholder(1);
        //Assign the texts to the shapes.
        titleShape.setText(slideObject.getTitle());
        contentShape.setText(slideObject.getContent());
    }

    //Getters and Setters
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
}