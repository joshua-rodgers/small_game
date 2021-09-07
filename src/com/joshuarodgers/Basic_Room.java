package com.joshuarodgers;

import java.awt.*;

public class Basic_Room extends Room{
  public Basic_Room(int width, int height){
    int[] xpoints = {100, 100, width + 100};
    int[] ypoints = {100, height + 100, width + 100};
    int npoints = 3;
    this.floor = new Polygon(xpoints, ypoints, npoints);
    this.walls = new Wall[width/100 + height/100];
    this.floor_color = Color.DARK_GRAY;
    this.wall_color = Color.GRAY;
  }

  public void build_room(){
    
  }
}
