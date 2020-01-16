package com.company;

import java.awt.*;

public class Ball {

    private static final int DIAMETER = 30;
    private static final int RADIUS = 15;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    private Game game;
    private Pala pala = new Pala();

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            ya = -1;
        }

        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {

        double cx = x;
        double cy = y;
        double px;
        double py;
        double distancia;
        int width = Pala.getWIDTH();
        int height = Pala.getHEIGHT();
        int x = pala.getX();
        int y = Pala.getY();

        px = cx; // En principio son iguales
        if ( px < x ) px = x;
        if ( px > x + width ) px = x + width;
        py = cy;
        if ( py < y ) py = y;
        if ( py > y + height ) py = y + height;

        distancia = Math.sqrt( (cx - px)*(cx - px) + (cy - py)*(cy - py) );

        if ( distancia < DIAMETER ) {
            // Colisión detectada
            return true;
        } else {
            return false;
        }
        //return game.pala.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}