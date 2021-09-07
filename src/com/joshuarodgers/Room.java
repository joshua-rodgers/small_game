package com.joshuarodgers;

import java.awt.*;

public abstract class Room {
    Polygon floor;
    Wall[] walls;
    Color floor_color;
    Color wall_color;

    abstract void build_room();

}
