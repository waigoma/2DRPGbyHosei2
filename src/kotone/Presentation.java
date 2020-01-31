package kotone;

import processing.core.PApplet;
import processing.core.PImage;

public class Presentation extends PApplet {
PImage haikei;
PImage monster;
//PImage efect;
float pointX;
float pointY;
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
        speedY = 0.5f;
        //efect = loadImage("C:\\Users\\tkoto\\Downloads\\kaenbeameffect\\火炎ビームエフェクトアニメ\\m\\kaenbeam.png\\");
    }

    @Override
    public void draw(){
        image(haikei,width/2,height/2);//背景の大きさ
        image(monster,pointX,pointY);
        monsterMove();

        if(mousePressed) {
            tint(255, 80, 31);//敵が攻撃を受けたときに赤い色を付ける
            image(monster, pointX, pointY);
        }

        noTint();//色を消す

        //if(mousePressed 攻撃を受けたら){//クリックしたらエフェクト表示
            //image(efect,0,0);


    }

    public void mouseClicked(){

    }

    public void monsterMove(){//普通のモンスターのスピード
        pointY += speedY;

        if(pointY < 145){
            speedY = 0.5f;
        }

        if(pointY > 155){
            speedY = -0.5f;
        }
    }



    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }


}


