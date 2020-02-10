package everyone;

import nagai.Collision;
import processing.core.PApplet;//ここでPAppletをimportしている

//クラス"Main"を作成し、PApplet(processing)を使いますと宣言(継承という)
public class Main extends PApplet {
    //以下processingと同様に書く
    float x, y = 0;//xとyをfloat型で定義
    int speed = 3;//int型のspeed変数を3で初期化
    boolean right, left, up, down;

    @Override//Overrideは継承したクラスの中身を使う宣言
    public void settings(){//settingsメソッド
        //processingだとvoid setup()でやっていたがここではsettings()でsize指定
        size(480,480);//画面サイズ
    }

    @Override
    public void setup(){
        //processingのsetup()と同様
    }

    @Override
    public void keyPressed(){//キーが押されたら
        if (keyCode == RIGHT || key == 'd' || key == 'D') right = true;//右をtrueにする
        if (keyCode == LEFT || key == 'a' || key == 'A') left = true;//左をtrueにする
        if (keyCode == UP || key == 'w' || key == 'W') up = true;//上を...
        if (keyCode == DOWN || key == 's' || key == 'S') down = true;//下を...
    }

    @Override
    public void keyReleased() {//キーが離されたら
        if (keyCode == RIGHT || key == 'd' || key == 'D') right = false;//右をfalseにする
        if (keyCode == LEFT || key == 'a' || key == 'A') left = false;//左をfalseにする
        if (keyCode == UP || key == 'w' || key == 'W') up = false;//上を...
        if (keyCode == DOWN || key == 's' || key == 'S') down = false;//下を...
    }

    @Override
    public void draw(){
        //processingのdraw()と同様
        background(0);//背景色(black)
        fill(255);//四角の色(white)

        if (right){//もし右ボタンが押されたら
            x += speed;
        }
        if (left){//もし左が
            x -= speed;
        }
        if (up){//もし上が
            y -= speed;
        }
        if (down){//もし下が
            y += speed;
        }
        rect(x, y, 30, 30);//(x,y)に30x30の四角形を描く
    }

    //Javaは下にある "public static void main(String[] args){}" が必ず最初に呼ばれる
    public static void main(String[] args){
        //PAppletのmain(最初に読み込むところ)はeveryoneフォルダの中のMainっていうファイルですよと指定してあげる
        PApplet.main("everyone.Main");
    }
    /*Pythonで書くと
    def main(String[] args):
        PApplet.main("everyone.Main")
        みたいな感じになると思う
     */
}
