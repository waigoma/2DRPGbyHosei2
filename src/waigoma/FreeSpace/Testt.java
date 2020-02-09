package waigoma.FreeSpace;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

public class Testt extends PApplet {

    File dir = new File("src/waigoma/data/img");//画像がいっぱい入ってるフォルダの場所
    File[] list;//画像ファイルのリストを配列として作ります
    PImage img;//imageの配列

    @Override
    public void settings(){
        size(1280, 720);
    }

    @Override
    public void setup(){
        list = dir.listFiles();
        loadImage();
    }

    @Override
    public void draw(){
        img = loadImage(list[0].toString());
        image(img,0,0);
    }

    public void loadImage(){
        for (int i = 0; i < list.length; i++){//for文、list.lengthはlistという変数の配列は何項目あるかを取得
            //↓もしそのファイルがフォルダではなくファイルであり、".png"か".jpg"を含んでいたならば
            if (list[i].isFile() && (list[i].getName().contains(".png") || list[i].getName().contains(".jpg"))){
                System.out.println(list[i].getName());//"コンソールに書き出します"(System.out.println)","listのi番目のファイル名"(list[i].getName())を
            }
        }
    }
    public static void main(String[] args){
        PApplet.main("waigoma.FreeSpace.Testt");
    }
}
