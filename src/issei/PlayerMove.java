package issei;

import nagai.Collision;
import processing.core.PApplet;
import processing.core.PImage;

public class PlayerMove {
    PImage mob;//キャラデータ

    //フロートで定義
    int speed = 3;    //speed初期値で３に定義
    int time = 0;
    public static boolean right, left, up, down;

    PApplet plet;

    public PlayerMove(PApplet papplet){
        this.plet = papplet;
    }


    public void setup(){
        mob = plet.loadImage("src/issei/data/img/character/mob_S_stand.png");
        Collision.PlayerWidth = mob.width;
        Collision.PlayerHeight = mob.height;
    }

    public void keyPressed() {// コード化されているキーが押された
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') right = true;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') left = true;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') up = true;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') down = true;
    }
    public void keyReleased() {//キーが離されたら
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') {
            mob=plet.loadImage("src/issei/data/img/character/mob_D_stand.png");
            right = false;
        }
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') {
            mob=plet.loadImage("src/issei/data/img/character/mob_A_stand.png");
            left = false;
        }
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') {
            mob=plet.loadImage("src/issei/data/img/character/mob_W_stand.png");
            up = false;
        }
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') {
            mob=plet.loadImage("src/issei/data/img/character/mob_S_stand.png");
            down = false;
        }
    }

    public void draw() {
        drawImg();
        if (right) {
            time++;
            Collision.Playerx += speed;
        }
        if (left) {
            time++;
            Collision.Playerx -= speed;
        }
        if (up) {
            time++;
            Collision.Playery -= speed;
        }
        if (down) {
            time++;
            Collision.Playery += speed;
        }
        if (time > 60) time = 0;
    }

    public void drawImg(){
        if (up) {
            mob = plet.loadImage("src/issei/data/img/character/mob_W_walk.png");
            if (time > 30) {
                mob = plet.loadImage("src/issei/data/img/character/mob_W_walk2.png");
            }
        }
        if (left){
            mob = plet.loadImage("src/issei/data/img/character/mob_A_walk.png");

            if (time > 30) {
                mob = plet.loadImage("src/issei/data/img/character/mob_A_walk2.png");
            }

        }
        if (down){
            mob = plet.loadImage("src/issei/data/img/character/mob_S_walk.png");

            if (time > 30) {
                mob = plet.loadImage("src/issei/data/img/character/mob_S_walk2.png");
            }

        }
        if (right){
            mob = plet.loadImage("src/issei/data/img/character/mob_D_walk.png");

            if (time > 30) {
                mob = plet.loadImage("src/issei/data/img/character/mob_D_walk2.png");
            }

        }
        plet.image(mob, Collision.Playerx, Collision.Playery);
    }
}
