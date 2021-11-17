import javax.swing.*;
import java.awt.*;

/*
     Hi Dermot.
     I hope you are well.
     Please see my solution for CA1. If you have any questions regarding my solution please let me know apolikar1@gmail.com
     I just want to specify that if you create a shape and do not provide color and isFilled state, random color will be
     assigned to the shape and default value is assigned to isFilled.
     I guess assigning random color instead of default color gives my solution a bit of elegance.
     Also, if setDisplayBoundingBox is true, dashed bounding box is being drawn around shape.
     Thank you.

     Kind regards
     Aleksejs Polikarpovs
 */

public class Tester {
    public static void main(String[] args) {

        ShapeManager shapeManager = new ShapeManager();
        shapeManager.setDisplayName(true);
        shapeManager.setDisplayBoundingBox(false);

        // 1. Rectangle
        shapeManager.addShape(new Rectangle(50, 300, 50, 80));

        // 2. Square
        shapeManager.addShape(new Square(Color.PINK, true,250, 150, 40));

        // 3. Circle
        shapeManager.addShape(new Circle(400, 180, 50));

        // 4. Quadrilateral based on Rectangle
        Rectangle rect2 = new Rectangle(300, 275, 225, 125);
        Quadrilateral quad = new Quadrilateral(rect2);
        shapeManager.addShape(quad);

        // 5. Quadrilateral with Point array as parameter
        Point[] points = new Point[4];
        points[0] = new Point(82, 63);
        points[1] = new Point(278, 56);
        points[2] = new Point(239, 185);
        points[3] = new Point(35, 215);
        shapeManager.addShape(new Quadrilateral(Color.magenta, true, new Point(120, 100), points));

        // 6. Quadrilateral with providing each point into constructor
        shapeManager.addShape(new Quadrilateral(new Point(549, 248), new Point(513, 208), new Point(571, 193), new Point(614, 259), new Point(487, 286)));

        CustomWindow customWindow = new CustomWindow(shapeManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);

    }
}
