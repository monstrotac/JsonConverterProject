package dim.uqac.jsonconverter;

import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.Console;

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
        int currentPlaceHolder = 0; // This field is used in order to know exactly where we situate ourselves in the content loop.
        XSLFSlideLayout layout = defaultMaster.getLayout(slideObject.getLayout());// We query the system to discover which layout the slide is going to have.
        XSLFSlide newSlide = slideShow.createSlide(layout); // Create a new slide with the previously created layout here.
        switch (slideObject.getLayout()) {
            case TITLE_AND_CONTENT -> {
                //Iterate to find out what content the program has to inject in the slide to then inject it in the slide.
                for (Content item: slideObject.getContent()) {
                    switch (item.getIdentity()){
                        case "TEXT" -> {
                            //Create the content's shape.
                            XSLFTextShape contentShape = newSlide.getPlaceholder(currentPlaceHolder);
                            //Here we clear the default text.
                            contentShape.clearText();
                            //We create a paragraph and a new textrun to then insert our text.
                            XSLFTextRun r = contentShape.addNewTextParagraph().addNewTextRun();
                            //We Assign the data, color, size and font family to the textrun.
                            r.setText(((Text)item).getData());
                            r.setFontColor(((Text) item).getColor());
                            r.setFontSize(((Text)item).getSize());
                            r.setFontFamily(((Text)item).getFont());

                        }
                        case "IMAGE" -> {}
                        case "TABLE" -> {}
                        case "GRAPH" -> {}
                    }
                    //Increment the current placeholder by one once the loop is complete, this way we know where we situate ourselves if we have to iterate again.
                    currentPlaceHolder++;
                }
            }
            case TITLE_ONLY -> {
                //We create the title element and assign text to it.
                XSLFTextBox contentShape = (XSLFTextBox) newSlide.getPlaceholder(currentPlaceHolder);
                //Assign the data, color, size and font to the shape.
                contentShape.setText(((Text)(slideObject.getContent().get(0))).getData());
            }
        }
        //Create the content's shapes.`

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