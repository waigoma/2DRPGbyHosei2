package kotone;

import processing.core.PApplet;
import processing.core.PImage;


public class Presentation extends PApplet {
PImage img;

    @Override
    public void settings(){
        size(600,400);
    }

    @Override
    public void setup(){
        img = loadImage("C:\\Users\\tkoto\\Downloads\\heigen3.gif");
    }

    @Override
    public void draw(){
        image(img,0,0);
    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }
}
