package waigoma.Title.TitleMenu;

import processing.core.PApplet;
import processing.core.PImage;

public class Button{//ボタンの描写&動作処理
    float x, y;//座標
    float sizeX, sizeY;//箱のサイズ
    private int state;//押されたか判断
    private PApplet plet;
    String str;
    PImage buttonFrame;

    public Button(PApplet papplet, float x, float y, float sizeX, float sizeY, String str){
        this.plet = papplet;//mainからprocessing引継ぎ
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.str = str;

    }

    public void run(){//Titleクラスのdisplayで呼ばれる
        display();
        logic();
    }

    private void display(){//ボタンの描写//runで呼び出し
        plet.fill(35);
        plet.stroke(40);
        plet.strokeWeight(10);
        plet.strokeJoin(plet.BEVEL);
        plet.rect(x, y, sizeX, sizeY);
        plet.fill(255);
        plet.textSize(36);
        plet.text(str, x, y);
        changeColor();
    }

    private boolean checkInMouse(){//マウスがボタンの上に乗ってるか乗ってないか判別
        if (plet.mouseX > x-sizeX/2 && plet.mouseX < x+sizeX/2){
            if (plet.mouseY > y-sizeY/2 && plet.mouseY < y+sizeY/2){
                return true;
            }
        }
        return false;
    }

    private int checkState(){//判別した結果を数字で返す
        if (!checkInMouse()) return 0;//ボタンにマウスが乗ってないとき
        if (!plet.mousePressed) return 1;//ボタンにマウスが乗ってるとき
        return 2;//クリックしたとき
    }

    public boolean isPush(){
        return checkState() == 2;
    }//押されたか判別

    private void logic(){//判別した結果の数字を変数に代入
        state = checkState();
    }

    private void changeColor(){//判別結果でボタンの色変更
        switch (state){
            case 0://default
                break;
            case 1://マウスが乗っかってるとき
                plet.text("> "+ str + " <", x, y);
                break;
            case 2://押したとき
                plet.fill(0);
                break;
        }
    }

}
