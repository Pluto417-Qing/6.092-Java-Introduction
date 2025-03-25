import java.awt.Graphics;


public class StraightMover extends AbstractMover{

    public StraightMover(int startX, int startY, Sprite sprite) {
        super(startX, startY, sprite);
    }

    @Override
    public void draw(Graphics graphics) {
        sprite.draw(graphics, x, y);
        // Move the center of the object each time we draw it
        x += xDirection;
        y += yDirection;
    }
}
