package com.joshuarodgers;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

public class Animation {
    Game game;

    public Animation(Game game){
        this.game = game;
    }

    public void update_sprite(Game_Object o){
        if(o.is_moving){
            if(o.animation_current_frame < o.animation_num_frames){
                o.animation_current_frame++;
            }else{
                o.animation_current_frame = 1;
            }
    
        }else{
            o.animation_current_frame = 0;
        }
        o.animation_sprite_first_corner.x = o.animation_current_frame * (int)o.sprite_size.getWidth();
        o.animation_sprite_first_corner.y = 0;
        o.animation_sprite_second_corner.x = o.animation_sprite_first_corner.x + (int)o.sprite_size.getWidth();
        o.animation_sprite_second_corner.y = o.animation_sprite_first_corner.y + (int)o.sprite_size.getHeight();
    }
}
