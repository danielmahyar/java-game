package scenes;

import main.Game;
import ui.MyButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import static main.GameState.*;

public class Menu extends GameScene implements SceneMethods {

    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private BufferedImage img;
    private Random random;
    private MyButton bPlaying, bSettings, bQuit;

    public Menu(Game game) {
        super(game);
        importImage();
        loadSprites();
        initButtons();
        random = new Random();
    }

    private void initButtons() {

        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y  =150;
        int yOffset = 100;

        bPlaying = new MyButton("Play", x, y, w, h);
        bSettings = new MyButton("Settings", x, y + yOffset, w, h);
        bQuit = new MyButton("Quit", x, y + yOffset * 2, w, h);
    }

    public void render(Graphics g){
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bSettings.draw(g);
        bQuit.draw(g);
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/res/spriteatlas.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadSprites() {
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                sprites.add(
                        img.getSubimage(32 * x, 32 * y, 32, 32)
                );
            }
        }
    }

    private int getRndInt(){
        return random.nextInt(20);
    }

    public void mouseClicked(int x, int y) {
        if(bPlaying.getBounds().contains(x, y)){
            SetGameState(PLAYING);
        }
        if(bSettings.getBounds().contains(x, y)){
            SetGameState(SETTINGS);
        }
        if(bQuit.getBounds().contains(x, y)){
            SetGameState(QUIT);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(
                bPlaying.getBounds().contains(x, y)
        );
        bSettings.setMouseOver(
                bSettings.getBounds().contains(x, y)
        );
        bQuit.setMouseOver(
                bQuit.getBounds().contains(x, y)
        );
    }

    @Override
    public void mousePressed(int x, int y) {
        bPlaying.setMousePressed(
                bPlaying.getBounds().contains(x, y)
        );
        bSettings.setMousePressed(
                bSettings.getBounds().contains(x, y)
        );
        bQuit.setMousePressed(
                bQuit.getBounds().contains(x, y)
        );
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
    }
}
