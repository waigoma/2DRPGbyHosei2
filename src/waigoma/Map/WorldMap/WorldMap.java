package waigoma.Map.WorldMap;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Map.MapTemplate;
import waigoma.Test;

public class WorldMap {
    PApplet plet;
    MapTemplate mapTmp;
    PlayerMove pmove;
    int count = 0;

    public WorldMap(PApplet papplet){
        this.plet = papplet;
        pmove = new PlayerMove(papplet);
    }

    public void keyPressed(){
        pmove.keyPressed();
    }
    public void keyReleased(){
        pmove.keyReleased();
    }

    public void display(){
        if (count == 0){
            plet.rectMode(plet.CORNER);
            mapTmp = MapTemplate.maps.get("dungeon1.tmx");
            int width = mapTmp.getMapTileWidth() * mapTmp.getTileWidth();
            int height = mapTmp.getMapTileHeight() * mapTmp.getTileHeight();
            plet.getSurface().setSize(width - 10,height - 10);
            Collision.Playerx = 162;
            Collision.Playery = 142;
            plet.background(0);
            pmove.setup();
            count++;
        }
        mapTmp.display();
        pmove.draw();
        mapTmp.topDisplay();
    }
}
