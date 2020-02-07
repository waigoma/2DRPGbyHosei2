package kotone.presentation;

import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;

    public class Main extends PApplet {
        String p_name;    //文字列変数(プレイヤー名)                                                                   （クラス内で変数は定義）
        String m_name;    //モンスター名
        int p_hp;    //数値変数(プレイヤー体力)
        public static int m_hp;    //モンスター体力

        boolean tap_a = false;   //真偽変数（初期化するためにfalseにする)
        boolean tap_e = false;
        boolean p_hit = false;
        public static boolean m_hit = false;
        boolean battle = false;

        int start = 0;    //開始時間の初期化
        public static float keika = 0;    //経過時間の初期化
        int press_time = 0;    //ボタン押下時間

        Presentation presentation;


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

            noStroke();

            presentation = new Presentation(this);
            presentation.setup();
        }

    @Override
    public void draw() {
        presentation.draw();
        fill(255, 255, 255, 100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
        rect(100, 100, 200, 250);    //四角形（x座標、y座標、横の長さ、縦の長さ）
        stroke(0);    //枠線、（）内は色

        line(100, 170, 300, 170);    //直線（左２つの座標と右２つの座標を結んだ線）

        rect(500, 400, 500, 200);                                             //ここはナレーションの四角

        rect(1000, 100, 200, 100);                                                //ここは敵の四角


        fill(0);    //～の色
        textSize(23);    //文字の大きさ
        text(p_name, 110, 150);     //文字、x座標、y座標　　　                      ここはプレイヤーの四角内
        text("HP : " + p_hp, 110, 170);
        text("＜ 攻撃 (A) ＞", 120, 200);
        text("＜ 逃げる (E) ＞", 120, 250);

        text(m_name, 1010, 150);                                                   //ここは敵の四角内
        text("HP : " + m_hp, 1010, 170);

        keika = millis() - press_time;    //押されてからの経過時間

        text(m_name + "が現れた", 550, 450);                                           //ここからメインの流れ

        if (tap_a) {    //もしtap_aがtrueなら（Aが押されたら）
            if (keika < 1000 * 10)    //１０秒以内の時
                text(p_name + "の攻撃", 550, 480);//実行する

            if ((1000 * 5 < keika) && (keika < 1000 * 10)) {    //５～１０秒の時
                text("敵に１０ダメージ", 550, 510);
                if (m_hit) {    //もしm_hitがtrueなら（一回実行するため）
                    m_hp = m_hp - 10;    //体力ー１０
                    m_hit = false;//終了
                }
            }

            if ((1000 * 12 < keika) && (keika < 1000 * 20) && (m_hp != 0))    //１２～２０秒で敵体力が０じゃないとき                                                                    //ここから新しく
                text(m_name + "の攻撃", 550, 480);
            if ((1000 * 15 < keika) && (keika < 1000 * 20) && (m_hp != 0)) {
                text("プレイヤーに１０ダメージ", 550, 510);
                if (p_hit) {    //もしp_hitがtrueなら
                    p_hp = p_hp - 10;    //体力－１０
                    p_hit = false;    //終了
                }
            }

            if (m_hp == 0) {    //もしm_hpが０ならば
                text("敵を倒した", 550, 540);    //実行する
                Presentation.fadeMode = false;
                if (keika > 1000 * 10)    //経過が１２秒以上なら
                    exit();    //処理終了
            }
            if(keika > 1000*20) {
                battle = false;    //バトル終了
                tap_a = false;    //tap_a終了
            }
        }

        if (tap_e) {     //もしtap_eがtrueなら
            text("逃げ出した", 550, 480);    //実行する
            if(keika > 1000*2)    //経過が１２秒以上なら
                exit();    //処理終了
        }
    }

        @Override
        public void keyPressed () {    //キーボード対応
            if ((key == 'A' || key == 'a') && (!battle)) {   //もしAが押されバトルじゃないとき
                tap_a = true;    //tap_aはtrue
                p_hit = true;
                m_hit = true;
                battle = true;    //バトル中
                press_time = millis();    //押された時間の取得
            }

            if ((key == 'E' || key == 'e') && (!battle)) {     //もしEが押されバトルじゃないとき
                tap_e = true;    //tap_eはtrue　　
                battle = true;    //バトル中
                press_time = millis();    //押された時間の取得
            }
        }

        public static void main (String[]args){
            PApplet.main("kotone.presentation.Main");
        }
    }