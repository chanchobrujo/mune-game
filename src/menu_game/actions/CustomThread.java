package menu_game.actions;

import javax.swing.*;

public class CustomThread extends Thread {
    private JPanel pongGameBoard;

    public CustomThread(JPanel pongGameBoard) {
        this.pongGameBoard = pongGameBoard;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2);
                this.pongGameBoard.repaint();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
