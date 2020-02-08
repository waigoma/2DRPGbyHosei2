package waigoma;

import processing.core.PApplet;
import processing.core.PFont;
import waigoma.Map.LocalMap.LocalMap;
import waigoma.Map.TMXLoader;
import waigoma.Title.Title;

public class Main extends PApplet {
    public static int state = 0;

    TMXLoader tmx;
    Title title;
    Test test;
    LocalMap localMap;

    @Override
    public void settings(){
        size(1280,720);
    }//ウィンドウ作成

    @Override
    public void setup(){
        tmx = new TMXLoader(this);//loadMaps
        title = new Title(this);//state:0
        test = new Test(this);
        localMap = new LocalMap(this);//state:1

        surface.setResizable(true);
        noStroke();

        PFont font = createFont("MS Gothic", 50);
        textFont (font);
    }

    @Override
    public void keyPressed(){//キー入力受付
        if (state == 1) localMap.keyPressed();
    }

    @Override
    public void keyReleased(){//キー解放受付
        if (state == 1) localMap.keyReleased();
    }

    @Override
    public void draw(){//ステートマシン
        switch (state){
            case StateType.TITLE_STATE://タイトル画面
                title.run();
                break;
            case StateType.LOCAL_STATE:
                localMap.display();
                break;
            case StateType.WORLD_STATE:
                break;
        }
    }

    public static void main(String[] args){//最初に呼び出される
        PApplet.main("waigoma.Main");//最初に読み込むprocessingを指定
    }
}
