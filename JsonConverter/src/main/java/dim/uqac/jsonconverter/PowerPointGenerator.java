package dim.uqac.jsonconverter;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.*;
import org.apache.xmlbeans.impl.common.IOUtil;

import java.awt.*;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

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
                                if (content.getIdentity() != "TEXT")
                                    throw new IllegalStateException("Only TEXT content is allowed in a list");
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
                        case "IMAGE" -> {
                            //Create the content's shape.
                            XSLFTextShape contentShape = newSlide.getPlaceholder(currentPlaceHolder);
                            //Here we clear the default text.
                            contentShape.clearText();
                            XSLFTextRun r = contentShape.addNewTextParagraph().addNewTextRun();
                            r.setText("");

                            Image img = ((Image)item);
                            byte[] pictureData = new byte[0];
                            //We add the image but before that we make sure that it even exists to be begin with.
                            try {
                                //We open the picture from the URL
                                pictureData = IOUtils.toByteArray(new URL(img.getImageUrl()).openStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                                if(img.getImageUrl().contains(".")) {
                                    String fileExtension = img.getImageUrl().substring(img.getImageUrl().lastIndexOf(".")).toLowerCase(Locale.ROOT);
                                    PictureData.PictureType fileTypeInEnumeration;
                                    //We acquire which extension type the file is using to then use it in the slide.
                                    switch (fileExtension) {
                                        case ".jpg", ".jpeg" -> {
                                            fileTypeInEnumeration = PictureData.PictureType.JPEG;
                                        }
                                        case ".png" -> {
                                            fileTypeInEnumeration = PictureData.PictureType.PNG;
                                        }
                                        case ".gif" -> {
                                            fileTypeInEnumeration = PictureData.PictureType.GIF;
                                        }
                                        case ".bmp" -> {
                                            fileTypeInEnumeration = PictureData.PictureType.BMP;
                                        }
                                        default -> throw new IllegalStateException("Unimplemented file type: " + fileExtension);
                                    }
                                    //We add picture to our slideShow and then add it to our current slide.
                                    XSLFPictureData picture = slideShow.addPicture(pictureData, fileTypeInEnumeration);
                                    XSLFPictureShape pictureShape = newSlide.createPicture(picture);
                                    //We change the position of the picture on the slide.

                                    pictureShape.setAnchor(newSlide.getPlaceholder(1).getAnchor());

                                } else throw new IllegalStateException("The URL provided is not a recognized image.");

                        }
                        default -> throw new IllegalStateException("Illegal content type for slide type 'TITLE_AND_CONTENT'. Content type received : " + item.getIdentity());
                    }
                    //Increment the current placeholder by one once the loop is complete, this way we know where we situate ourselves if we have to iterate again.
                    currentPlaceHolder++;
                }
            }
            case TITLE_ONLY -> {
                if(slideObject.getContent().get(0).getIdentity() != "TITLE")
                    throw new IllegalStateException("A 'TITLE_ONLY' SLIDE CAN ONLY ACCEPT A TITLE ELEMENT");
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