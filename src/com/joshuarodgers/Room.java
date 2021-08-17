package com.joshuarodgers;

import java.awt.*;

public class Room {
    Rectangle floor;
    Rectangle[] walls;
    Color floor_color;
    Color wall_color;
    Game game;

    public Room(Game game){
        this.game = game;
        floor = new Rectangle(new Point(0, 0), game.game_surface.getSize());
        walls = new Rectangle[4];
        walls[0] = new Rectangle(0,0,floor.width, 20);
        walls[1] = new Rectangle(0,0, 20, floor.height);
        walls[2] = new Rectangle(0, floor.height - 20, floor.width, 20);
        walls[3] = new Rectangle(floor.width - 20, 0, 20, floor.height);
        floor_color = Color.DARK_GRAY;
        wall_color = Color.GRAY;
    }
}
