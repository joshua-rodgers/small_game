package com.joshuarodgers;

import java.awt.Point;
import java.util.Random;
import java.awt.Dimension;

public class Game_Utils {
    private static Random r = new Random();;

    Game game;

    public Game_Utils(Game game){
        this.game = game;
    }

    public static Point get_rand_point(Dimension bounds){
        int x = r.nextInt((int)bounds.getWidth());
        int y = r.nextInt((int)bounds.getHeight());

        return new Point(x, y);
    }

    public static int get_rand(int upper_bound){
        return r.nextInt(upper_bound);
    }
}
