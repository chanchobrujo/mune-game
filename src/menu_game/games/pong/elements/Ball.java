package menu_game.games.pong.elements;

import java.awt.*;

public class Ball extends _Element {
    private int dx = 1, dy = 1;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height, true);
    }

    @Override
    public void move(boolean colR1, boolean colR2) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);

        if (colR1) {
            dx = -dx;
            this.setX(width);
        }

        if (colR2) {
            dx = -dx;
            this.setX(764 - width);
        }

        if (this.collisionWithX()) dx = -dx;
        if (this.collisionWithY()) dy = -dy;
    }

    @Override
    public void setLIMITS(Rectangle LIMITS) {
        int limitW = (int) LIMITS.getWidth() - width;
        int limitH = (int) LIMITS.getHeight() - height;

        this.LIMITS = new Rectangle(limitW, limitH);
    }
}
