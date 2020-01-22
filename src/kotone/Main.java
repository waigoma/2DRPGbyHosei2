package kotone;

import processing.core.PApplet;

public class Main extends PApplet {
    @Override
    public void settings(){
        size(600, 400);
    }

    @Override
    public void setup() {

        background(255);
    }

    float x =300;
    float y =200;
    int r = 180;



    @Override
    public void draw(){
        //background(255);
        fill(255,10);
        noStroke();
        rect(0,0,600,400);
        x = x + 1;
        //y = y + random(-4,4);
        noFill();
        stroke(0,0,255);
        rect(x,y,r,r);
    }

    public static void main(String[] args){
        PApplet.main("kotone.Main");
    }
}
