package waigoma.Map.LocalMap;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.Map.MapTemplate;
import waigoma.StateType;

public class LocalMap {
    PApplet plet;
    PlayerMove pmove;
    MapTemplate mapTmp;

    public static int count = 0;

    public LocalMap(PApplet papplet){
        this.plet = papplet;
        pmove = new PlayerMove(papplet);
        Collision.Playerx = 162;
        Collision.Playery = 142;
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
            plet.background(0);
            pmove.setup();
            count++;
        }
        mapTmp.display();
        pmove.draw();
        mapTmp.topDisplay();
        mapTmp.event();
        if (mapTmp.isNext()){
            Main.state = StateType.WORLD_STATE;
            Collision.Playerx = 149;
            Collision.Playery = 550;
            count = 0;
            plet.delay(100);
        }
        if (mapTmp.isBack()){
//            Main.state = StateType.LOCAL_STATE;
            count = 0;
        }
    }
}
