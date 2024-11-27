package menu_game.games.pong.elements;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class _Element implements _IElement {
    private int x, y;
    private final boolean auto;
    public Rectangle LIMITS;
    public final int width, height;

    public _Element(int x, int y, int width, int height, boolean auto) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.auto = auto;
    }

    @Override
    public Rectangle2D getElement() {
        return new Rectangle2D.Double(x, y, width, height);
    }

    public void decrease() {
        y--;
    }

    public void increase() {
        y++;
    }

    public boolean isAuto() {
        return auto;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean collisionWithX() {
        boolean collisionWithToStartX = this.getX() < 0;
        boolean collisionWithToEndX = this.getX() > LIMITS.getMaxX();
        return collisionWithToEndX || collisionWithToStartX;
    }

    public boolean collisionWithY() {
        boolean collisionWithToStartY = this.getY() < 0;
        boolean collisionWithToEndY = this.getY() > LIMITS.getMaxY();
        return collisionWithToEndY || collisionWithToStartY;
    }
}
