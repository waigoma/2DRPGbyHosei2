package waigoma;

import hibino.Combat;
import nagai.Collision;
import processing.core.PApplet;
import processing.core.PFont;
import taku.Encounter;
import waigoma.Map.LocalMap.LocalMap;
import waigoma.Map.TMXLoader;
import waigoma.Map.WorldMap.WorldMap;
import waigoma.Title.Title;

public class Main extends PApplet {
    public static int state = 0;

    TMXLoader tmx;
    Title title;
    LocalMap localMap;
    WorldMap worldMap;
    Combat combat;
    Encounter encounter;

    int count = 0;

    @Override
    public void settings(){
        size(1280,720);
    }//ウィンドウ作成

    @Override
    public void setup(){
        tmx = new TMXLoader(this);//loadMaps
        title = new Title(this);//state:0
        localMap = new LocalMap(this);//state:1
        worldMap = new WorldMap(this);//state:2
        combat = new Combat(this);
        encounter = new Encounter(this);

        surface.setResizable(true);
        noStroke();

        PFont font = createFont("MS Gothic", 50);
        textFont (font);
    }

    @Override
    public void keyPressed(){//キー入力受付
        if (state == StateType.LOCAL_STATE) localMap.keyPressed();
        if (state == StateType.WORLD_STATE) worldMap.keyPressed();
        if (state == StateType.COMBAT_STATE) combat.keyPressed();
    }

    @Override
    public void keyReleased(){//キー解放受付
        if (state == StateType.LOCAL_STATE) localMap.keyReleased();
        if (state == StateType.WORLD_STATE) worldMap.keyReleased();
//        if (state == StateType.COMBAT_STATE) main.keyReleased();
    }

    @Override
    public void draw(){//ステートマシン
        System.out.println("x: "+ Collision.Playerx+" "+"y: "+ Collision.Playery);
//        state = StateType.COMBAT_STATE;
        switch (state){
            case StateType.TITLE_STATE://タイトル画面
                title.run();
                break;
            case StateType.LOCAL_STATE:
                localMap.display();
                break;
            case StateType.WORLD_STATE:
                worldMap.display();
                encounter.randomEncounter();
                break;
            case StateType.COMBAT_STATE:
                if (count == 0){
                    combat.setup();
                    count++;
                }
                combat.draw();
                break;
        }
    }

    public static void main(String[] args){//最初に呼び出される
        PApplet.main("waigoma.Main");//最初に読み込むprocessingを指定
    }
}
