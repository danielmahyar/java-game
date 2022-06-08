package main;

public enum GameState {
    PLAYING,
    MENU,
    QUIT,
    SETTINGS;
    public static GameState gameState = MENU;

    public static void SetGameState(GameState s){
        gameState = s;
    }
}
