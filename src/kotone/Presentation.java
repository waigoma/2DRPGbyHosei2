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
        image(haikei,width/2,height/2);//背景の大きさ
        image(monster,pointX,pointY);//敵の位置
        monsterMove();

        tint(255,127,31);//敵が攻撃を受けたときに赤い色を付ける
        noTint();
    }


    public void monsterMove(){
        pointY += speedY;

        if(pointY < 145){
            speedY = 1;
        }

        if(pointY > 155){
            speedY = -1;
        }
    }



    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }


}


