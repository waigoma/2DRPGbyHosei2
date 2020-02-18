package kotone.presentation;

import processing.core.PApplet;
import processing.core.PImage;
import hibino.Combat;
import gifAnimation.*;

import java.util.concurrent.atomic.AtomicInteger;

import static hibino.Combat.*;
import static processing.core.PApplet.main;

//import static kotone.presentation.Combat.m_hp;
//import static kotone.presentation.Combat.p_hp;

public class Presentation extends PApplet {

    PImage haikei;
    PImage ari;
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
    float gray = 255f;        //グレーの濃淡
    boolean cngAlpha;    //変化開始FLG
    boolean cngGlay;     //変化開始FLG


    PApplet pApplet;
    Gif cutAnimation;
    Gif bakuhatsuAnimation;
    Gif fireAnimation;
    Gif lightningAnimation;
    Gif hikkakiAnimation;

    public Presentation(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public void setup(){

        haikei = pApplet.loadImage("src/kotone/deta/heigen3.jpg");
        pApplet.imageMode(pApplet.CENTER);
        haikei.resize(pApplet.width,pApplet.height);

        ari = pApplet.loadImage("src/kotone/deta/ari.png");    //filenameの書き方が違った（４７）
        batta = pApplet.loadImage("src/kotone/deta/batta.png");
        kettosi = pApplet.loadImage("src/kotone/deta/kettosi-.png");



        cngAlpha = false;//透明度の変化は「停止」にしておく
        cngGlay = false;//透明度の変化は「停止」にしておく
        //img.resize(300,480);
        pointX = pApplet.width/2;
        pointY = 300;
        speedY = 1;

        cutAnimation = new Gif(pApplet,"src/kotone/deta/cut2.gif");

        bakuhatsuAnimation = new Gif(pApplet,"src/kotone/deta/bakuhatsu2.1.gif");
//        bakuhatsuAnimation.play();

        fireAnimation = new Gif(pApplet,"src/kotone/deta/fire2.1.1.gif");
//        fireAnimation.play();

        lightningAnimation = new Gif(pApplet,"src/kotone/deta/lightning2.1.gif");
//        lightningAnimation.play();

        hikkakiAnimation = new Gif(pApplet,"src/kotone/deta/hikkaki3.1.gif");
//        monsterAnimation.play();

        p_drawWidth = ((float) p_hp / Combat.p_hp_max) * p_rectWidth;
        m_drawWidth = ((float) m_hp / Combat.m_hp_max) * m_rectWidth;
    }


    public void draw() {
        if (Combat.start_event){
            pApplet.tint(gray);
//            pApplet.tint(255,255);
            pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);//背景の大きさ

            if (m_name.equals("モンスターA")){
                pApplet.tint(255,alpha);
                pApplet.image(ari,pointX,pointY);
            }

            if (m_name.equals("モンスターB")){
                pApplet.tint(255,alpha);
                pApplet.image(batta,pointX,pointY);
            }

            if (m_name.equals("モンスターC")){
                pApplet.tint(255,alpha);
                pApplet.image(kettosi,pointX,pointY);
            }

            //pApplet.tint(255f, alpha);//画像を透明度指定付きで表示
//            pApplet.image(img[int(random(0,3))], pointX, pointY);//モンスターの位置

            monsterMove();
            lifeGauge();
        }

        if(p_attack_event){
            if(p_random < 3){
                cutAnimation.play();
                pApplet.image(cutAnimation,pApplet.width/2, 300);
            } else  if(tap_b){
                bakuhatsuAnimation.play();
                pApplet.image(bakuhatsuAnimation,pApplet.width/2,300);
            } else if(tap_f){
                fireAnimation.play();
                pApplet.image(fireAnimation,pApplet.width/2,300);
            } else if(tap_l){
                lightningAnimation.play();
                pApplet.image(lightningAnimation,pApplet.width/2,300);
            } else {
                cutAnimation.play();
                pApplet.image(cutAnimation,pApplet.width/2, 300);
            }
        }

        if(m_damage_event){
            if (m_name.equals("モンスターA")){
                pApplet.tint(255, 80, 30);
                pApplet.image(ari, pointX, pointY);
                pApplet.noTint();
            } else if (m_name.equals("モンスターB")){
                pApplet.tint(255, 80, 30);
                pApplet.image(batta, pointX, pointY);
                pApplet.noTint();
            } else if (m_name.equals("モンスターC")){
                pApplet.tint(255, 80, 30);
                pApplet.image(kettosi, pointX, pointY);
                pApplet.noTint();
            }
        }

        if(m_attack_event){
            hikkakiAnimation.play();
            pApplet.image(hikkakiAnimation,pApplet.width/2,pApplet.height/2);
        }

        if((p_damage_event) && (m_random < 3)){
            if (m_name.equals("モンスターA")){
                pApplet.tint(255, 80, 30);
                pApplet.image(ari, pointX, pointY);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            } else if (m_name.equals("モンスターB")){
                pApplet.tint(255, 80, 30);
                pApplet.image(batta, pointX, pointY);
                pApplet.tint(255, 80, 30);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            } else if (m_name.equals("モンスターC")){
                pApplet.tint(255, 80, 30);
                pApplet.image(kettosi, pointX, pointY);
                pApplet.tint(255, 80, 30);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            }
        }

        if((p_damage_event) && (m_random >= 3)) {  //ノーマルのダメージ
            if (m_name.equals("モンスターA")){
                pApplet.tint(255, 80, 30);
                pApplet.image(ari, pointX, pointY);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            } else if (m_name.equals("モンスターB")){
                pApplet.tint(255, 80, 30);
                pApplet.image(batta, pointX, pointY);
                pApplet.tint(255, 80, 30);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            } else if (m_name.equals("モンスターC")){
                pApplet.tint(255, 80, 30);
                pApplet.image(kettosi, pointX, pointY);
                pApplet.tint(255, 80, 30);
                pApplet.image(haikei, pApplet.width / 2, pApplet.height / 2);
            }
        }

        if((finish_event) && (p_hp <= 0)) {  //プレイヤーが死んだとき
            pApplet.background(gray);
            //徐々に濃くする
            gray = gray - 10f;

            //真っ黒になったら変化終了
            if (gray < 0f) {
                gray = 0f;
                cngGlay = false;
            }
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


        if((escape_event) && (e_random >= 3)){  //逃げ出せたとき
            pApplet.background(gray);
            //徐々に濃くする
            gray = gray - 5f;

            //真っ黒になったら変化終了
            if(gray < 0f){
                gray = 0f;
                cngGlay = false;
            }
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
            pApplet.fill(255, 0, 0);
        } else if (p_hp < 50) {
            pApplet.fill(255, 200, 0);
        } else {
            pApplet.fill(0, 255, 0);
        }

        pApplet.noStroke();
        pApplet.rect(100, 100, p_drawWidth, 40);
        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(100, 100, p_rectWidth, 40);

        if (m_hp < 5) {
            pApplet.fill(255, 0, 0);
        } else if (m_hp < 10) {
            pApplet.fill(255, 200, 0);
        } else {
            pApplet.fill(0, 255, 0);
        }

        pApplet.noStroke();
        pApplet.rect(1000, 100, m_drawWidth, 50);
        pApplet.stroke(0);
        pApplet.noFill();
        pApplet.rect(1000, 100, m_rectWidth, 50);
    }


    public static void main(String[] args){
        PApplet.main("kotone.presentation.Presentation");
    }

}


