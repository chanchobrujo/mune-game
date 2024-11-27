/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import menu_game.games.pong.windows.PongPrincipalWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author User
 */
public class MenuGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.print("=== MENU ===");
            System.out.print("\n 1.- PONG");
            System.out.print("\n 2.- TETRIS");
            System.out.print("\n Que deseas jugar?: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i = Integer.parseInt(br.readLine());
            if (i == 1) {
                PongPrincipalWindow pongPrincipalWindow = new PongPrincipalWindow(true);
            }
            if (i == 2) {
                //
            }
        } catch (Exception e) {
            System.err.println("\nOPCION INCORRECTA.");
        }
    }

}
