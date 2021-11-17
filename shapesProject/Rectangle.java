import java.awt.*;

public class Rectangle extends Shape implements Moveable{

    private final int width;
    private final int height;

    public Rectangle(int xCenter, int yCenter, int width, int height) {
        super(xCenter, yCenter);
        this.width = width;
        this.height = height;
        setupBoundingBox();
        setupShapeCenter();
    }

    public Rectangle(Color color, boolean isFilled, int xCenter, int yCenter, int width, int height) {
       this(xCenter, yCenter, width, height);
       this.color = color;
       this.isFilled = isFilled;
    }

    /**
     * Method to draw Rectangle (or Square as it is inherits from Rectangular).
     * Shape might be filled/unfilled and have a label with shape name.
     * @param g Graphic object
     */
    @Override
    public void drawShape(Graphics g) {

        g.setColor(color);
        if(isFilled){
            g.fillRect(shapeCenter.getX(), shapeCenter.getY(), width,height);
        }
        g.drawRect(shapeCenter.getX(), shapeCenter.getY(), width,height);  // to draw rectangle via center point

        g.setColor(Color.gray);                                            // label gray color will have better contrast and will be better readable
        if(isDisplayName)
            g.drawString(getClass().getName(), label.getX(), label.getY());

    }

    /**
     * Method to set up BoundingBox for shape (Rectangular or Square).
     */
    @Override
    public void setupBoundingBox() {
        boundingBox = new BoundingBox(xCenter - width / 2, yCenter + height / 2,
                xCenter + width / 2, yCenter - height / 2);
    }

    /**
     * Method to assign value to a shape center.
     */
    @Override
    public void setupShapeCenter() {
        shapeCenter = new Point(xCenter - width / 2, yCenter - height / 2);
    }

    /**
     * Method to move Rectangle or Square on X axis forward by 10 units.
     * Each time shape is moved new shape center, bounding box and label will be calculated.
     */
    @Override
    public void moveTenUnits() {
        shapeCenter = new Point(shapeCenter.getX() + 10, shapeCenter.getY());
        boundingBox = new BoundingBox(boundingBox.getBottomLeft().getX() + 10,
                boundingBox.getBottomLeft().getY(), boundingBox.getTopRight().getX() + 10, boundingBox.getTopRight().getY());
        label = new Point(label.getX() + 10, label.getY());
    }

    /**
     * Overridden to String method for console debugging(testing)
     * @return String with important shape information
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n, width=" + width  +
                "\n, height=" + height;
    }
}
