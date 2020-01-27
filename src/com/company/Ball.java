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
        } else if (collision(Brick.getWIDTH(), Brick.getHEIGHT(), Brick.getX(), Brick.getY())) {
            if (x + xa < Brick.getX())
                xa = game.speed;
            else if (x + xa > (Brick.getX() - Brick.getWIDTH()) - DIAMETER)
                xa = -game.speed;
            else if (y + ya < Brick.getY() - Brick.getHEIGHT())
                ya = game.speed;
            else if (y + ya > Brick.getY() - DIAMETER)
                ya = -game.speed;
            //game.speed++;
        } else {
            changeDirection = false;
        }

        if (changeDirection) {
            Sound.BALL.play();
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
        y = y - height;

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