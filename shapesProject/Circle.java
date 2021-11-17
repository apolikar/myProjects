import java.awt.*;

public class Circle extends Shape{

    private final int radius;

    public Circle(int xCenter, int yCenter, int radius) {
        super(xCenter, yCenter);
        this.radius = radius;
        setupBoundingBox();
        setupShapeCenter();
    }

    public Circle (Color color, boolean isFilled, int xCenter, int yCenter, int radius) {
        this(xCenter, yCenter, radius);
        this.color = color;
        this.isFilled = isFilled;
    }

    /**
     * Method to draw Circle.
     * Circle might be filled/unfilled, bounding box display functionality and have a label with Circle name.
     * @param g Graphic object
     */
    @Override
    public void drawShape(Graphics g) {

        g.setColor(color);

        if(isDisplayBounding)     // draw bounding box only if shapeManager displayBoundingBox is true
            drawDashedBox(g, boundingBox.getBottomLeft().getX(), boundingBox.getTopRight().getY(), radius * 2, radius * 2);

        if(isFilled){
            g.fillOval(shapeCenter.getX(), shapeCenter.getY(), radius * 2, radius * 2);
        }
        g.drawOval(shapeCenter.getX(), shapeCenter.getY(), radius * 2, radius * 2);  // to draw circle via center point

        g.setColor(Color.gray);                              // label gray color will have better contrast and will be better readable
        if(isDisplayName)
            g.drawString(getClass().getName(), label.getX(), label.getY());
    }

    /**
     * Method setups bounding box for Circle.
     */
    @Override
    public void setupBoundingBox() {
        boundingBox = new BoundingBox(xCenter - radius,
                yCenter + radius, xCenter + radius, yCenter - radius);
    }

    /**
     * Method to assign value to a Circle center.
     */
    @Override
    public void setupShapeCenter() {
        shapeCenter = new Point(xCenter - radius, yCenter - radius);
    }

    /**
     * Overridden to String method for console debugging(testing)
     * @return String with important shape information
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n, radius=" + radius;
    }
}
