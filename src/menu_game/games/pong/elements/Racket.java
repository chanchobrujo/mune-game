package menu_game.games.pong.elements;

import java.awt.*;

public class Racket extends _Element {
    private int dy = this.isAuto() ? 3 : 1;

    public Racket(int x, int y, int width, int height, boolean auto) {
        super(x, y, width, height, auto);
    }

    @Override
    public void move(boolean validUp, boolean validDown) {
        if (isAuto()) {
            this.setY(this.getY() + dy);
            if (this.collisionWithY()) dy = -dy;
        } else {
            if (validUp && this.collisionWithY(false)) decrease();
            if (validDown && this.collisionWithY(true)) increase();
        }
    }

    @Override
    public void setLIMITS(Rectangle LIMITS) {
        this.LIMITS = new Rectangle(width, ((int) LIMITS.getHeight() - height));
    }

    private boolean collisionWithY(boolean isStart) {
        return isStart ? getY() < LIMITS.getMaxY() : getY() > LIMITS.getMinY();
    }
}
