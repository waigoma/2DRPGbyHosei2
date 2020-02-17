package kotone.presentation;

import processing.core.PApplet;
import processing.core.PImage;
import hibino.Main;
import gifAnimation.*;

import java.util.concurrent.atomic.AtomicInteger;

import static hibino.Main.*;
import static processing.core.PApplet.main;

//import static kotone.presentation.Main.m_hp;
//import static kotone.presentation.Main.p_hp;

public class Presentation extends PApplet {

    PImage haikei;
    PImage dorako;
    PImage batta;
    PImage kettosi;
    PImage efect;
    PImage lifegauge;

    float pointX;
    float pointY;
    float speedY;
    public static float p_drawWidth;
    public static float m_drawWidth;
    public static float p_rectWidth = 220;
    public static float m_rectWidth = 200;
    float alpha = 255f;       //透明度
    float glay = 255f;        //グレーの濃淡
    boolean cngAlpha;    //変化開始FLG
    boolean cngGlay;     //変化開始FLG


    PApplet pApplet;
    Gif cutAnimation;
    Gif bakuhatsuAnimation;
    Gif fireAnimation;
    Gif lightningAnimation;
    Gif monsterAnimation;

    public Presentation(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void setup(){

        haikei = pApplet.loadImage("src/kotone/deta/heigen3.jpg");
        pApplet.imageMode(pApplet.CENTER);
        haikei.resize(pApplet.width,pApplet.height);

        dorako = pApplet.loadImage("src/kotone/deta/dorako.png");    //filenameの書き方が違った（４７）
        batta = pApplet.loadImage("src/kotone/deta/batta.png");
        kettosi = pApplet.loadImage("src/kotone/deta/kettosi-.png");

        cngAlpha = false;//透明度の変化は「停止」にしておく
        cngGlay = false;//透明度の変化は「停止」にしておく
        //img.resize(300,480);
        pointX = pApplet.width/2;
        pointY = 300;
        speedY = 1;

        fadeOut();

        cutAnimation = new Gif(pApplet,"src/kotone/deta/cut2.gif");

        bakuhatsuAnimation = new Gif(pApplet,"src/kotone/deta/bakuhatsu.gif");
        bakuhatsuAnimation.play();

        fireAnimation = new Gif(pApplet,"src/kotone/deta/fire.gif");
        fireAnimation.play();

        lightningAnimation = new Gif(pApplet,"src/kotone/deta/lightning.gif");
        lightningAnimation.play();

        monsterAnimation = new Gif(pApplet,"src/kotone/deta/monster.gif");
        monsterAnimation.play();

        p_drawWidth = ((float) p_hp / Main.p_hp_max) * p_rectWidth;
        m_drawWidth = ((float) m_hp / Main.m_hp_max) * m_rectWidth;
    }


    public void draw() {
        if (Main.start_event){
            pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);//背景の大きさ

            pApplet.tint(255f, alpha);//画像を透明度指定付きで表示
            pApplet.image(img[int(random(0,3))], pointX, pointY);//モンスターの位置

            monsterMove();
            lifeGauge();
        }

        if(p_attack_event){
            pApplet.image(cutAnimation,pApplet.width/2, 300);
            cutAnimation.play();
        } else {

        }

        if((p_attack_event) && (p_random < 3)){
            pApplet.image(cutAnimation,pApplet.width/2, 300);
        }

        if((p_attack_event) && (tap_b)){
            pApplet.image(bakuhatsuAnimation,pApplet.width/2,300);
        }

        if((p_attack_event) && (tap_f)){
            pApplet.image(fireAnimation,width/2,300);
        }

        if((p_attack_event) && (tap_l)){
            pApplet.image(lightningAnimation,width/2,300);
        }

        if(m_damage_event){
            pApplet.tint(255, 80, 30);
            pApplet.image(img, pointX, pointY);
            pApplet.noTint();
        }

        if(m_attack_event){
            System.out.println("敵の攻撃");
            pApplet.image(monsterAnimation,width/2,height/2);
        }

        if((p_damage_event) && (m_random < 3)){
            pApplet.text("痛恨の一撃",500,500);
            pApplet.tint(255,80,30);

        }

        if((p_damage_event) && (m_random >= 3)) {  //ノーマルのダメージ
            pApplet.text("敵の攻撃を受けた", 500, 500);
            pApplet.tint(255,80,30);
        }

        if((finish_event) && (p_hp <= 0)){  //プレイヤーが死んだとき
            //徐々に濃くする
            glay = glay + 10f;

            //真っ黒になったら変化終了
            if(glay < 0f){
                glay = 0f;
                cngGlay = false;
            }

        if((finish_event) && (m_hp <= 0)){  //モンスターが死んだとき
            //徐々に薄くする
            alpha = alpha - 10f;

            //透明になったら変化終了
            if (alpha < 0f) {
                alpha = 0f;
                cngAlpha = false;
            }
        }

        if(Lvup_event){
            pApplet.text("レベルアップした",500,500);
        }

        if((escape_event) && (e_random < 3)){  //逃げ出せなかったとき
            pApplet.text("にげだせなかった",500,500);
        }

        if((escape_event) && (e_random >= 3)){  //逃げ出せたとき
            pApplet.text("逃げ出せた",500,500);
        }



//        //透明度を変化させる場合
//        if (!fadeMode) {
//            fadeOut();
//        }

            pApplet.tint(255, 80, 30);
            pApplet.image(dorako, pointX, pointY);
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

        if(m_hp < 10){
            if(pointY < 290){
                speedY = 0.5f;
            }

            if(pointY > 310){
                speedY = -0.5f;
            }
        }
    }

    public void lifeGauge(){
        if (p_hp < 25) {
            System.out.println("1/4");
            pApplet.fill(255, 0, 0);
        } else if (p_hp < 50) {
            System.out.println("1/2");
            pApplet.fill(255, 200, 0);
        } else {
            System.out.println("p");
            pApplet.fill(0, 255, 0);
        }

        pApplet.noStroke();
        //float p_drawWidth = (p_hp / p_hp_max) * p_rectWidth;
        pApplet.rect(100, 100, p_drawWidth, 40);

        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(100, 100, p_rectWidth, 40);

        if (m_hp < 5) {
            System.out.println("m1/4");
            pApplet.fill(255, 0, 0);
        } else if (m_hp < 10) {
            System.out.println("m1/2");
            pApplet.fill(255, 200, 0);
        } else {
            System.out.println("m");
            pApplet.fill(0, 255, 0);
        }

        pApplet.noStroke();
        if (hibino.Main.m_hit/* = true*/) {
            //m_drawWidth = (m_hp / Main.m_hp_max) * m_rectWidth;
            //hibino.Main.m_hit = false;
        }
        System.out.println("rect_m");
        pApplet.rect(1000, 100, m_drawWidth, 50);
        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(1000, 100, m_rectWidth, 50);
    }





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


