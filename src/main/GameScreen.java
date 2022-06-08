package main;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;


public class GameScreen extends JPanel {


    private Dimension size;

    private Game game;

    private MyMouseListener mouse;
    private KeyListener keyboard;



    public GameScreen(Game game){
        this.game = game;
        initInputs();
        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    private void initInputs() {
        mouse = new MyMouseListener(game);
        keyboard = new KeyboardListener();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(keyboard);
        requestFocus();
    }

    public void paintComponent(Graphics g){
        game.getRender().render(g);
    }

}
