package waigoma.Map.WorldMap;

import processing.core.PApplet;
import waigoma.Map.MapTemplate;
import waigoma.Test;

public class WorldMap {
    PApplet plet;
    MapTemplate mapTemp;
    Test test;

    public WorldMap(PApplet papplet){
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

    }
}
