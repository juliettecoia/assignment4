import java.awt.Graphics;

public class PaintPoint {
    public static final int CIRCLE_SHAPE = 0;

    private final int ptSize;

    private final int xVal;
    private final int yVal;

    public PaintPoint(int x, int y, int size) {
        xVal = x;
        yVal = y;
        ptSize = size;
    }

    public int getX() {
        return xVal;
    }

    public int getY() {
        return yVal;
    }

    public int setSize() {
        return ptSize;
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(xVal, yVal, ptSize, ptSize);

    }
}