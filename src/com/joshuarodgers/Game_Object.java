package com.joshuarodgers;

import java.awt.Image;
import java.awt.Point;
import java.awt.Dimension;


public class Game_Object {
    Image sprite_sheet;

    Dimension sprite_size;
    Point position;

    int animation_current_frame;

    public Game_Object(Image sprite_sheet, Dimension sprite_size, Point starting_position){
        this.sprite_sheet = sprite_sheet;
        this.sprite_size = sprite_size;
        position = starting_position;
    }
}
