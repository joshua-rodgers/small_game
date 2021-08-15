package com.joshuarodgers;


public class Physics {

    Game game;
    boolean player_moving_left;
    boolean player_moving_up;
    boolean player_moving_right;
    boolean player_moving_down;

    public Physics(Game game){
        this.game = game;
    }

    private void move_player(int direction){
        
        switch(direction){
            case 1:
                if(game.player.position.x > 0)
                    game.player.position.x -= 10;
                break;
            case 2:
                if(game.player.position.y > 0)
                    game.player.position.y -= 10;
                break;
            case 3:
                if(game.player.position.x + game.player.sprite_size.width < game.game_window.getWidth())
                    game.player.position.x += 10;
                break;
            case 4:
                if(game.player.position.y + game.player.sprite_size.height < game.game_window.getHeight())
                game.player.position.y += 10;
                break;
            default:
        }
    }
    
    public void update(){
        if(player_moving_left){
            move_player(1);
        }
        if(player_moving_up){
            move_player(2);
        }
        if(player_moving_right){
            move_player(3);
        }
        if(player_moving_down){
            move_player(4);
        }
        
    }
}
