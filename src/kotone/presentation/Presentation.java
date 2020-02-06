package kotone.presentation;

import processing.core.PApplet;
import processing.core.PImage;

public class Presentation {

    PImage haikei;
    PImage monster;
    PImage efect;
    float pointX;
    float pointY;
    float speedY;
    PApplet pApplet;
    Main combat;//Mainクラスのオブジェクトを作る

    public Presentation(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void setup(){

        haikei = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\heigen3.gif");
        pApplet.imageMode(pApplet.CENTER);
        haikei.resize(pApplet.width,pApplet.height);

        monster = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\dorako.png");
        monster.resize(300,480);pointX = pApplet.width/2;
        pointY = 300;
        speedY = 1;

        efect = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\kaenbeameffect\\火炎ビームエフェクトアニメ\\m\\kaenbeam.png");

//        combat = new Main();//タイトルクラスのオブジェクトにタイトルクラスをインスタンス化していれる
    }


    public void draw() {

//        combat.draw();//タイトルクラスの中身が使えるようにする

        pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);//背景の大きさ
        pApplet.image(monster, pointX, pointY);
        monsterMove();
        if ((Main.m_hit) && (Main.keika > 1000 * 1) && (Main.keika < 1000 * 2)) {//もしm_hitがtrueなら（一回実行するため）
            System.out.println("mhit true");
            pApplet.tint(255, 80, 31);//敵が攻撃を受けたときに赤い色を付ける
            pApplet.image(monster, pointX, pointY);
        } else {
            pApplet.noTint();//色を消す
        }

}
       // if(m_hp ) {
            //Applet.tint(255, 80, 31);//敵が攻撃を受けたときに赤い色を付ける
            //pApplet.image(monster, pointX, pointY);





    public void monsterMove(){//普通のモンスターのスピード
        pointY += speedY;

        if(pointY < 290){
            speedY = 1;
        }

        if(pointY > 310){
            speedY = -1;
        }
    }



    public static void main(String[] args){
        PApplet.main("kotone.presentation.Presentation");
    }


}


