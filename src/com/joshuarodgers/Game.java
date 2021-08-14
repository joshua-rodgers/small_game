package com.joshuarodgers;

import java.awt.Frame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Game {
    Frame game_window;
    Canvas game_surface;
    Graphics game_surface_ctx;
    Graphics game_back_buffer_ctx;
    Image game_back_buffer;

    Input game_input;
    Physics physics;
    Animation game_animation;
    
    Game_Object player;
    int frame_count;



    public Game(){
        init_window();
        init_graphics();
        init_game_objects();
        game_window.setVisible(true);
    }

    private void init_window(){
        game_window = new Frame("Small Game");
        game_window.setSize(300, 300);
        game_surface = new Canvas();
        game_surface.setPreferredSize(game_window.getSize());
        game_surface.setBackground(Color.BLACK);
        game_window.add(game_surface);
        game_window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        game_input = new Input(this);
        game_window.addKeyListener(game_input);
        game_window.pack();
    }

    private void init_graphics(){
        game_surface_ctx = game_surface.getGraphics();
        game_back_buffer = game_surface.createImage(game_window.getWidth(), game_window.getHeight());
        game_back_buffer_ctx = game_back_buffer.getGraphics();
    }

    private void init_game_objects(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image player_sprite_sheet = tk.getImage("/Users/joshua/Documents/Github/small_game/assets/player_sheet.png");
        player = new Game_Object(player_sprite_sheet, new Dimension(64, 64), new Point(10, 10), 3);
        game_animation = new Animation(this);
        physics = new Physics(this);
    }

    private void render(){
        game_back_buffer_ctx.clearRect(0, 0, game_window.getWidth(), game_window.getHeight());
        game_back_buffer_ctx.setColor(Color.GREEN);
        game_back_buffer_ctx.fillRect(100, 100, 20, 20);
        game_back_buffer_ctx.drawImage(player.sprite_sheet, player.position.x, player.position.y, player.animation_sprite_position_second_corner.x, player.animation_sprite_position_second_corner.y,
        player.animation_sprite_first_corner.x, player.animation_sprite_first_corner.y, player.animation_sprite_second_corner.x, player.animation_sprite_second_corner.y, null);
        game_surface_ctx.drawImage(game_back_buffer, 0, 0, null);
    }

    public void run(){
        while(true){
            try{
                physics.update();
                game_animation.new_frame();
                render();
                Thread.sleep(1000/30);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

}


