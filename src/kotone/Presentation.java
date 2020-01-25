package kotone;

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Presentation extends PApplet {
PImage img;

    @Override
    public void settings(){
        size(600,400);
    }

    @Override
    public void setup(){
        background(255);
        img = loadImage("heigen3.gif");
    }

    @Override
    public void draw(){
        image(img,0,0);
    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }
}
