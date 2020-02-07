package kotone.presentation;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.concurrent.atomic.AtomicInteger;

import static kotone.presentation.Main.m_hp;

public class Presentation {

    PImage haikei;
    PImage monster;
    PImage efect;
    float pointX;
    float pointY;
    float speedY;
    PApplet pApplet;
    Main combat;//Mainクラスのオブジェクトを作る
    float alpha = 255f;       //透明度
    boolean cngAlpha;    //変化開始FLG
    public static boolean fadeMode;    //フェードイン・アウト切り替えFLG

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

        pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);//背景の大きさ

        pApplet.tint(255f, alpha);//画像を透明度指定付きで表示
        pApplet.image(monster, pointX, pointY);//モンスターの位置

        monsterMove();

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

        if ((Main.p_hit) && (Main.keika > 1600) && (Main.keika < 1900)) {//もしm_hitがtrueなら（一回実行するため）
            pApplet.tint(255, 80, 31);
        } else {
            pApplet.noTint();//色を消す

        }

    }

    public void monsterMove(){//普通のモンスターのスピード
        pointY += speedY;

        if(pointY < 290){
            speedY = 1;
        }

        if(pointY > 310){
            speedY = -1;
        }

        if(Main.m_hp < 10){
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




    public static void main(String[] args){
        PApplet.main("kotone.presentation.Presentation");
    }


}


