package waigoma;

import processing.core.PApplet;
import processing.core.PFont;
import waigoma.Title.Title;

public class Main extends PApplet {
    public static int scene = 0;//画面シーン指定用

    Title title;
    Test test;

    @Override
    public void settings(){
        size(1280,720);
    }//ウィンドウ作成

    @Override
    public void setup(){
        test = new Test(this);
        title = new Title(this);
        noStroke();

        PFont font = createFont("MS Gothic", 50);
        textFont (font);
    }

    @Override
    public void keyPressed(){//キー入力受付
        if (scene == 1) test.keyPressed();
    }

    @Override
    public void keyReleased(){//キー解放受付
        if (scene == 1) test.keyReleased();
    }

    @Override
    public void draw(){//描写
        switch (scene){
            case 0:
                title.display();//Titleクラスのdisplay()呼び出し
                break;
            case 1:
                test.display();//Testクラスのdisplay()呼び出し
                break;
        }
    }

    public static void main(String[] args){//最初に呼び出される
        PApplet.main("waigoma.Main");//最初に読み込むprocessingを指定
    }
}
