import java.awt.*;
import java.util.ArrayList;

public class ShapeManager {

    private final ArrayList<Shape> shapes;          // array list of type Shape
    private boolean displayName;                    // boolean to display or not shape name
    private boolean displayBoundingBox;             // boolean to display or not bounding box in a console

    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    /**
     * Setter for displayBoundingBox
     * @param displayBoundingBox  boolean
     */
    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }

    /**
     * Setter for displayName
     * @param displayName boolean
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    /**
     * Method to add shapes in arrayList
     * @param shape Shape to add into arrayList
     */
    public void addShape(Shape shape){
        shapes.add(shape);
        if(displayBoundingBox) {
            shape.isDisplayBounding = true;
            System.out.println(shape.getClass().getName().toUpperCase() + " " + shape.boundingBox);
        }
    }

    /**
     * Getter for arrayList of type Shape
     * @return arrayList with shapes
     */
    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    /**
     * Method to iterate through shapes arrayList.
     * On each iteration shape will be drawn.
     * @param graphicContext Graphics object
     */
    public void drawShapes(Graphics graphicContext) {
        for(Shape shape : shapes) {
            shape.isDisplayName = displayName;
            shape.drawShape(graphicContext);
        }
    }

    /**
     * Method returns displayBoundingBox boolean value
     * @return displayBoundingBox boolean
     */
    public boolean isDisplayBoundingBox() {
        return displayBoundingBox;
    }
}
