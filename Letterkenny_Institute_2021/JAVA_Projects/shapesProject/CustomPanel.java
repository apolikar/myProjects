

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel  {

    private final ShapeManager sm;

    public CustomPanel(ShapeManager sm) {
        this.sm = sm;
    }

    /**
     * Method to paint component on panel
     * @param g Graphic object
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        sm.drawShapes(g);
    }



}
