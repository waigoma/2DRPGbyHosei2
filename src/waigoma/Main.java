package waigoma;

import processing.core.PApplet;
import processing.core.PImage;
import waigoma.Title.Title;

public class Main extends PApplet {
    boolean right, left, up, down = false;
    float x, y = 0;
    double speed = 3.0;

    Title title;

    PImage img;
    @Override
    public void settings(){
        size(1280,720);
    }

    @Override
    public void setup(){
        noStroke();
        title = new Title();
        img = loadImage("D:\\Programming\\2DRPGbyHosei2\\src\\waigoma\\test.png");
    }

    @Override
    public void keyPressed(){
        if (keyCode == RIGHT) right = true;
        if (keyCode == LEFT) left = true;
        if (keyCode == UP) up = true;
        if (keyCode == DOWN) down = true;
    }

    @Override
    public void keyReleased(){
        if (keyCode == RIGHT) right = false;
        if (keyCode == LEFT) left = false;
        if (keyCode == UP) up = false;
        if (keyCode == DOWN) down = false;
    }

    @Override
    public void draw(){
        image(img,0,0);
        translate(width/2,height/2);

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

        rect(x, y, 30, 30);
    }

    public static void main(String[] args){
        PApplet.main("waigoma.Main");
    }
}
