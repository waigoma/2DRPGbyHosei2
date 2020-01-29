package kotone;

import processing.core.PApplet;
import processing.core.PImage;

public class Presentation extends PApplet {
PImage haikei;
PImage monster;
int pointX;
int pointY;
float speedY;

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
        monster.resize(150,240);pointX = width/2;
        pointY = 150;
        speedY = 1;
    }

    @Override
    public void draw(){
        image(haikei,width/2,height/2);
        image(monster,pointX,pointY);
        monsterMove();
    }


    public void monsterMove(){
        pointY += speedY;

        if(pointY < 140){
            speedY = 1;
        }

        if(pointY > 160){
            speedY = -1;
        }


    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }


}


