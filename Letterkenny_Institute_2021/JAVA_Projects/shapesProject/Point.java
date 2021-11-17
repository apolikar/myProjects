public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for X axis coordinate point
     * @return int X coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for Y axis coordinate point
     * @return int Y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Method for console to represent created point.
     * @return String with x and y point coordinates.
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}