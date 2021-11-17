import java.awt.*;

public class Square  extends Rectangle{

    /*
        * To create Square we can reuse Rectangle constructor.
        * Square have 4 identical sides.
        * Instead of providing height in constructor, width is provided twice.
     */

    public Square(int xCenter, int yCenter, int width) {
        super(xCenter, yCenter, width, width);
    }

    public Square(Color color, boolean isFilled, int xCenter, int yCenter, int width) {
        super(color, isFilled, xCenter, yCenter, width, width);
    }

}
