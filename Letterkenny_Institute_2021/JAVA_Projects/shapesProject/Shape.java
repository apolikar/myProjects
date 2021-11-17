import java.awt.*;
import java.util.Random;

public abstract class Shape {

    //instance fields
    protected Color color;
    protected int xCenter;
    protected int yCenter;
    protected boolean isFilled;
    protected boolean isDisplayName;                     // boolean for display shape name or not
    protected boolean isDisplayBounding;                 // boolean for display bounding box or not ( as bounding box for Rectangle and Square it is shape itself,
                                                         // we will draw bounding box only for Quadrilateral and Circle (save resources)

    protected Point shapeCenter;                         // center point of shape
    protected Point label;                               // point for label to be drawn from
    protected BoundingBox boundingBox;                   // bounding box of shape

    // constructors
    public Shape(int xCenter, int yCenter) {
        this.color = setRandomColor();                   // if color not specified in constructor, default value will be random color
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        setupLabelPoint();
    }

    public Shape(Color color, boolean isFilled, int xCenter, int yCenter) {
        this(xCenter, yCenter);
        this.color = color;
        this.isFilled = isFilled;
    }

    //methods
    /**
     * Abstract method to draw shape.
     * @param g Graphic object.
     */
    public abstract void drawShape(Graphics g);

    /**
     * Abstract method to setup shape bounding box.
     */
    public abstract void setupBoundingBox();

    /**
     * Abstract method to setup shape center.
     */
    public abstract void setupShapeCenter();

    /**
     * Method to assign point from where label be drawn
     */
    private void setupLabelPoint() {
        label = new Point(xCenter, yCenter);
    }

    /**
     * Method generates darkish random color for shape.
     * @return random color.
     */
    private Color setRandomColor() {
        Random r = new Random();
        return new Color(r.nextInt(135),r.nextInt(135),r.nextInt(135)); // generates darkish colour to see shape lines on white panel
    }

    /**
     * Overridden to String method for console debugging(testing)
     * @return String with important shape information
     */
    @Override
    public String toString() {
        return  getClass().getName().toString() +
                "\n, color=" + color +
                "\n, isFilled=" + isFilled +
                "\n, isDisplayName=" + isDisplayName +
                "\n, isDisplayBounding=" + isDisplayBounding +
                "\n, shapeCenter=" + shapeCenter +
                "\n, boundingBox=" + boundingBox;
    }

    /**
     * Method to draw dashed bounding box around shape if shapeManager.setDisplayBoundingBox(true)
     * @param g Graphic object
     * @param x axis coordinated
     * @param y axis coordinated
     * @param width of boundingBox
     * @param height of boundingBox
     */
    protected void drawDashedBox(Graphics g, int x, int y, int width, int height) {
        int right = x + width - 1;
        int bottom = y + height - 1;

        for (int i = x; i <= right; i += 3) {     // to draw bottom and top parts of bounding box
            g.drawLine(i, y, i, y);
            g.drawLine(i, bottom, i, bottom);
        }

        for (int i = y; i <= bottom; i += 3) {    // to draw right and left parts of bounding box
            g.drawLine(x, i, x, i);
            g.drawLine(right, i, right, i);
        }
    }
}
