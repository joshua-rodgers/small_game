package com.joshuarodgers;

import java.util.List;
import java.util.ArrayList;

public class Animation {
    List<Game_Object> followers;

    public Animation(Game game){
        followers = new ArrayList<>();
        followers.add(game.player);
    }

    public void new_frame(){
        for(Game_Object o : followers){
            o.update_sprite();
        }
    }


}
