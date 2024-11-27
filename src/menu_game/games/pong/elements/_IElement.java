package menu_game.games.pong.elements;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public interface _IElement {
    Rectangle2D getElement();

    void setLIMITS(Rectangle LIMITS);

    void move(boolean input1, boolean input2);
}
