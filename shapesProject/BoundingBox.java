public class BoundingBox {

    private final Point bottomLeft;
    private final Point topRight;

    public BoundingBox(int xBottomLeft, int yBottomLeft, int xTopRight, int yTopRight) {
        this.bottomLeft = new Point(xBottomLeft, yBottomLeft);
        this.topRight = new Point(xTopRight, yTopRight);
    }

    public  BoundingBox(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    /**
     * Getter for bottom left point.
     * @return bottom left point.
     */
    public Point getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Getter for top right point.
     * @return top right point.
     */
    public Point getTopRight() {
        return topRight;
    }

    /**
     * Method for console to represent created bounding box result.
     * @return String bounding box bottom left and top right coordinates.
     */
    @Override
    public String toString(){
        return "BOUNDING_BOX: BoundingBox{bottomLeft = " + bottomLeft.toString() + ", topRight = " + topRight.toString();
    }

}