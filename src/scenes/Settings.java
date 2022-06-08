package scenes;

import main.Game;
import ui.MyButton;

import java.awt.*;

import static main.GameState.MENU;
import static main.GameState.SetGameState;

public class Settings extends GameScene implements SceneMethods {
    private MyButton menu;
    public Settings(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        int w = 100;
        int h = w / 3;
        int x = 20;
        int y  = 20;

        menu = new MyButton("Menu", x, y, w, h);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 640, 640);
        menu.draw(g);
    }

    public void mouseClicked(int x, int y) {
        if (menu.getBounds().contains(x, y)) {
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
