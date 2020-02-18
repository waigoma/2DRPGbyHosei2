package waigoma.Title;

import processing.core.PApplet;
import processing.core.PFont;
import waigoma.FreeSpace.Testttt;
import waigoma.Test;
import waigoma.Title.TitleMenu.TitleMenu;

public class Title {//最初に表示されるタイトル画面
    int titleScene = 0;//タイトル画面のシーン番号

    float fadeAlpha = 255f;//フェードアウト用
    final float fadeSpeed = 1.75f;//フェードアウト速度
    PFont font;

    int count = 0;

    PApplet plet;
    TitleMenu titlemenu;
    Thread thread;
    Testttt test;

    public Title(PApplet papplet){
    this.plet = papplet;
    test = new Testttt("src/takano/bgm/キラーズ・シルエット.wav", true);
    titlemenu = new TitleMenu(papplet, titleScene, test);
    font = plet.createFont("src/waigoma/data/PixelMplus12-Regular.ttf", 24);

    plet.textAlign(plet.CENTER, plet.CENTER);
    }

    public void run(){
        if (count == 0){
            test.clip.start();
            count++;
        }
        if (titleScene == 0){
            display();
            fadeDisplay();
        }else if (titleScene == 1){//連続クリック対策
            plet.delay(500);//0.5秒遅延
            titleScene = 2;
        }else if (titleScene == 2){
            titlemenu.display();//titlemenuのdisplay表示
        }
    }

    public void display(){//固定表示display
        plet.background(0);//背景色：黒
        plet.fill(230);//文字の色：白
        plet.textFont(font, 72);//フォント指定・フォントサイズ指定
        plet.text("2DRPG by Hosei2", plet.width/2f, plet.height/3.8f);

        if (plet.keyPressed || plet.mousePressed){//いずれかのキーorマウスが押された時の処理
            titleScene = 1;
        }
    }

    public void fadeDisplay(){//フェードアウトするdisplay
        plet.textFont(font, 36);
        plet.fill(230,fadeAlpha);//アルファ値でフェードアウトさせる
        plet.text("Press any key...", plet.width/2f, plet.height/1.4f);

        fadeOutIn();
    }

    private void fadeOutIn(){
        if (fadeAlpha <= 255 && fadeAlpha!= 0){//フェードアウト
            fadeAlpha -= fadeSpeed;
        }

        if (fadeAlpha <= 0){//色を戻す
            fadeAlpha = 255;
        }
    }
}
