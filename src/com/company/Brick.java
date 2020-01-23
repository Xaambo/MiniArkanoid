package com.company;

import java.awt.*;

public class Brick {

    private static final int Y = 50;
    private static final int X = 120;
    private static final int WIDTH = 50;
    private static final int HEIGHT = 10;

    private Game game;

    public Brick(Game game) {
        this.game= game;
    }

    public int getX() {
        return X;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getY() {
        return Y;
    }

    public void paint(Graphics2D g) {
        g.fillRect(X, Y, WIDTH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(X, Y, WIDTH, HEIGHT);
    }

    public void destroy(Graphics2D g) {

    }
}