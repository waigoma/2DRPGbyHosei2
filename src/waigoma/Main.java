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

import java.util.Scanner;

public class Main extends PApplet {
    public static int state = 0;
    boolean opMode, control, enter = false;
    int count = 0;

    TMXLoader tmx;
    Title title;
    LocalMap localMap;
    WorldMap worldMap;
    Combat combat;
    Encounter encounter;
    Scanner scan;

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
        scan = new Scanner(System.in);

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
        if (keyCode == CONTROL) control = true;
        if (keyCode == ENTER) enter = true;
    }

    @Override
    public void keyReleased(){//キー解放受付
        if (state == StateType.LOCAL_STATE) localMap.keyReleased();
        if (state == StateType.WORLD_STATE) worldMap.keyReleased();
        if (keyCode == CONTROL) control = false;
        if (keyCode == ENTER) enter = false;
//        if (state == StateType.COMBAT_STATE) main.keyReleased();
    }

    @Override
    public void draw(){//ステートマシン
//        System.out.println("x: "+ Collision.Playerx+" "+"y: "+ Collision.Playery);
//        state = StateType.COMBAT_STATE;
        if (control && enter){
            opMode = !opMode;
            delay(250);
        }
        if (opMode){
            if (count == 0) {
                System.out.println("飛びたいstate");
                String sTypes = scan.next();
                System.out.println("飛びたいマップ");
                int sType = Integer.parseInt(sTypes);
                String wMap = scan.next();
                state = sType;
                worldMap.setMapTmp(wMap);
                LocalMap.count = 0;
                count++;
            }
        }
        switch (state){
            case StateType.TITLE_STATE://タイトル画面
                title.run();
                break;
            case StateType.LOCAL_STATE:
//                System.out.println("1");
                localMap.display();
                break;
            case StateType.WORLD_STATE:
//                System.out.println("2");
                worldMap.display();
                encounter.randomEncounter();
                break;
            case StateType.COMBAT_STATE:
//                System.out.println("3");
                combat.draw();
                break;
        }
    }

    public static void main(String[] args){//最初に呼び出される
        PApplet.main("waigoma.Main");//最初に読み込むprocessingを指定
    }
}
