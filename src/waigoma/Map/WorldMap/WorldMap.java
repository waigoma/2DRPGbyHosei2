package waigoma.Map.WorldMap;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.Map.MapTemplate;
import waigoma.StateType;

import waigoma.Map.LocalMap.LocalMap;

public class WorldMap {
    String next;
    String previous;

    PApplet plet;
    MapTemplate mapTmp;
    PlayerMove pmove;

    public WorldMap(PApplet papplet){
        this.plet = papplet;
        pmove = new PlayerMove(papplet);
        mapTmp = MapTemplate.maps.get("dungeon1.tmx");
    }

    public void keyPressed(){
        pmove.keyPressed();
    }
    public void keyReleased(){
        pmove.keyReleased();
    }

    public void display(){
        if (LocalMap.count == 0){
            plet.rectMode(plet.CORNER);
            int width = mapTmp.getMapTileWidth() * mapTmp.getTileWidth();
            int height = mapTmp.getMapTileHeight() * mapTmp.getTileHeight();
            next = mapTmp.getNextMap();
            previous = mapTmp.getPreviousMap();
            plet.getSurface().setSize(width - 10,height - 10);
            plet.background(0);
            pmove.setup();
            LocalMap.count++;
        }
        mapTmp.display();
        pmove.draw();
        mapTmp.topDisplay();
//        System.out.println(mapTmp.getMapName());
        if (mapTmp.next){
            mapTmp = MapTemplate.maps.get(next);
            LocalMap.count = 0;
        }
        if (mapTmp.back){
            mapTmp = MapTemplate.maps.get(previous);
            LocalMap.count = 0;
        }
    }
}
