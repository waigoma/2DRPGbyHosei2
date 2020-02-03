package waigoma.FreeSpace;

import processing.core.PApplet;
import waigoma.Title.Title;

public class Testtt extends PApplet {

    Title title;//タイトルクラスのオブジェクトを作る

    @Override
    public void settings(){
        size(1280, 720);
    }

    @Override
    public void setup(){
        title = new Title(this);//タイトルクラスのオブジェクトにタイトルクラスをインスタンス化して入れる
    }

    @Override
    public void draw(){
        title.run();//タイトルクラスの中身が使えるようになる
    }

    public static void main(String[] args){
        PApplet.main("waigoma.FreeSpace.Testt");
    }
}
