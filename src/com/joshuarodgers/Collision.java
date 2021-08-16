package com.joshuarodgers;

public class Collision {
    Game game;
    public Collision(Game game){
        this.game = game;
    }

    public void check_collisions(){
        for(Game_Object o : game.game_objects){
            if(game.player.sprite_bounds.intersects(o.sprite_bounds)){
                System.out.println("whoa...");
            }
        }
    }
}
