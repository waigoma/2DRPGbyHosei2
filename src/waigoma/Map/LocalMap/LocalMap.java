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
    public static MapTemplate mapTmp;
    String next, previous;
    int nextX, nextY, previousX, previousY;

    public static int count = 0;

    public LocalMap(PApplet papplet){
        this.plet = papplet;
        pmove = new PlayerMove(papplet);
        mapTmp = MapTemplate.maps.get("1village.tmx");
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
            int width = mapTmp.getMapTileWidth() * mapTmp.getTileWidth();
            int height = mapTmp.getMapTileHeight() * mapTmp.getTileHeight();
            next = mapTmp.getNextMap();
            previous = mapTmp.getPreviousMap();
            nextX = mapTmp.getNextX();
            nextY = mapTmp.getNextY();
            previousX = mapTmp.getPreviousX();
            previousY = mapTmp.getPreviousY();
            plet.getSurface().setSize(width - 10,height - 10);
            plet.background(0);
            pmove.setup();
            count++;
        }

        mapTmp.display();
        pmove.draw();
        mapTmp.event();
        mapTmp.topDisplay();

        if (mapTmp.isNext()){
            mapTmp = MapTemplate.maps.get(next + ".tmx");
            Collision.Playerx = nextX;
            Collision.Playery = nextY;
            LocalMap.count = 0;
            if (mapTmp.getMapName().contains("dungeon1")) Main.state = StateType.WORLD_STATE;
            count = 0;
            plet.delay(100);
        }
        if (mapTmp.isBack()){
//            Main.state = StateType.LOCAL_STATE;
            count = 0;
        }
    }
}
