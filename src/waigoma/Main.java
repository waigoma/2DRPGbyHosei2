package waigoma;

import processing.core.PApplet;
import processing.core.PFont;
import waigoma.Map.MapTemplate;
import waigoma.Map.TMXLoader;
import waigoma.Title.Title;

public class Main extends PApplet {
    public static int state = 0;

    Title title;
    Test test;
    TMXLoader tmx;

    @Override
    public void settings(){
        size(1280,1000);
    }//ウィンドウ作成

    @Override
    public void setup(){
        title = new Title(this);//state:0
        test = new Test(this);//state:1
        tmx = new TMXLoader(this);

        noStroke();

        PFont font = createFont("MS Gothic", 50);
        textFont (font);
    }

    @Override
    public void keyPressed(){//キー入力受付
        if (state == 1) test.keyPressed();
    }

    @Override
    public void keyReleased(){//キー解放受付
        if (state == 1) test.keyReleased();
    }

    @Override
    public void draw(){//ステートマシン
        switch (state){
            case StateType.TITLE_STATE://タイトル画面
                title.run();
                break;
            case StateType.LOCAL_STATE:
                MapTemplate.maps.get("1village.tmx").display();
                test.display();
                break;
        }
    }

    public static void main(String[] args){//最初に呼び出される
        PApplet.main("waigoma.Main");//最初に読み込むprocessingを指定
    }
}
