package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * This is the main class that runs the game
 */
public class Main {
    static Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static JTextField TF;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.createNewGame();
    }

    /**
     * Create a new game and launch in full screen
     * @throws IOException
     */
    public void createNewGame() throws IOException {
        JFrame F = new JFrame();
        Screen ScreenObject = new Screen();
        F.add(ScreenObject);
        F.setUndecorated(true);
        F.setSize(ScreenSize);
        F.setVisible(true);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
