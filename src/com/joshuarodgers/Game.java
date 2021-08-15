package com.joshuarodgers;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.List;

import java.util.ArrayList;

public class Game {
    Frame game_window;
    Panel game_surface;
    Graphics game_surface_ctx;
    Graphics game_back_buffer_ctx;
    Image game_back_buffer;

    Input game_input;
    Physics physics;
    Collision collision;
    Animation game_animation;
    Game_Object player;
    
    ArrayList<Game_Object> game_objects;

    public Game(){
        init_window();
        init_graphics();
        init_game_objects();
        game_window.setVisible(true);
    }

    private void init_window(){
        game_window = new Frame("Small Game");
        game_window.setSize(300, 300);
        game_surface = new Panel();
        game_surface.setSize(300, 300);
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
        game_objects = new ArrayList<>();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image player_sprite_sheet = tk.getImage("/Users/joshua/Documents/Github/small_game/assets/player_sheet.png");
        Image token_sprite_sheet = tk.getImage("/Users/joshua/Documents/Github/small_game/assets/coin_sheet.png");
        player = new Game_Object(player_sprite_sheet, new Dimension(64, 64), new Point(10, 10), 3, false);
        game_objects.add(new Game_Object(token_sprite_sheet, new Dimension(32, 32), new Point(10, 10), 2, true));
        game_objects.add(player);
        game_animation = new Animation(this);
        physics = new Physics(this);
        collision = new Collision(this);
    }

    private void render(){
        game_back_buffer_ctx.clearRect(0, 0, game_window.getWidth(), game_window.getHeight());
        for(Game_Object o : game_animation.followers){
            game_back_buffer_ctx.drawImage(o.sprite_sheet, o.position.x, o.position.y, o.position.x + (int)o.sprite_size.getWidth(), o.position.y + (int)o.sprite_size.getHeight(),
            o.animation_sprite_first_corner.x, o.animation_sprite_first_corner.y, o.animation_sprite_second_corner.x, o.animation_sprite_second_corner.y, null);
        }
        
        game_surface_ctx.drawImage(game_back_buffer, 0, 0, null);
    }

    public void run(){
        long elapsed = 0;
        long started = 0;
        long ended = 0;
        while(true){
            try{
                started = System.currentTimeMillis();
                physics.update();
                collision.check_collisions();
                render();
                Thread.sleep(1000/30);
                ended = System.currentTimeMillis();
                elapsed += ended - started;
                if(elapsed >= 83){
                    game_animation.new_frame();
                    elapsed = 0;
                }
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


