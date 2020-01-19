package waigoma.Title;

import processing.core.PApplet;
import waigoma.Main;

public class Title{//最初のタイトル画面
    Button button;
    PApplet plet;

    public Title(PApplet papplet){//mainからprocessing引継ぎ
        this.plet = papplet;

        plet.rectMode(plet.CENTER);
        plet.textAlign(plet.CENTER, plet.CENTER);
        plet.noStroke();
        button = new Button(plet, plet.width/2, plet.height/2, 200, 100, "Start!");//Buttonクラスをインスタンス化
    }


    public void display(){//描写内容
        plet.background(128,128,128);
        plet.fill(0, 0, 0);
        plet.text("テストォ", plet.width/2, plet.height/4);

        button.run();//Buttonクラス内のrun()呼び出し
        if (button.isPush()) Main.scene = 1;//描写内のボタン(?)が押されたらMainクラス内のsceneを1に変更
    }
}
