package scenes;

import helperMethods.LevelBuild;
import main.Game;
import managers.TileManager;
import ui.MyButton;

import java.awt.*;

import static main.GameState.*;

public class Playing extends GameScene implements SceneMethods{
    private int[][] level;
    private TileManager tileManager;

    private MyButton menu;

    public Playing(Game game) {
        super(game);
        initButtons();
        level = LevelBuild.getLevelData();
        tileManager = new TileManager();

        //NEED THE LEVEL
        //TILEMANAGER
    }

    public void render(Graphics g) {

        for(int y = 0; y < level.length; y++){
            for(int x = 0; x < level[y].length; x++){
                g.drawImage(tileManager.getSprite(level[y][x]), x * 32, y * 32, null);
            }
        }
        menu.draw(g);
    }

    private void initButtons() {
        int w = 100;
        int h = w / 3;
        int x = 20;
        int y  = 20;

        menu = new MyButton("Menu", x, y, w, h);
    }

    public void mouseClicked(int x, int y) {
        if(menu.getBounds().contains(x, y)){
            SetGameState(MENU);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        menu.setMouseOver(
                menu.getBounds().contains(x, y)
        );
    }

    @Override
    public void mousePressed(int x, int y) {
        menu.setMousePressed(
                menu.getBounds().contains(x, y)
        );
    }

    @Override
    public void mouseReleased(int x, int y) {
        menu.resetBooleans();
    }
}
