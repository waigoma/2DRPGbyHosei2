package waigoma.Map.WorldMap;

import hibino.Combat;
import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.Map.MapTemplate;
import waigoma.StateType;

import waigoma.Map.LocalMap.LocalMap;

import java.util.Scanner;

public class WorldMap {
    String next, previous;
    int nextX, nextY, previousX, previousY;

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
            nextX = mapTmp.getNextX();
            nextY = mapTmp.getNextY();
            previousX = mapTmp.getPreviousX();
            previousY = mapTmp.getPreviousY();
            plet.getSurface().setSize(width - 10,height - 10);
            plet.background(0);
            pmove.setup();
            Combat.mapName = mapTmp.getMapName();
            LocalMap.count++;
        }

        mapTmp.display();
        pmove.draw();
        mapTmp.topDisplay();
        mapTmp.event();

//        System.out.println(mapTmp.getMapName());
        if (mapTmp.isNext()){
//          Main.state = StateType.COMBAT_STATE;
            mapTmp = MapTemplate.maps.get(next + ".tmx");
            Collision.Playerx = nextX;
            Collision.Playery = nextY;
            LocalMap.count = 0;
        }
        if (mapTmp.isBoss()){
            Collision.Playerx = 312;
            Collision.Playery = 56;
            LocalMap.count = 0;
            Combat.m_name = "モンスターC";
            Main.state = StateType.COMBAT_STATE;
        }
        if (mapTmp.isBack()){
            mapTmp = MapTemplate.maps.get(previous + ".tmx");
            if (mapTmp.getMapName().contains("1village")){
                Main.state = StateType.LOCAL_STATE;
                next = mapTmp.getNextMap();
                LocalMap.mapTmp = mapTmp;
                mapTmp = MapTemplate.maps.get(next + ".tmx");
            }
            Collision.Playerx = previousX;
            Collision.Playery = previousY;
            LocalMap.count = 0;
        }
    }

    public void setMapTmp(String mapName) {
        mapTmp = MapTemplate.maps.get(mapName+".tmx");
    }
}
