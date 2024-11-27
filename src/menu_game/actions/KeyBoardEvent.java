package menu_game.actions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardEvent extends KeyAdapter {
    public static boolean KEY_W, KEY_S, KEY_UP, KEY_DOWN;

    @Override
    public void keyPressed(KeyEvent event) {
        int id = event.getKeyCode();

        KEY_W = (id == KeyEvent.VK_W);
        KEY_S = (id == KeyEvent.VK_S);
        KEY_UP = (id == KeyEvent.VK_UP);
        KEY_DOWN = (id == KeyEvent.VK_DOWN);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int id = event.getKeyCode();

        if (id == KeyEvent.VK_W) KEY_W = false;
        if (id == KeyEvent.VK_S) KEY_S = false;

        if (id == KeyEvent.VK_UP) KEY_UP = false;
        if (id == KeyEvent.VK_DOWN) KEY_DOWN = false;
    }
}
