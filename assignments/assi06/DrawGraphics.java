import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movers = new ArrayList<Mover>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box1 = new Rectangle(15, 20, Color.RED);
        Oval box2 = new Oval(100,100,Color.PINK);
        Rectangle strai1 = new Rectangle(25,10,Color.GRAY);
        Oval strai2 = new Oval(10,10,Color.green);

        movers.add(new Bouncer(100, 170, box1));
        movers.add(new Bouncer(200, 100, box2));
        movers.add(new StraightMover(40,60,strai1));
        movers.add(new StraightMover(40,60,strai2));

        movers.get(0).setMovementVector(3, 1);
        movers.get(1).setMovementVector(-2, 1);
        movers.get(2).setMovementVector(3, 1);
        movers.get(3).setMovementVector(-2, 1);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for(Mover sprite : movers){
            sprite.draw(surface);
        }
    }
}
