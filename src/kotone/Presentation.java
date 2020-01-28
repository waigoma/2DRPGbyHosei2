package kotone;

import processing.core.PApplet;
import processing.core.PImage;

public class Presentation extends PApplet {
PImage haikei;
PImage monster;

    @Override
    public void settings(){
        size(600,400);
    }

    @Override
    public void setup(){
        haikei = loadImage("C:\\Users\\tkoto\\Downloads\\heigen3.gif");
        imageMode(CENTER);
        haikei.resize(width,height);
        monster = loadImage("C:\\Users\\tkoto\\Downloads\\dorako.png");
        monster.resize(150,240);
    }

    @Override
    public void draw(){
        image(haikei,width/2,height/2);
        image(monster,width/2,150);
    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }


}


