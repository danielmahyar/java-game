package main;

import inputs.KeyboardListener;
import inputs.MyMouseListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import scenes.*;


public class Game extends JFrame implements Runnable {
    private GameScreen gameScreen;
    private BufferedImage img;
    private Thread gameThread;

    private MyMouseListener mouse;
    private KeyListener keyboard;

    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;




    private final double FPS_SET = 120.0, UPS_SET = 60.0;

    public Game(){
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initClasses();
        
        add(gameScreen);
        pack();
        setVisible(true);

    }

    private void initClasses() {
        gameScreen = new GameScreen(this);
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void input(){
        
    }


    private void updateGame() {


    }



    public static void main(String[] args) {
        Game game = new Game();
        game.initInputs();
        game.start();
    }

    private void initInputs() {
        mouse = new MyMouseListener();
        keyboard = new KeyboardListener();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addKeyListener(keyboard);
        requestFocus();
    }

    private void start() {
        gameThread = new Thread(this) {};
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        int frames = 0;
        long lastTimeCheck = System.currentTimeMillis();
        long lastUpdate = System.nanoTime();
        int updates = 0;
        long lastFrame = System.nanoTime();
        long now;

        //Render
        while(true){
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                lastFrame = now;
                repaint();
                frames++;
            } else {
            }

            if(now- lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = now;
                updates++;
            }

            if(System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS = " + frames + " UPS = " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }

        }

    }
    public Render getRender(){
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }
}
