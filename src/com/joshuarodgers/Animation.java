package com.joshuarodgers;

import java.util.List;
import java.util.ArrayList;

public class Animation {
    ArrayList<Game_Object> followers;

    public Animation(Game game){
        followers = game.game_objects;
    }

    public void new_frame(){
        for(Game_Object o : followers){
            o.update_sprite();
        }
    }


}
