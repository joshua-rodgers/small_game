package com.joshuarodgers;

import java.awt.Image;
import java.awt.Point;

import java.awt.Dimension;

public class Coin extends Game_Object implements Collectible {
    static int value = 10;
    public Coin(Image sprite_sheet){
        super(sprite_sheet, new Dimension(32, 32), Game_Utils.get_rand_point(new Dimension(250, 250)), 2, true);
        name = "Coin";
    }
    public void collected(){
        is_active = false;
    }
}
