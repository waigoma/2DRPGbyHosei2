package issei;

import processing.core.PApplet;
import processing.core.PImage;

public class PlayerMove {
    PImage mobu;//キャラデータ

    float x,y = 0;    //フロートで定義
    int speed = 3;    //speed初期値で３に定義
    int time = 0;
    boolean right, left, up, down;

    PApplet plet;

    public PlayerMove(PApplet papplet){
        this.plet = papplet;
    }


    public void setup(){
        mobu = plet.loadImage("src/issei/data/img/character/mobu Dwalk.png");
    }

    public void keyPressed() {// コード化されているキーが押された
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D'){
//            mobu=loadImage("src/issei/data/img/character/mobu Dwalk.png");
            right = true;
        }
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') {
//            mobu=loadImage("src/issei/data/img/character/mobu Awalk.png");
            left = true;
        }
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') {
//            mobu=loadImage("src/issei/data/img/character/mobu Wwalk.png");
            up = true;
        }
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') {
//            mobu=loadImage("src/issei/data/img/character/mobuSwalk.png");
            down = true;
        }
    }

    public void keyReleased() {//キーが離されたら
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') {mobu=plet.loadImage("src/issei/data/img/character/mobu Dstand.png");right = false;}
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') {mobu=plet.loadImage("src/issei/data/img/character/mobu Astand.png");left = false;}
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') {mobu=plet.loadImage("src/issei/data/img/character/mobu Wstand.png");up = false;}
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') {mobu=plet.loadImage("src/issei/data/img/character/mobuSstand.png");down = false;}
    }

    public void draw() {
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
            mobu = plet.loadImage("src/issei/data/img/character/mobu Wwalk.png");
            if (time > 30) {
                mobu = plet.loadImage("src/issei/data/img/character/mobu Wwalk2.png");
            }
        }
        if (left){
            mobu = plet.loadImage("src/issei/data/img/character/mobu Awalk.png");

            if (time > 30) {
                mobu = plet.loadImage("src/issei/data/img/character/mobu Awalk2.png");
            }

        }
        if (down){
            mobu = plet.loadImage("src/issei/data/img/character/mobuSwalk.png");

            if (time > 30) {
                mobu = plet.loadImage("src/issei/data/img/character/mobuSwalk2.png");
            }

        }
        if (right){
            mobu = plet.loadImage("src/issei/data/img/character/mobu Dwalk.png");

            if (time > 30) {
                mobu = plet.loadImage("src/issei/data/img/character/mobuDwalk2.png");
            }

        }
        plet.image(mobu, x, y);
    }
}
