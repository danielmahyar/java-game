package main;

import javax.swing.*;
import java.awt.*;


public class GameScreen extends JPanel {


    private Dimension size;

    private Game game;


    public GameScreen(Game game){
        this.game = game;
        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        game.getRender().render(g);
    }

}
