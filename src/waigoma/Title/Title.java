package waigoma.Title;

import processing.core.PApplet;
import waigoma.Title.TitleMenu.TitleMenu;

public class Title {//最初に表示されるタイトル画面
    int titleScene = 0;//タイトル画面のシーン番号

    float fadeAlpha = 255f;//フェードアウト用
    float fadeSpeed = 1.75f;//フェードアウト速度

    PApplet plet;
    TitleMenu titlemenu;

    public Title(PApplet papplet){
    this.plet = papplet;
    titlemenu = new TitleMenu(papplet, titleScene);

    plet.textAlign(plet.CENTER, plet.CENTER);
    }

    public void run(){
        if (titleScene == 0){
            display();
            fadeDisplay();
        }else if (titleScene == 1){
            titlemenu.display();
        }
    }

    public void display(){//固定表示display
        plet.background(0);//背景色：黒
        plet.fill(230);//文字の色：白
        plet.textSize(72);//フォントサイズ
        plet.text("2DRPG by Hosei2", plet.width/2f, plet.height/3.8f);

        if (plet.keyPressed || plet.mousePressed){//いずれかのキーorマウスが押された時の処理
            titleScene = 1;
        }
    }

    public void fadeDisplay(){//フェードアウトするdisplay
        plet.textSize(36);
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
