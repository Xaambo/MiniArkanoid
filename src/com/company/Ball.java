package com.company;

import java.awt.*;

public class Ball {

    private static final int DIAMETER = 20;
    private static final int RADIUS = 10;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;

    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision(Pala.getWIDTH(), Pala.getHEIGHT(), game.pala.getX(), Pala.getY())) {
            ya = -game.speed;
            //game.speed++;
        } else if (game.brick != null) {
            if (collision(game.brick.getWIDTH(), game.brick.getHEIGHT(), game.brick.getX(), game.brick.getY())) {
                if ((x + RADIUS) + xa < game.brick.getX()) {
                    xa = -game.speed;
                    game.brick = null;
                } else if ((x + RADIUS) + xa > game.brick.getX() + game.brick.getWIDTH()) {
                    xa = game.speed;
                    game.brick = null;
                } else if ((y + RADIUS) + ya < game.brick.getY()) {
                    ya = -game.speed;
                    game.brick = null;
                } else if ((y + RADIUS) + ya > game.brick.getY()) {
                    ya = game.speed;
                    game.brick = null;
                }
            }
            //game.speed++;
        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            //Sound.BALL.play();
        }

        x = x + xa;
        y = y + ya;
    }

    private boolean collision(int width, int height, int x, int y) {

        double cx = this.x;
        double cy = this.y;
        double px;
        double py;
        double distancia;
        y = y - RADIUS;

        px = cx; // En principio son iguales
        if ( px < x ) px = x;
        if ( px > x + width ) px = x + width;
        py = cy;
        if ( py < y ) py = y;
        if ( py > y + height ) py = y + height;

        distancia = Math.sqrt( (cx - px)*(cx - px) + (cy - py)*(cy - py) );

        if ( distancia < RADIUS ) {
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