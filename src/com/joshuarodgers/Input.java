package com.joshuarodgers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{
    Game game;

    public Input(Game game){
        this.game = game;
    }

    public void keyPressed(KeyEvent e){
        int pressed = e.getKeyCode();
        switch(pressed){
            case 37:
                game.physics.player_moving_left = true;
                game.player.is_moving = true;
                break;
            case 38:
                game.physics.player_moving_up = true;
                game.player.is_moving = true;
                break;
            case 39:
                game.physics.player_moving_right = true;
                game.player.is_moving = true;
                break;
            case 40:
                game.physics.player_moving_down = true;
                game.player.is_moving = true;
                break;
            default:
        }
    }

    public void keyReleased(KeyEvent e){
        int active = e.getKeyCode();
        switch(active){
            case 37:
                game.physics.player_moving_left = false;
                game.player.is_moving = false;
                break;
            case 38:
                game.physics.player_moving_up = false;
                game.player.is_moving = false;
                break;
            case 39:   
                game.physics.player_moving_right = false;
                game.player.is_moving = false;             
                break;
            case 40:
                game.physics.player_moving_down = false;
                game.player.is_moving = false;
                break;
            default:
        }
    }
}
