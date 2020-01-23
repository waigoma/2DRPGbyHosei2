package waigoma.Title.TitleMenu;

import processing.core.PApplet;
import processing.core.PFont;
import waigoma.Main;

public class TitleMenu {//タイトルメニュー画面
    Button button;
    PApplet plet;
    int titleScene;
    PFont font;

    public TitleMenu(PApplet papplet, int titleScene){//mainからprocessing引継ぎ
        this.plet = papplet;
        this.titleScene = titleScene;

        font = plet.createFont("ＭＳ Ｐ明朝", 24);
        plet.rectMode(plet.CENTER);
        plet.textAlign(plet.CENTER, plet.CENTER);
        plet.noStroke();
        button = new Button(plet, plet.width/2f, plet.height/2f, 200, 100, "Start!");//Buttonクラスをインスタンス化
    }


    public void display(){//描写内容
        plet.background(128,128,128);
        plet.fill(0, 0, 0);
        plet.textFont(font,50);
        plet.text("テストォ", plet.width/2f, plet.height/4f);

        button.run();//Buttonクラス内のrun()呼び出し
        if (button.isPush()) Main.state = 1;//描写内のボタン(?)が押されたらMainクラス内のsceneを1に変更
    }
}
