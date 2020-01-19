package waigoma;

import processing.core.PApplet;

public class Test {
    PApplet plet;

    boolean right, left, up, down = false;
    float x, y;
    double speed = 3.0;

    public Test(PApplet papplet){
        this.plet = papplet;
        x = plet.width/2;
        y = plet.height/2;
    }

    public void keyPressed(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') right = true;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') left = true;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') up = true;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') down = true;
    }
    public void keyReleased(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') right = false;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') left = false;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') up = false;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') down = false;
    }


    public void display(){
        plet.background(128);
        plet.fill(0);

        if (right){
            x += speed;
        }
        if (left){
            x -= speed;
        }
        if (up){
            y -= speed;
        }
        if (down){
            y += speed;
        }

        plet.rect(x, y, 30, 30);
    }

}
