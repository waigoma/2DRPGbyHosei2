package kotone.presentation;

import processing.core.PApplet;
import processing.core.PImage;
import hibino.Main;

import java.util.concurrent.atomic.AtomicInteger;

import static hibino.Main.*;

//import static kotone.presentation.Main.m_hp;
//import static kotone.presentation.Main.p_hp;

public class Presentation {

    PImage haikei;
    PImage monster;
    PImage efect;
    PImage lifegauge;
    float pointX;
    float pointY;
    float speedY;
    float m_drawWidth;
    float p_rectWidth = 200;
    float m_rectWidth = 200;
    float alpha = 255f;       //透明度
    boolean cngAlpha;    //変化開始FLG
    public static boolean fadeMode;    //フェードイン・アウト切り替えFLG

    PApplet pApplet;

    public Presentation(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void setup(){

        haikei = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\heigen3.gif");
        pApplet.imageMode(pApplet.CENTER);
        haikei.resize(pApplet.width,pApplet.height);

        monster = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\dorako.png");
        cngAlpha = false;//透明度の変化は「停止」にしておく
        fadeMode = true; //最初から表示している状態で始めたいので現在の状態を「true」に仮設定する
        monster.resize(300,480);
        pointX = pApplet.width/2;
        pointY = 300;
        speedY = 1;

        efect = pApplet.loadImage("C:\\Users\\tkoto\\Downloads\\kaenbeameffect\\火炎ビームエフェクトアニメ\\m\\kaenbeam.png");

    }


    public void draw() {
//        System.out.println("draw");

        pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);//背景の大きさ

        pApplet.tint(255f, alpha);//画像を透明度指定付きで表示
        pApplet.image(monster, pointX, pointY);//モンスターの位置

//        pApplet.image(lifegauge,50,50);
//        pApplet.image(lifegauge,1230,50);

        monsterMove();
        //lifeGauge();

        //敵が攻撃を受けたときに赤い色を付ける
        if ((Main.m_hit) && (Main.keika > 100) && (Main.keika < 400)) {//もしm_hitがtrueなら（一回実行するため）
            pApplet.tint(255, 80, 31);
            pApplet.image(monster, pointX, pointY);
        } else {
            pApplet.noTint();//色を消す
        }

        //透明度を変化させる場合
        if (!fadeMode) {
            fadeOut();
        }

        if (p_hp < 25) {
            System.out.println("1/4");
            pApplet.fill(255,0,0);
        } else if(p_hp < 50){
            System.out.println("1/2");
            pApplet.fill(255,200,0);
        } else {
            System.out.println("p");
            pApplet.fill(0,255,0);
        }

        pApplet.noStroke();
        float p_drawWidth = (p_hp / p_hp_max)*p_rectWidth;
        pApplet.rect(100,100,p_drawWidth,50);

        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(100,100,p_rectWidth,50);

        if (m_hp < 5) {
            System.out.println("m1/4");
            pApplet.fill(255,0,0);
        } else if(m_hp < 10){
            System.out.println("m1/2");
            pApplet.fill(255,200,0);
        } else {
            System.out.println("m");
            pApplet.fill(0,255,0);
        }

        pApplet.noStroke();
        if (hibino.Main.m_hit = true) {
            m_drawWidth = (m_hp / m_hp_max) * m_rectWidth;
            hibino.Main.m_hit = false;
        }
            System.out.println("rect_m");
        pApplet.rect(1000,100,m_drawWidth,50);
        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(1000,100,m_rectWidth,50);
    }

    public void monsterMove(){//普通のモンスターのスピード
        pointY += speedY;

        if(pointY < 290){
            speedY = 1;
        }

        if(pointY > 310){
            speedY = -1;
        }

        if(m_hp < 10){
            if(pointY < 290){
                speedY = 0.5f;
            }

            if(pointY > 310){
                speedY = -0.5f;
            }
        }
    }




//フェードアウト処理関数
    public void fadeOut () {
        //徐々に薄くする
        alpha = alpha - 10f;

        //透明になったら変化終了
        if (alpha < 0f) {
            alpha = 0f;
            cngAlpha = false;
        }
    }
//
//    public void lifeGauge(){
//        nowP_hp = nowP_hp/p_hp * p_lifegaugeWidth; //プレイヤーHP の比率計算
//        nowM_hp = nowM_hp/m_hp * m_lifegaugeWidth; //モンスターHP の比率計算
//    }





    public static void main(String[] args){
        PApplet.main("kotone.presentation.Presentation");
    }


}


