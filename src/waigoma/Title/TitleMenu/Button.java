package waigoma.Title.TitleMenu;

import processing.core.PApplet;

public class Button{//ボタンの描写&動作処理
    float x, y;//座標
    float sizeX, sizeY;//箱のサイズ
    private int state;//押されたか判断
    private PApplet plet;
    String str;

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
        changeColor();
        plet.rect(x, y, sizeX, sizeY);
        plet.fill(0, 0, 100);
        plet.textSize(30);
        plet.text(str, x, y);
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
        if (!checkInMouse()) return 0;
        if (!plet.mousePressed) return 1;
        return 2;
    }

    public boolean isPush(){
        return checkState() == 2;
    }//押されたか判別

    private void logic(){//判別した結果の数字を変数に代入
        state = checkState();
    }

    private void changeColor(){//判別結果でボタンの色変更
        switch (state){
            case 0:
                plet.fill(100,128,100);
                break;
            case 1:
                plet.fill(50,128,50);
                break;
            case 2:
                plet.fill(25,64,25);
                break;
            default:
                plet.fill(0, 0, 0);
        }
    }

}
