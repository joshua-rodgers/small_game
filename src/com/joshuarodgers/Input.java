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
                game.player.is_moving = true;
                
                break;
            case 38:
                System.out.println("UP");
                
                break;
            case 39:
                System.out.println("RIGHT");
                
                break;
            case 40:
                System.out.println("DOWN");
                break;
            default:
        }
    }

    public void keyReleased(KeyEvent e){
        int active = e.getKeyCode();
        switch(active){
            case 37:
                game.player.is_moving = false;
                break;
            case 38:
                System.out.println("released UP");
                break;
            case 39:
                System.out.println("released RIGHT");
                break;
            case 40:
                System.out.println("released DOWN");
                break;
            default:
        }
    }
}
