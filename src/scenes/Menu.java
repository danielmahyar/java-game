package scenes;

import main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Menu extends GameScene {

    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private BufferedImage img;
    private Random random;
    public Menu(Game game) {
        super(game);
        importImage();
        loadSprites();
        random = new Random();
    }

    @Override
    public void render(Graphics g){
        for(int y = 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }
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

}
