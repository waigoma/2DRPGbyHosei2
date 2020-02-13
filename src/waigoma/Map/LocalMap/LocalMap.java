package waigoma.Map.LocalMap;

import processing.core.PApplet;
import waigoma.Map.MapTemplate;
import waigoma.Test;

public class LocalMap {
    PApplet plet;
    Test test;
    MapTemplate mapTmp;

    int count = 0;

    public LocalMap(PApplet papplet){
        this.plet = papplet;
        test = new Test(papplet);
    }

    public void keyPressed(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') test.right = true;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') test.left = true;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') test.up = true;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') test.down = true;
        if (plet.keyCode == plet.SHIFT) test.speed = 10.0;
    }
    public void keyReleased(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') test.right = false;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') test.left = false;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') test.up = false;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') test.down = false;
        if (plet.keyCode == plet.SHIFT) test.speed = 3.0;
    }

    public void display(){
        if (count == 0){
            plet.rectMode(plet.CORNER);
            mapTmp = MapTemplate.maps.get("1village.tmx");
            int width = mapTmp.getMapTileWidth() * mapTmp.getTileWidth();
            int height = mapTmp.getMapTileHeight() * mapTmp.getTileHeight();
            plet.getSurface().setSize(width,height);
            count++;
        }
        mapTmp.display();
        test.display();
        mapTmp.topDisplay();
    }
}
