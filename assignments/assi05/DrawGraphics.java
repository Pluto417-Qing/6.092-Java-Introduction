import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<BouncingBox> boxes;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxes = new ArrayList<BouncingBox>();
        BouncingBox box1 = new BouncingBox(200, 50, Color.RED);
        BouncingBox box2 = new BouncingBox(50, 200, Color.PINK);
        BouncingBox box3 = new BouncingBox(100, 100, Color.BLUE);
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        surface.drawLine(200,100, 100,50);
        surface.drawOval(80,80,100,100);

        for(BouncingBox box : boxes){
            box.draw(surface);
        }
    }
} 