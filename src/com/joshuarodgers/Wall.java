package com.joshuarodgers;

import java.awt.*;

public class Wall{
  Point position;
  Dimension size;
  Image v_sprite;
  Image h_sprite;
  char orientation;

  public Wall(Point position, Dimension size, Image v_sprite, Image h_sprite, char orientation){
    this.position = position;
    this.size = size;
    this.v_sprite = v_sprite;
    this.h_sprite = h_sprite;
    this.orientation = orientation;
  }
}
