import java.awt.*;

public abstract class AbstractMover implements Mover{
    protected int x;
    protected int y;
    protected int xDirection;
    protected int yDirection;
    protected Sprite sprite;

    // 构造方法，用于设置初始坐标和精灵
    public AbstractMover(int startX, int startY, Sprite sprite) {
        x = startX;
        y = startY;
        this.sprite = sprite;
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

    // 抽象方法，需要在子类中实现
    public abstract void draw(Graphics graphics);
}
