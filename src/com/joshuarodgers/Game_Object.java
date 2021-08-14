package com.joshuarodgers;

import java.awt.Image;
import java.awt.Point;
import java.awt.Dimension;


public class Game_Object {
    Image sprite_sheet;
    

    Dimension sprite_size;
    Point position;

    boolean is_moving;

    private int animation_current_frame;
    private int animation_frame_rate;
    public Point animation_sprite_first_corner;
    public Point animation_sprite_second_corner;
    public Point animation_sprite_position_second_corner;

    public Game_Object(Image sprite_sheet, Dimension sprite_size, Point starting_position, int animation_frame_rate){
        this.sprite_sheet = sprite_sheet;
        this.sprite_size = sprite_size;
        position = starting_position;
        this.animation_frame_rate = animation_frame_rate;
        animation_current_frame = 0;
        animation_sprite_first_corner = new Point();
        animation_sprite_second_corner = new Point();
        animation_sprite_position_second_corner = new Point();
    }

    public void update_sprite(){
        if(is_moving){
            if(animation_current_frame < animation_frame_rate){
                animation_current_frame++;
            }else{
                animation_current_frame = 1;
            }
    
            animation_sprite_first_corner.x = animation_current_frame * (int)sprite_size.getWidth();
            animation_sprite_first_corner.y = 0;
            animation_sprite_second_corner.x = animation_sprite_first_corner.x + (int)sprite_size.getWidth();
            animation_sprite_second_corner.y = animation_sprite_first_corner.y + (int)sprite_size.getHeight();
    
            animation_sprite_position_second_corner.x = position.x + (int)sprite_size.getWidth();
            animation_sprite_position_second_corner.y = position.y + (int)sprite_size.getHeight();
        }else{
            animation_current_frame = 0;
            animation_sprite_first_corner.x = animation_current_frame * (int)sprite_size.getWidth();
            animation_sprite_first_corner.y = 0;
            animation_sprite_second_corner.x = animation_sprite_first_corner.x + (int)sprite_size.getWidth();
            animation_sprite_second_corner.y = animation_sprite_first_corner.y + (int)sprite_size.getHeight();
        }
        
    }

    public void move(int direction){
        
    }
}
