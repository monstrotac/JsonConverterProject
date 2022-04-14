package dim.uqac.jsonconverter;

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
                        case "TITLE" -> {
                            //Create the content's shape.
                            XSLFTextShape contentShape = newSlide.getPlaceholder(currentPlaceHolder);
                            //Here we clear the default title.
                            contentShape.clearText();
                            //We create a paragraph to insert the text and a new textrun.
                            XSLFTextRun r = contentShape.addNewTextParagraph().addNewTextRun();
                            //We Assign the data, color, size and font family to the textrun.
                            r.setText(((Title)item).getData());
                            r.setFontColor(((Title) item).getColor());
                            r.setFontSize(((Title)item).getSize());
                            r.setFontFamily(((Title)item).getFont());
                            //From here we apply text decorations.
                            r.setBold(((Title) item).isBold());
                            r.setItalic(((Title) item).isItalic());
                            r.setStrikethrough(((Title) item).isStrikethrough());
                            r.setUnderlined(((Title) item).isUnderlined());
                        }
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
                            //From here we apply text decorations.
                            r.setBold(((Text) item).isBold());
                            r.setItalic(((Text) item).isItalic());
                            r.setStrikethrough(((Text) item).isStrikethrough());
                            r.setUnderlined(((Text) item).isUnderlined());
                        }
                        case "LIST" -> {
                            //Create the content's shape.
                            XSLFTextShape contentShape = newSlide.getPlaceholder(currentPlaceHolder);
                            //Here we clear the default text.
                            contentShape.clearText();
                            //Here we iterate through our list, doing a similar process as before for a Text object until we no longer have to.
                            for (Content content: ((ContentList) item).getData()) {
                                //We create a paragraph and a new textrun to then insert our text.
                                XSLFTextRun r = contentShape.addNewTextParagraph().addNewTextRun();
                                //We Assign the data, color, size and font family to the textrun.
                                r.setText(((Text)content).getData());
                                r.setFontColor(((Text)content).getColor());
                                r.setFontSize(((Text)content).getSize());
                                r.setFontFamily(((Text)content).getFont());
                                //From here we apply text decorations.
                                r.setBold(((Text)content).isBold());
                                r.setItalic(((Text)content).isItalic());
                                r.setStrikethrough(((Text)content).isStrikethrough());
                                r.setUnderlined(((Text)content).isUnderlined());
                            }
                        }
                        default -> throw new IllegalStateException("Illegal content type for slide type 'TITLE_AND_CONTENT'. Content type received : " + item.getIdentity());
                    }
                    //Increment the current placeholder by one once the loop is complete, this way we know where we situate ourselves if we have to iterate again.
                    currentPlaceHolder++;
                }
            }
            case TITLE_ONLY -> {
                //Create the content's shape.
                XSLFTextShape contentShape = newSlide.getPlaceholder(currentPlaceHolder);
                //Here we clear the default title.
                contentShape.clearText();
                //We create a paragraph to insert the text and a new textrun.
                XSLFTextRun r = contentShape.addNewTextParagraph().addNewTextRun();
                //We Assign the data, color, size and font family to the textrun.
                r.setText(((Title)slideObject.getContent().get(0)).getData());
                r.setFontColor(((Title)slideObject.getContent().get(0)).getColor());
                r.setFontSize(((Title)slideObject.getContent().get(0)).getSize());
                r.setFontFamily(((Title)slideObject.getContent().get(0)).getFont());
                //From here we apply text decorations.
                r.setBold(((Title)slideObject.getContent().get(0)).isBold());
                r.setItalic(((Title)slideObject.getContent().get(0)).isItalic());
                r.setStrikethrough(((Title)slideObject.getContent().get(0)).isStrikethrough());
                r.setUnderlined(((Title)slideObject.getContent().get(0)).isUnderlined());
            }
            default -> throw new IllegalStateException("Illegal slide type provided");
        }
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