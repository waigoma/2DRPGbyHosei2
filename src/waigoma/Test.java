package waigoma;

import processing.core.PApplet;

public class Test {//四角い箱を真ん中に召喚→w,a,s,d,up,left,down,rightで自由自在に動かす
    PApplet plet;

    boolean right, left, up, down = false;
    float x, y;
    double speed = 3.0;//箱の動く速度

    public Test(PApplet papplet){//processingをmainから受け継ぎ
        this.plet = papplet;
        x = plet.width/2f;//画面の左右真ん中座標
        y = plet.height/2f;//画面の上下真ん中座標
    }

    //キー入力解放受付されたらここが呼ばれる
    public void keyPressed(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') right = true;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') left = true;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') up = true;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') down = true;
        if (plet.keyCode == plet.SHIFT) speed = 10.0;
    }
    public void keyReleased(){
        if (plet.keyCode == plet.RIGHT || plet.key == 'd' || plet.key == 'D') right = false;
        if (plet.keyCode == plet.LEFT || plet.key == 'a' || plet.key == 'A') left = false;
        if (plet.keyCode == plet.UP || plet.key == 'w' || plet.key == 'W') up = false;
        if (plet.keyCode == plet.DOWN || plet.key == 's' || plet.key == 'S') down = false;
        if (plet.keyCode == plet.SHIFT) speed = 3.0;
    }


    public void display(){//描写する指示
        plet.background(128);
        plet.fill(0);

        //各入力それぞれの処理
        if (right){
            x += speed;
        }
        if (left){
            x -= speed;
        }
        if (up){
            y -= speed;
        }
        if (down){
            y += speed;
        }

        plet.rect(x, y, 30, 30);//四角の場所と大きさ指定
    }

}
