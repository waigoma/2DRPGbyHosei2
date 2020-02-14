package waigoma.Map.WorldMap;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.Map.MapTemplate;
import waigoma.StateType;

import waigoma.Map.LocalMap.LocalMap;

public class WorldMap {
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
            plet.getSurface().setSize(width - 10,height - 10);
            plet.background(0);
            pmove.setup();
            LocalMap.count++;
        }
        mapTmp.display();
        pmove.draw();
        mapTmp.topDisplay();
        if (mapTmp.next){
            switch (mapTmp.getMapName()){
                case "dungeon1.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon2.tmx");
                    Collision.Playerx = 51;
                    Collision.Playery = 557;
                    System.out.println("next");
                    break;
                case "dungeon2.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon3.tmx");
                    Collision.Playerx = 99;
                    Collision.Playery = 33;
                    break;
                case "dungeon3.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon4.tmx");
                    Collision.Playerx = 312;
                    Collision.Playery = 56;
                    break;
            }
            LocalMap.count = 0;
        }
        if (mapTmp.back){
            switch (mapTmp.getMapName()){
                case "dungeon1.tmx":
                    System.out.println("back");
                    Main.state = StateType.LOCAL_STATE;
                    mapTmp = MapTemplate.maps.get("dungeon1.tmx");
                    Collision.Playerx = 606;
                    Collision.Playery = 703;
                    break;
                case "dungeon2.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon1.tmx");
                    Collision.Playerx = 543;
                    Collision.Playery = 219;
                    break;
                case "dungeon3.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon2.tmx");
                    Collision.Playerx = 786;
                    Collision.Playery = 556;
                    break;
                case "dungeon4.tmx":
                    mapTmp = MapTemplate.maps.get("dungeon3.tmx");
                    Collision.Playerx = 69;
                    Collision.Playery = 880;
                    break;
            }
            LocalMap.count = 0;
        }
    }
}
