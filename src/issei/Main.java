package issei;

import processing.core.PApplet;
import processing.core.PImage;


public class Main extends PApplet {

    PImage mobu;//キャラデータ

    private int HP;//hp

    float x,y = 0;    //フロートで定義
    int speed = 3;    //speed初期値で３に定義
    int time = 0;
    boolean right, left, up, down;

    @Override
    public void settings(){
        size(480,480);
    }


    @Override
    public void setup(){
        mobu = loadImage("src/issei/data/img/character/mobu Dwalk.png");
    }

    @Override
    public void keyPressed() {// コード化されているキーが押された
        if (keyCode == RIGHT || key == 'd' || key == 'D'){
//            mobu=loadImage("src/issei/data/img/character/mobu Dwalk.png");
            right = true;
        }
        if (keyCode == LEFT || key == 'a' || key == 'A') {
//            mobu=loadImage("src/issei/data/img/character/mobu Awalk.png");
            left = true;
        }
        if (keyCode == UP || key == 'w' || key == 'W') {
//            mobu=loadImage("src/issei/data/img/character/mobu Wwalk.png");
            up = true;
        }
        if (keyCode == DOWN || key == 's' || key == 'S') {
//            mobu=loadImage("src/issei/data/img/character/mobuSwalk.png");
            down = true;
        }
    }
    @Override
    public void keyReleased() {//キーが離されたら
        if (keyCode == RIGHT || key == 'd' || key == 'D') {mobu=loadImage("src/issei/data/img/character/mobu Dstand.png");right = false;}
        if (keyCode == LEFT || key == 'a' || key == 'A') {mobu=loadImage("src/issei/data/img/character/mobu Astand.png");left = false;}
        if (keyCode == UP || key == 'w' || key == 'W') {mobu=loadImage("src/issei/data/img/character/mobu Wstand.png");up = false;}
        if (keyCode == DOWN || key == 's' || key == 'S') {mobu=loadImage("src/issei/data/img/character/mobuSstand.png");down = false;}
    }
        @Override
    public void draw() {
            background(0);
            drawImg();
            if (right) {
                time++;
                x += speed;
            }
            if (left) {
                time++;
                x -= speed;
            }
            if (up) {
                time++;
                y -= speed;
            }
            if (down) {
                time++;
                y += speed;
            }
            if (time > 60) time = 0;
        }

    public void drawImg(){
        if (up) {
            mobu = loadImage("src/issei/data/img/character/mobu Wwalk.png");
            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mobu Wwalk2.png");
            }
        }
        if (left){
            mobu = loadImage("src/issei/data/img/character/mobu Awalk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mobu Awalk2.png");
            }

        }
        if (down){
            mobu = loadImage("src/issei/data/img/character/mobuSwalk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mobuSwalk2.png");
            }

        }
        if (right){
            mobu = loadImage("src/issei/data/img/character/mobu Dwalk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mobuDwalk2.png");
            }

        }
        image(mobu, x, y);
    }
     public static void main(String[] args){
        PApplet.main("issei.Main");
    }
}
