package ui;

import java.awt.*;

public class MyButton {
    private final String text;
    private final int x, y, width, height;
    private boolean mouseOver, mousePressed;

    private Rectangle bounds;

    public MyButton(String text, int x, int y, int width, int height){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }

    private void initBounds(){
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g){
        drawBody(g);
        drawBorder(g);
        drawText(g);
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);

        if(mousePressed){
            g.drawRect(x + 1, y + 1, width - 2, height - 2);
            g.drawRect(x + 4, y + 4, width - 4, height - 4);
        }
    }

    public void resetBooleans(){
        mouseOver = false;
        mousePressed = false;
    }

    private void drawBody(Graphics g) {
        if(mouseOver)
            g.setColor(Color.gray);
        else
            g.setColor(Color.WHITE);

        g.fillRect(x, y, width, height);
    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2);
    }

    public void setMousePressed(boolean b){
        mousePressed = b;
    }

    public void setMouseOver(boolean b){
        mouseOver = b;
    }

    public Rectangle getBounds(){
        return bounds;
    }



}
