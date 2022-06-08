package scenes;

import main.Game;

import java.awt.*;

public abstract class GameScene {
    private Game game;
    public GameScene(Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }

    public void render(Graphics g) {

    }
}
