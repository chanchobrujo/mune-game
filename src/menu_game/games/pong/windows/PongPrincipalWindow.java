package menu_game.games.pong.windows;

import menu_game.actions.CustomThread;
import menu_game.actions.KeyBoardEvent;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author User
 */
public class PongPrincipalWindow extends JFrame {
    private CustomThread thread;
    private PongGameBoard board;

    public PongPrincipalWindow(boolean onePlayer) {
        this.setTitle("PONG");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(800, 500);

        this.board = new PongGameBoard(onePlayer);

        this.add(this.board);
        this.addKeyListener(new KeyBoardEvent());

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.thread = new CustomThread(this.board);
        this.thread.start();
    }
}
