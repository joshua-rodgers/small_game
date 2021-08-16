package com.joshuarodgers;

public class Collision {
    Game game;
    String item;
    public Collision(Game game){
        this.game = game;
    }

    public void check_collisions(){
        for(Game_Object o : game.game_objects){
            if(o.is_active){
                if(game.player.sprite_bounds.intersects(o.sprite_bounds)){
                    item = o.name;
                    switch(item){
                        case "Coin":
                            game.player.items.add(o);
                            game.player.score += Coin.value;
                            Coin c = (Coin)o;
                            c.collected();
                            break;
                        default:
                    }
                }
            }
            
        }
    }
}
