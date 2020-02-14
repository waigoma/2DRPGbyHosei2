package waigoma.Map.LocalMap;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.Map.MapTemplate;
import waigoma.StateType;
import waigoma.Test;

public class LocalMap {
    PApplet plet;
    PlayerMove pmove;
    MapTemplate mapTmp;

    int count = 0;

    public LocalMap(PApplet papplet){
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
            mapTmp = MapTemplate.maps.get("1village.tmx");
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
//        Main.state = StateType.WORLD_STATE;
    }
}
