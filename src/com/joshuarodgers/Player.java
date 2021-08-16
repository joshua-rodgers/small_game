package com.joshuarodgers;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Image;

import java.util.ArrayList;

public class Player extends Game_Object {
    int score;
    int health;
    ArrayList<Game_Object> items;

    public Player(Image sprite_sheet){
        super(sprite_sheet, new Dimension(64, 64), new Point(100, 100), 3, false);
        health = 100;
        score = 0;
        items = new ArrayList<Game_Object>();
    }

}
