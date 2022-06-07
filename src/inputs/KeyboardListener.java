package inputs;

import main.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static main.GameState.*;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                gameState = MENU;
                break;
            case KeyEvent.VK_S:
                gameState = PLAYING;
                break;
            case KeyEvent.VK_D:
                gameState = SETTINGS;
                break;
            case KeyEvent.VK_W:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
