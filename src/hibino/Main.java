package hibino;


import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;


public class Main extends PApplet {
    String p_name;    //文字列変数（クラス内で変数は定義）
    String m_name;
    int p_hp;    //数値変数(体力)
    int m_hp;

    boolean tap_a = false;   //真偽変数（初期化するためにfalseにする)
    boolean tap_e = false;

    int start = 0;    //開始時間の初期化
    int keika;    //経過時間


    @Override
    public void settings(){
        size(1280,750);

    }

    @Override
    public void setup(){
        PFont font;    //日本語対応（以下３行）
        font=createFont("MS 明朝",30);
        textFont(font);

        p_name = "プレイヤー名";
        p_hp = 100;    //体力
        m_name = "モンスター名";
        m_hp = 20;



        start = millis();    //開始時間を取得



        noStroke();



    }

    @Override
    public void draw(){
        background(0,255,0);    //背景色（赤、緑、青）(0:黒、255:白)

        fill(255,255,255,100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
        rect(100,100,200,250);    //四角形（x座標、y座標、横の長さ、縦の長さ）
        stroke(0);    //枠線、（）内は色

        line(100,   170,300,170);    //直線（左２つの座標と右２つの座標を結んだ線）

        rect(500,400,500,200);                                             //ここはナレーションの四角

        rect(1000,100,200,100);                                                //ここは敵の四角




        fill(0);    //～の色
        textSize(23);    //文字の大きさ
        text(p_name, 110,150);     //文字、x座標、y座標　　　                      ここはプレイヤーの四角内
        text("HP : "+ p_hp , 110, 170);
        text("＜ 攻撃 (A) ＞", 120,200);
        text("＜ 逃げる (E) ＞", 120,250);

        text(m_name, 1010,150);                                                   //ここは敵の四角内
        text("HP : " + m_hp,1010,170);

        keika = millis() - start;    //何秒後かの計算

        text("敵が現れた",550,450);                                               //ここからメインの流れ
        if (tap_a)    //もしtap_aがtrueなら
            text(p_name +"の攻撃",550,480);    //実行する
        if ((tap_a) && (1000*5 < keika) && (keika <1000*10))
            text("敵に１０ダメージ",550,510);
        if ((tap_a) && (1000*13 < keika) && (keika < 1000*20))                                                                        //ここから新しく
            text(m_name + "の攻撃",550,480);
        if ((tap_a) && (1000*15 < keika) && (keika < 1000*20))
            text("プレイヤーに１０ダメージ",550,510);

        if (m_hp == 0)    //もしm_hpが０なら
            text("敵を倒した",550,540);    //実行する


        if (tap_e)    //もしtap_eがtrueなら
            text("逃げ出した", 550, 480);    //実行する

    }
    @Override
    public void keyPressed(){    //キーボード対応
        if (key =='A' || key == 'a') {   //もしAが押されたら
            tap_a = true;    //tap_aはtrue
            m_hp = m_hp - 10;    //m_hpをー１０する
            p_hp = p_hp - 10;    //p_hpをー１０する
        }


        if (key == 'E'  || key == 'e') {    //もしEが押されたら
            tap_e = true;    //tap_eはtrue　　　
        }


    }


    public static void main(String[] args){
        PApplet.main("hibino.Main");
    }
}
