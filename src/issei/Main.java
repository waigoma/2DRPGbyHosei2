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
        mobu = loadImage("src/issei/data/img/character/mob_D_walk.png");
    }

    @Override
    public void keyPressed() {// コード化されているキーが押された
        if (keyCode == RIGHT || key == 'd' || key == 'D') right = true;
        if (keyCode == LEFT || key == 'a' || key == 'A') left = true;
        if (keyCode == UP || key == 'w' || key == 'W') up = true;
        if (keyCode == DOWN || key == 's' || key == 'S') down = true;
    }
    @Override
    public void keyReleased() {//キーが離されたら
        if (keyCode == RIGHT || key == 'd' || key == 'D') {mobu=loadImage("src/issei/data/img/character/mob_D_stand.png");right = false;}
        if (keyCode == LEFT || key == 'a' || key == 'A') {mobu=loadImage("src/issei/data/img/character/mob_A_stand.png");left = false;}
        if (keyCode == UP || key == 'w' || key == 'W') {mobu=loadImage("src/issei/data/img/character/mob_W_stand.png");up = false;}
        if (keyCode == DOWN || key == 's' || key == 'S') {mobu=loadImage("src/issei/data/img/character/mob_S_stand.png");down = false;}
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
            mobu = loadImage("src/issei/data/img/character/mob_W_walk.png");
            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mob_W_walk2.png");
            }
        }
        if (left){
            mobu = loadImage("src/issei/data/img/character/mob_A_walk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mob_A_walk2.png");
            }

        }
        if (down){
            mobu = loadImage("src/issei/data/img/character/mob_S_walk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mob_S_walk2.png");
            }

        }
        if (right){
            mobu = loadImage("src/issei/data/img/character/mob_D_walk.png");

            if (time > 30) {
                mobu = loadImage("src/issei/data/img/character/mob_D_walk2.png");
            }

        }
        image(mobu, x, y);
    }
     public static void main(String[] args){
        PApplet.main("issei.Main");
    }
}
