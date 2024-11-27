package menu_game.games.pong.windows;

import menu_game.actions.KeyBoardEvent;
import menu_game.games.pong.elements.Ball;
import menu_game.games.pong.elements.Racket;
import menu_game.games.pong.elements._IElement;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.black;
import static java.awt.Color.green;
import static menu_game.core.constants.GeneralConstants.SEPARATOR;
import static menu_game.core.constants.GeneralConstants.SIZES.BALL.HEIGHT_BALL;
import static menu_game.core.constants.GeneralConstants.SIZES.BALL.WIDTH_BALL;
import static menu_game.core.constants.GeneralConstants.SIZES.RACKET.HEIGHT_RACKET;
import static menu_game.core.constants.GeneralConstants.SIZES.RACKET.WIDTH_RACKET;

public class PongGameBoard extends JPanel {
    public _IElement r1;
    public _IElement r2;
    public _IElement ball;
    public static Rectangle LIMITS;

    public final boolean onePlayer;

    public PongGameBoard(boolean onePlayer) {
        this.onePlayer = onePlayer;

        setBackground(black);
        this.ball = new Ball(382, 0, WIDTH_BALL, HEIGHT_BALL);

        this.r1 = new Racket(SEPARATOR, 200, WIDTH_RACKET, onePlayer ? (HEIGHT_RACKET * 3) : HEIGHT_RACKET, this.onePlayer);
        this.r2 = new Racket(784 - (SEPARATOR + WIDTH_RACKET), 200, WIDTH_RACKET, HEIGHT_RACKET, false);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(green);
        this.paint(g2);

        LIMITS = getBounds();
        this.update();
    }

    private void paint(Graphics2D g2) {
        g2.fill(this.ball.getElement());
        g2.fill(this.r1.getElement());
        g2.fill(this.r2.getElement());
    }

    private void update() {
        this.r1.setLIMITS(LIMITS);
        this.r2.setLIMITS(LIMITS);
        this.ball.setLIMITS(LIMITS);

        this.r1.move(KeyBoardEvent.KEY_W, KeyBoardEvent.KEY_S);
        this.r2.move(KeyBoardEvent.KEY_UP, KeyBoardEvent.KEY_DOWN);
        this.ball.move(this.collision(this.r1.getElement()), this.collision(this.r2.getElement()));
    }

    private boolean collision(Rectangle2D r) {
        return this.ball.getElement().intersects(r);
    }
}
