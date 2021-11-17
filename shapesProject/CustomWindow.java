
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomWindow extends JFrame {

    public CustomWindow(ShapeManager sm) {
        CustomPanel mainPanel = new CustomPanel(sm);

        //add our new panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);

        mainPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {    // add mouse listener in panel

                String clickToDisplay = "Click at ";               // message to console regards click point
                String boundingToDisplay = "";                     // message when bounding box changes

                for(Shape shape : sm.getShapes()){            // iterate through shapes

                    if((e.getX() >= shape.boundingBox.getBottomLeft().getX()   &&   e.getX() <= shape.boundingBox.getTopRight().getX()) &&
                            (e.getY() >= shape.boundingBox.getTopRight().getY()   &&   e.getY() <= shape.boundingBox.getBottomLeft().getY())){  // if click is in boundary box

                        shape.isFilled = !shape.isFilled;  // assign to opposite value

                        if (e.getButton() == MouseEvent.BUTTON1 || e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3) {

                            if(e.getButton() == MouseEvent.BUTTON1) {
                                clickToDisplay = "Left Button pressed at ";
                            } else if (e.getButton() == MouseEvent.BUTTON2){
                                clickToDisplay = "Middle Button pressed at ";
                            } else {
                                clickToDisplay = "Right Button pressed at ";
                            }

                            if (shape instanceof Rectangle && e.getButton() == MouseEvent.BUTTON3){  // if right click is in Rectangle bounding box
                                ((Rectangle) shape).moveTenUnits();
                                boundingToDisplay = "\nNew " + shape.getClass().getName().toUpperCase() + " " + shape.boundingBox;
                            }

                            if(shape instanceof Quadrilateral && e.getButton() == MouseEvent.BUTTON3){  // if right click is in Quadrilateral bounding box
                                ((Quadrilateral) shape).rotateNinetyDegrees();
                                boundingToDisplay = "\nNew " + shape.getClass().getName().toUpperCase() + " " + shape.boundingBox;
                            }
                            repaint();  // repaint panel
                        }
                    }
                }
                System.out.println(clickToDisplay.substring(0, clickToDisplay.lastIndexOf(' ') + 1) + e.getPoint() + boundingToDisplay); // show where click was on panel
            }
        });
    }
}




