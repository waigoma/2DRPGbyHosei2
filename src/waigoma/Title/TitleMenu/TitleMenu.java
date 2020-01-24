package waigoma.Title.TitleMenu;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import waigoma.Main;

public class TitleMenu {//タイトルメニュー画面
    Button button, button1, button2;
    PApplet plet;
    int titleScene;
    PFont font;
    PImage titleFrame;

    public TitleMenu(PApplet papplet, int titleScene){//mainからprocessing引継ぎ
        this.plet = papplet;
        this.titleScene = titleScene;
//        this.titleFrame = plet.loadImage("src/waigoma/img/photo_frame1.png");

        font = plet.createFont("waigoma/data/PixelMplus12-Regular.ttf", 24);
        plet.rectMode(plet.CENTER);
        plet.textAlign(plet.CENTER, plet.CENTER);
        plet.imageMode(plet.CENTER);
        button = new Button(plet, plet.width/2f, plet.height/2.027f, 450, 70, "Game Start");//Buttonクラスをインスタンス化
        button1 = new Button(plet, plet.width/2f, plet.height/1.64f, 450, 70, "Option");
        button2 = new Button(plet, plet.width/2f, plet.height/1.375f, 450, 70, "Exit");
    }


    public void display(){//描写内容
        plet.background(30);
        plet.fill(230);
        plet.textFont(font,48);
        plet.text("2DRPG by Hosei2", plet.width/4f, plet.height/8f);
        plet.text("MENU", plet.width/3.8f, plet.height/4f);

//        plet.stroke(255);
//        plet.fill(30);
//        plet.rect(plet.width/1.9f, plet.height/1.6f, 600, 300);
//        plet.image(titleFrame, plet.width/2f, plet.height/1.8f);

        button.run();//Buttonクラス内のrun()呼び出し
        button1.run();
        button2.run();
        if (button.isPush()) Main.state = 1;//描写内のボタン(?)が押されたらMainクラス内のsceneを1に変更
        if (button1.isPush()) System.out.println("Option");
        if (button2.isPush()) {//exit押されたら終了
            plet.delay(100);//0.1秒の遅延(クリックバグ対策)
            plet.exit();
        }
    }
}
