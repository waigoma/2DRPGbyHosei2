package nagai;

import processing.core.PApplet;

public class Main extends PApplet {
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    float x = 0;
    float y = 0;
    double xspeed = 3.0;
    double yspeed = 3.0;


    @Override
    public void settings(){
        size(1000,500);
    }

    @Override
    public void setup(){


    }
    @Override
    public void keyPressed(){
        if (keyCode == RIGHT) right = true;
        if (keyCode == LEFT) left = true;
        if (keyCode == UP) up = true;
        if (keyCode == DOWN) down = true;
    }
    @Override
    public void keyReleased() {
        if (keyCode == RIGHT) right = false;
        if (keyCode == LEFT) left = false;
        if (keyCode == UP) up = false;
        if (keyCode == DOWN) down = false;
    }


    @Override
    public void draw(){
        background(HSB,50,0,50);

        if (right){
            x += xspeed;

        }
        if (left){
            x -= xspeed;
        }
        if (up){
            y -= yspeed;
        }
        if (down){
            y += yspeed;
        }
        if(y>height-30){
            yspeed = -yspeed;
        }
        if(y<0) {
            yspeed = -yspeed;
        }
        if(x<0){
            xspeed=-xspeed;
        }
        if(x>width-50){
            xspeed=-xspeed;
        }
        noStroke();
        rect(x,y,50,30);


    }

    public static void main(String[] args){
        PApplet.main("nagai.Main");
    }
}
