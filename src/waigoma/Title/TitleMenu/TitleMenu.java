package waigoma.Title.TitleMenu;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import waigoma.FreeSpace.Testttt;
import waigoma.Main;
import waigoma.StateType;
import waigoma.Title.Option.Option;
import waigoma.Title.Option.OptionFile;

public class TitleMenu {//タイトルメニュー画面
    Button button, button1, button2;
    PApplet plet;
    int titleScene;
    PFont font;

    Option option;
    OptionFile opFile;
    Testttt thread;

    public TitleMenu(PApplet papplet, int titleScene, Testttt thread){//mainからprocessing引継ぎ
        this.plet = papplet;
        this.titleScene = titleScene;
        this.thread = thread;
//        this.titleFrame = plet.loadImage("src/waigoma/img/photo_frame1.png");

        opFile = new OptionFile();
        opFile.loadOption();
        option = new Option(opFile.getDifficulty());
        option.properties();

        font = plet.createFont("src/waigoma/data/PixelMplus12-Regular.ttf", 24);
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

        plet.textSize(24);
        plet.fill(255);
        plet.text(opFile.getDifficulty(), plet.width/1.25f, plet.height/5f);

//        plet.stroke(255);
//        plet.fill(30);
//        plet.rect(plet.width/1.9f, plet.height/1.6f, 600, 300);
//        plet.image(titleFrame, plet.width/2f, plet.height/1.8f);

        button.run();//Buttonクラス内のrun()呼び出し
        button1.run();
        button2.run();
        if (button.isPush()) {
            thread.clip.close();
            Main.state = StateType.LOCAL_STATE;//描写内のボタン(?)が押されたらMainクラス内のstateを1に変更
        }
        if (button1.isPush()){
            switch (opFile.getDifficulty()){
                case "easy":
                    opFile.setDifficulty("normal");
                    opFile.saveOption();
                    break;
                case "normal":
                    opFile.setDifficulty("hard");
                    opFile.saveOption();
                    break;
                case "hard":
                    opFile.setDifficulty("easy");
                    opFile.saveOption();
                    break;
            }
            option = new Option(opFile.getDifficulty());
            option.properties();
            plet.delay(100);
        }
        if (button2.isPush()) {//exit押されたら終了
            plet.delay(100);//0.1秒の遅延(クリックバグ対策)
            plet.exit();
        }
    }
}
