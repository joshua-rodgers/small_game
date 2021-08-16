package com.joshuarodgers;

import java.awt.Image;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;


public abstract class Game_Object {
    String name;
    
    Image sprite_sheet;
    
    Dimension sprite_size;
    Point position;
    Rectangle sprite_bounds;

    boolean is_moving;
    boolean is_active;

    public int animation_current_frame;
    public int animation_num_frames;
    public Point animation_sprite_first_corner;
    public Point animation_sprite_second_corner;
    public Point animation_sprite_position_second_corner;

    public Game_Object(Image sprite_sheet, Dimension sprite_size, Point starting_position, int animation_num_frames, boolean is_constant_motion){
        this.sprite_sheet = sprite_sheet;
        this.sprite_size = sprite_size;
        position = starting_position;

        if(is_constant_motion)
            is_moving = true;

        this.animation_num_frames = animation_num_frames;
        animation_current_frame = 0;
        animation_sprite_first_corner = new Point();
        animation_sprite_second_corner = new Point(animation_sprite_first_corner.x + sprite_size.width, animation_sprite_first_corner.y + sprite_size.height);
        sprite_bounds = new Rectangle();
        sprite_bounds.setBounds(position.x, position.y, sprite_size.width, sprite_size.height);

        is_active = true;
    }
}
