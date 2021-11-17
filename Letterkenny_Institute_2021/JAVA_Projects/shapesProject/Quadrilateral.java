import java.awt.*;
import java.util.Arrays;

public class Quadrilateral extends Shape implements Rotatable{

    private Point[] points = new Point[4];                // array of type Point with 4 points (Quadrilateral have 4 points)

    public Quadrilateral(Point centerPoint, Point[] points) {
        super(centerPoint.getX(), centerPoint.getY());
        this.points = points;
        setupBoundingBox();
        calcBoxCenter();
        setupShapeCenter();
        remapPoints();
    }

    public Quadrilateral(Color color, boolean isFilled, Point centerPoint, Point[] points) {
        this(centerPoint, points);
        this.color = color;
        this.isFilled = isFilled;
    }

    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4){
        super(centerPoint.getX(), centerPoint.getY());
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        setupBoundingBox();
        calcBoxCenter();
        setupShapeCenter();
        remapPoints();
    }

    public Quadrilateral(Color color, boolean isFilled, Point centerPoint, Point p1, Point p2, Point p3, Point p4) {
        this(centerPoint, p1, p2, p3, p4);
        this.color = color;
        this.isFilled = isFilled;
    }

    public Quadrilateral(Rectangle rectangle){
        super(rectangle.xCenter, rectangle.yCenter);
        setRectPoints(rectangle);
        setupBoundingBox();
        setupShapeCenter();
    }

    public Quadrilateral(Color color, boolean isFilled, Rectangle rectangle){
        this(rectangle);
        this.color = color;
        this.isFilled = isFilled;
    }

    /**
     * Method populates points array with rectangular points
     * @param rectangle rectangle to populate from
     */
    private void setRectPoints(Rectangle rectangle) {
        points[0] = new Point(rectangle.boundingBox.getBottomLeft().getX(), rectangle.boundingBox.getTopRight().getY());
        points[1] = new Point(rectangle.boundingBox.getTopRight().getX(), rectangle.boundingBox.getTopRight().getY());
        points[2] = new Point(rectangle.boundingBox.getTopRight().getX(), rectangle.boundingBox.getBottomLeft().getY());
        points[3] = new Point(rectangle.boundingBox.getBottomLeft().getX(), rectangle.boundingBox.getBottomLeft().getY());
    }

    /**
     * Method calculates center of bounding box.
     * Will be used for remapping shape, to draw it from shape center point.
     * @return new Point with x and y coordinates.
     */
    private Point calcBoxCenter () {
        return new Point((boundingBox.getTopRight().getX() - (boundingBox.getTopRight().getX() - boundingBox.getBottomLeft().getX()) / 2),
                boundingBox.getTopRight().getY() + ((boundingBox.getBottomLeft().getY() - boundingBox.getTopRight().getY()) / 2)); // find center of bounding box
    }

    /**
     * Method remaps each point, to draw Quadrilateral from shape center point.
     */
    private void remapPoints() {  // method remapping each point
        Point boundingBoxCenter = calcBoxCenter(); // calculate our rotation point which is center of the bounding box
        for(int i = 0; i < points.length; i++) {
            points[i] = new Point(points[i].getX() + (shapeCenter.getX() - boundingBoxCenter.getX()), points[i].getY()+ (shapeCenter.getY() - boundingBoxCenter.getY()));
        }
    }

    /**
     * Method to draw Quadrilateral.
     * Quadrilateral might be filled/unfilled, bounding box display functionality and have a label with shape name.
     * @param g Graphic object
     */
    @Override
    public void drawShape(Graphics g) {
        int[] xPoints = new int[4];                           // array to store only x coordinates
        int[] yPoints = new int[4];                           // array to store only y coordinates

        for(int i = 0; i < points.length; i++) {
            xPoints[i] = points[i].getX();
            yPoints[i] = points[i].getY();
        }

        setupBoundingBox();
        calcBoxCenter();

        g.setColor(color);

        if(isDisplayBounding) {   // draw bounding box only if shapeManager displayBoundingBox is true
            drawDashedBox(g, boundingBox.getBottomLeft().getX(), boundingBox.getTopRight().getY(),
                    boundingBox.getTopRight().getX() - boundingBox.getBottomLeft().getX(),
                    boundingBox.getBottomLeft().getY() - boundingBox.getTopRight().getY());
        }

        if(isFilled){
            g.fillPolygon(xPoints, yPoints, 4);
        }
        g.drawPolygon(xPoints, yPoints, 4);

        g.setColor(Color.gray);
        if(isDisplayName)
            g.drawString(getClass().getName(), label.getX(), label.getY());
    }

    /**
     * Method setups bounding box based on Quadrilateral points.
     */
    @Override
    public void setupBoundingBox() {
        int minX = points[0].getX();
        int maxX = points[0].getX();
        int minY = points[0].getY();
        int maxY = points[0].getY();

        for (int i = 1; i < points.length; i++) {
            minX = Math.min(minX, points[i].getX());
            maxX = Math.max(maxX, points[i].getX());
            minY = Math.min(minY, points[i].getY());
            maxY = Math.max(maxY, points[i].getY());
        }

        boundingBox = new BoundingBox(minX, maxY, maxX, minY);
    }

    /**
     * Method to assign value to a shape center.
     */
    @Override
    public void setupShapeCenter() {
        shapeCenter = new Point(xCenter, yCenter);
    }

    /**
     * Method to rotate shape by ninety degrees.
     * All points be remapped to keep rotation from shape center.
     */
    @Override
    public void rotateNinetyDegrees() {
        float sinTheta = (float) Math.sin(Math.toRadians(90)); // formula to calculate sin theta
        float cosTheta = (float) Math.cos(Math.toRadians(90)); // formula to calculate cos theta

        for(int i = 0; i < points.length; i++) {
            int xDif = points[i].getX() - shapeCenter.getX();
            int yDif = points[i].getY() - shapeCenter.getY();
            points[i] = new Point((int) (xDif * cosTheta - yDif * sinTheta) + shapeCenter.getX(), (int) (xDif * sinTheta + yDif * cosTheta) + shapeCenter.getY());
        }
    }

    /**
     * Overridden to String method for console debugging(testing)
     * @return String with important shape information
     */
    @Override
    public String toString() {
        return super.toString() +
                "\n, points=" + Arrays.toString(points);
    }
}
