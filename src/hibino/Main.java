package hibino;


import processing.core.PApplet;
import processing.core.PFont;


public class Main extends PApplet {
    String str;    //文字列変数（クラス内で変数は定義）
    int h ;    //数値変数
    boolean tap = false;

    @Override
    public void settings(){
        size(1280, 720);

    }

    @Override
    public void setup(){
        PFont font;    //日本語対応
        font=createFont("MS 明朝",30);
        textFont(font);

        h = 100;    //体力
        str = "プレイヤー名";

        noStroke();



    }

    @Override
    public void draw(){
        background(0,255,0);    //背景色（赤、緑、青）(0:黒、255:白)

        fill(255,255,255,100);    //～の色（４つ目は透明度）
        rect(100,100,200,250);    //四角形（x座標、y座標、横の長さ、縦の長さ）
        stroke(0);    //枠線、（）内は色



        fill(0);    //～の色
        textSize(23);    //文字の大きさ
        text(str, 110,150);     //文字、x座標、y座標]
        text("HP :"+ h , 110, 170);
        text("＜攻撃＞", 120,200);
        text("＜逃げる＞", 120,250);

        line(100,   170,300,170);    //直線（左２つの座標と右２つの座標を結んだ線）


        if (tap)text("逃げ出した", 300, 400);

    }
    @Override
    public void keyPressed(){    //キーボード対応
        if (key =='A')    //もしAが押されたら
            h = h - 10;    //実行する


        if (key == 'E'  || key == 'e') {
            tap = true;
        }


    }


    public static void main(String[] args){
        PApplet.main("hibino.Main");
    }
}
