package kotone;

import processing.core.PApplet;
import processing.core.PImage;

public class Presentation extends PApplet {
PImage haikei;
//PImage monster;

    @Override
    public void settings(){
        size(600,400);
    }

    @Override
    public void setup(){
        haikei = loadImage("src/waigoma/data/img/600x300frame.png");
        imageMode(CENTER);
        haikei.resize(width,height);
    }

    @Override
    public void draw(){
        image(haikei,width/2,height/2);
    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }

    //@Override
    //public void
   // monster = loadImage("C:\Users\tkoto\Downloads\dorako.png");


}


