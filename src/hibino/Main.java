package hibino;

import kotone.presentation.Presentation;
import processing.core.PApplet;
import processing.core.PFont;
import processing.data.Table;
import waigoma.Title.Title;

import java.util.Map;

public class Main extends PApplet {      //extends PApplet消す    MainをCombatに変える

    //PApplet pApplet;
    //public Combat(PApplet pApplet){this.pApplet = pApplet;}

    //hibino.Sample mysample;//読み込む文言　　９２へ
    kotone.presentation.Presentation myimage;
    takano.Takano1 mysound;
    hibino.Load myload;
    hibino.Save mysave;

        public static String p_name = "プレイヤー名";    //文字列変数(プレイヤー名)                                     （クラス内で変数は定義）
        public static String m_name = "モンスターB";//モンスター名
        public static String item;
        public static String magic;

   // Table number;    //各設定数値の読み込み


        public static int p_hp ;    //数値変数(プレイヤー体力)            (メインで宣言)
        public static int p_hp_max ;                                   //(メインで宣言)
        public static int p_attack ;    //プレイヤー攻撃力　　　　　　　　　　　　　　(メインで宣言)
        public static int m_hp;    //モンスター体力
        public static int m_hp_max;
        public static int m_attack;    //モンスター攻撃力
        public static int total_exp ;    //合計の経験値　　　　　　　　　　　　　　　（メインで宣言）
        public static int m_exp;    //モンスターによる経験値
        public static int Lv ;    //プレイヤーのレベル（ここは初期化じゃない）     (メインで宣言)
        public static int keika  ;    //経過時間の初期化
        public static int press_time ;    //ボタン押下時間
        public static int m_money;    //
        public static int total_money ;                                    //(メインで宣言)
        public static int fire_damage ;                                  //(メインで宣言)
        public static int lightning_damage ;                            //(メインで宣言)
        public static int mp ;                                       //(メインで宣言)
        public static int y_count ;                                   //(メインで宣言）
        public static int bom_count ;                                 //メインで宣言)
        public static int p_random;
        public static int m_random;
        public static int e_random;
        public static int Lvup_p_attack;                                //(メインで宣言)

        public static boolean call_flg = false;
        public static boolean combat = false;
        public static boolean tap_a = false;    //真偽変数（初期化するためにfalseにする)
        public static boolean tap_b = false;
        public static boolean tap_e = false;
        public static boolean tap_f = false;
        public static boolean tap_l = false;
        public static boolean tap_m = false;
        public static boolean tap_i = false;
        public static boolean tap_y = false;
        public static boolean p_hit = false;
        public static boolean m_hit = false;
        public static boolean battle = false;
        public static boolean total_exp_flg = false;
        public static boolean level_flg = false;
        public static boolean mp_no = false;
        public static boolean item_no = false;
        public static boolean escape_random = false;
        //----------------------------------------------グラフィック、音響読み込み
        public static boolean start_event = false;    //バトルが始まったときに行う処理（BGMを流し続けるなど）
        public static boolean p_attack_event = false;    //プレイヤーが攻撃したとき
        public static boolean m_damage_event = false;    //通常のダメージのとき、会心のとき、爆弾のとき、ファイヤーのとき、ライトニングのとき、
        public static boolean m_attack_event = false;    //敵が攻撃したとき
        public static boolean p_damage_event = false;    //通常のダメージのとき、痛恨のとき
        public static boolean finish_event = false;    //プレイヤーが死んだとき、敵を倒したとき
        public static boolean Lvup_event = false;    //レべルアップしたとき
        public static boolean escape_event = false;    //逃げたとき、逃げれなかったとき
        public static boolean item_event = false;    //アイテムを使ったとき-----------(これいらないかも)
        public static boolean magic_event = false;    //魔法を使ったとき-----------(これいらないかも)
        public static boolean heal_event = false;    //回復したとき
        //-----------------------------------------------------



        @Override
        public void settings(){
            size(1280,750);
        }

        @Override
        public void setup(){
            random(1,6);

            //mysample = new Sample(this);
            myimage = new Presentation(this);
            mysound = new takano.Takano1( );
            myload = new Load(this);
            mysave = new Save(this);



            PFont font;    //日本語対応（以下３行）
            font=createFont("MS 明朝",30);
            textFont(font);
            //--------------------------------------------------------モンスター定義
            switch (m_name) {    //m_nameが～の時
                case "モンスターA":    //モンスターAの時
                    m_exp = 10;    //経験値
                    m_attack = 10;
                    m_hp = 10;
                    m_money =10;
                    m_hp_max = 10;
                    break;
                case "モンスターB":
                    m_exp = 20;
                    m_attack = 20;
                    m_hp = 20;
                    m_money = 20;
                    m_hp_max = 20;
                    break;
            }
            //--------------------------------------------------------------
            noStroke();    //pAppletを加える
            myload.main();
            myimage.setup();
        }

    @Override    //これを全部消す
    public void draw() {
        start_event = true;
        myimage.draw();
//--------------------------mysound.sound();

        //mysample.draw();                //まさき

        if( p_hp >= 20)
            stroke(0);    //枠線の色
        if(p_hp < 20)
            stroke(255,0,0);
        fill(255, 255, 255, 100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
        rect(100, 100, 220, 300);    //四角形（x座標、y座標、横の長さ、縦の長さ）
        strokeWeight(2);    //枠線の太さ



        line(100, 170, 320, 170);    //直線（左２つの座標と右２つの座標を結んだ線）

        rect(390, 480, 500, 250);                                             //ここはナレーションの四角

        rect(1000, 100, 200, 100);                                                //ここは敵の四角


        fill(0);    //～の色
        textSize(20);    //文字の大きさ
        text(p_name, 110, 130);     //文字、x座標、y座標　　　                      ここはプレイヤーの四角内
        text("/ Lv:" + Lv,260,130);
        text("HP : " + p_hp, 110, 160);
        text("/ MP : " + mp, 210, 160);
        text("＜ 攻撃 (A) ＞", 120, 200);
        text("＜ 逃げる (E) ＞", 120, 250);
        text("＜ アイテム (I) ＞",120,300);
        text("＜ 魔法 (M) ＞",120,350);

        text(m_name, 1010, 130);                                                   //ここは敵の四角内
        text("HP : " + m_hp, 1010, 170);

        keika = millis() - press_time;    //押されてからの経過時間

        text(m_name + "が現れた", 440, 530);                                              //ここからメインの流れ

        //----------------------------------------------------------------------アイテム足りないとき
        if((item_no) && (keika < 1000*3)) {
            text("アイテムが足りません", 440, 560);
            tap_b = false;
            tap_y = false;
            if (keika > 1000 * 2) {
                battle = false;
                tap_i = false;
                item_no = false;
            }
        }//-------------------------------------------------------------------------

        //----------------------------------------------------------------------mp足りないとき
        if((mp_no) && (keika < 1000*3)) {
            text("MPが足りません", 440, 560);
            tap_l = false;
            tap_f = false;
            if (keika > 1000 * 2) {
                battle = false;
                tap_m = false;
                mp_no = false;
            }
        }//-------------------------------------------------------------------------

        if (tap_a || tap_b || tap_y || tap_f || tap_l) {    //もしtap_aがtrueなら（Aが押されたら）       　 ＜ここからメイン＞
            //-----------------------------------------------------------------------------------アイテム使用時
            if (tap_b || tap_y) {
                if (keika < 1000 * 10) {//１０秒以内の時
                    text(p_name + "は" + item + "を使った", 440, 560);    //実行する

                   // if(!item_event){
                        item_event = true;
//------------------------                        myimage.draw();
//------------------------                        mysound.main();
                        //myplayer.draw();
                   // }

                }
                if ((1000 * 5 < keika) && (keika < 1000 * 10)) {    //５～１０秒の時
                    switch (item) {    //m_nameが～の時
                        case "爆弾":    //モンスターAの時
                            text("敵に20ダメージ", 440, 590);


                            m_damage_event = true;
//------------------------                            myimage.draw();
//------------------------                        mysound.main();

                            if (m_hit) {    //もしm_hitがtrueなら（一回実行するため）
                                m_hp = m_hp - 20;
                                if(m_hp < 0)
                                    m_hp = 0;
                                m_hit = false;    //終了
                            }
                            break;
                        case "薬草":
                            text("プレイヤーはHPを50回復した", 440, 590);

                           heal_event = true;
//------------------------                             myimage.draw();
//------------------------                        mysound.main();

                            if (m_hit) {
                                p_hp = p_hp + 50;
                                if (p_hp > p_hp_max)
                                    p_hp = p_hp_max;
                                m_hit = false;
                            }
                            break;
                    }
                }

            }//-----------------------------------------------------------------------------------

            //-----------------------------------------------------------------------------------------魔法


            if ((tap_f || tap_l) && (!mp_no)) {
                if (keika < 1000 * 10)//１０秒以内の時
                    text(p_name + "は" + magic + "を唱えた", 440, 560);    //実行する

                magic_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();

                if ((1000 * 5 < keika) && (keika < 1000 * 10)) {    //５～１０秒の時
                    switch (magic) {    //m_nameが～の時
                        case "ファイヤー":    //モンスターAの時
                            text("敵に" + fire_damage + "ダメージ", 440, 590);

                            m_damage_event = true;
//------------------------                            myimage.draw();
//------------------------                        mysound.main();

                            if (m_hit) {    //もしm_hitがtrueなら（一回実行するため）
                                m_hp = m_hp - fire_damage;    //体力ー１０
                                if(m_hp < 0)
                                    m_hp = 0;
                                m_hit = false;    //終了
                            }
                            break;
                        case "ライトニング":    //モンスターAの時
                            text("敵に" + lightning_damage + "ダメージ", 440, 590);

                            m_damage_event = true;
//------------------------                            myimage.draw();
//------------------------                        mysound.main();

                            if (m_hit) {    //もしm_hitがtrueなら（一回実行するため）
                                m_hp = m_hp - lightning_damage;    //体力ー１０
                                if(m_hp < 0)
                                    m_hp = 0;
                                m_hit = false;    //終了
                            }
                            break;
                    }
                }

            }//-----------------------------------------------------------------------------------------
            if (tap_a) {
                if (keika < 1000 * 10) {//１０秒以内の時a
                    text(p_name + "の攻撃", 440, 560);    //実行する

                    p_attack_event = true;
//------------------------                myimage.draw();
//---------------------                    mysound.sound();
                }




                if ((1000 * 5 < keika) && (keika < 1000 * 10)) {    //５～１０秒の時
                    if (p_random < 3) {
                        text("会心の一撃！敵に" + p_attack * 2 + "ダメージ", 440, 590);

                        m_damage_event = true;
//------------------------                        myimage.draw();
//------------------------                        mysound.main();

                    }
                    if (p_random >= 3) {
                        text("敵に" + p_attack + "ダメージ", 440, 590);
                        m_damage_event = true;
//------------------------                        myimage.draw();
//------------------------                        mysound.main();
                    if (keika > 1000*5.15)
                        m_damage_event = false;

                    }
                    if (m_hit) {    //もしm_hitがtrueなら（一回実行するため）
                        if (p_random < 3) {
                            m_hp = m_hp - p_attack;
                        }
                        m_hp = m_hp - p_attack;    //体力ー１０
                        if(m_hp < 0)
                            m_hp = 0;
                        m_hit = false;    //終了
                    }
                }
            }
            if ((1000 * 12 < keika) && (keika < 1000 * 20) && (m_hp != 0))    //１２～２０秒で敵体力が０じゃないとき                                                                    //ここから新しく
                text(m_name + "の攻撃", 440, 560);

                m_attack_event = true;
//------------------------            myimage.draw();
//------------------------                        mysound.main();

            if ((1000 * 15 < keika) && (keika < 1000 * 20) && (m_hp != 0)) {
                if (m_random < 3) {
                    text("痛恨の一撃！プレイヤーに" + m_attack * 2 + "ダメージ", 440, 590);

                    p_damage_event = true;
//------------------------                    myimage.draw();
//------------------------                        mysound.main();

                }
                if (m_random >= 3) {
                    text("プレイヤーに" + m_attack + "ダメージ", 440, 590);

                    p_damage_event = true;
//------------------------                    myimage.draw();
//------------------------                        mysound.main();

                }
                if (p_hit) {
                    if (m_random < 3) {
                        p_hp = p_hp - m_attack;    //体力－１０
                    }
                    p_hp = p_hp - m_attack;    //体力－１０
                    if(p_hp < 0)
                        p_hp = 0;
                    p_hit = false;    //終了
                }
            }


            if ((p_hp <= 0) && (keika < 1000 * 21)) {
                text(p_name + "は倒れた", 440, 620);

                finish_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();

                if (1000 * 20 < keika) {

                    mysave.main();
                    waigoma.Main.state = 2;
                    exit();
                }
            }

            if ((m_hp <= 0) && (keika > 1000*7) && (keika <1000*11)) {    //もしm_hpが０ならば

                finish_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();

                text("敵を倒した", 440, 620);    //実行する
                text("exp：" + m_exp,440,650);    //入手経験値
                text(m_money + "ゴールドを手に入れた",440,680);
                if(total_exp_flg) {     //total_expがtrueの時（一回実行）
                    total_exp = total_exp + m_exp;    //合計経験値
                    total_money = total_money + m_money;    //合計金額
                    total_exp_flg = false;    //終了
                }
                //-------------------------------------------------------- //レベルupの処理
                if((100<total_exp) && (total_exp<200) && (Lv == 1)) {
                    Lv = Lv + 1;
                    p_hp = 200;
                    p_hp_max = 200;
                    mp = 200;
                    Lvup_p_attack = 20;
                    fire_damage = 20;
                    lightning_damage = 30;
                    level_flg = true;
                }
                if((200<total_exp) && (total_exp<300) && (Lv == 2)) {
                    Lv = Lv + 1;
                    p_hp = 300;
                    p_hp_max = 300;
                    mp = 300;
                    Lvup_p_attack = 30;
                    fire_damage = 30;
                    lightning_damage = 40;
                    level_flg = true;
                }
                if((300<total_exp) && (total_exp<400) && (Lv == 3)) {
                    Lv = Lv + 1;
                    p_hp = 400;
                    p_hp_max = 400;
                    mp = 400;
                    Lvup_p_attack = 40;
                    fire_damage = 40;
                    lightning_damage = 50;
                    level_flg = true;
                }
                if((400<total_exp) && (total_exp<500) && (Lv == 4)) {
                    Lv = Lv + 1;
                    p_hp = 500;
                    p_hp_max = 500;
                    mp = 500;
                    Lvup_p_attack = 50;
                    fire_damage = 50;
                    lightning_damage = 60;
                    level_flg = true;
                }
                //----------------------------------------------------------------------------
                if(level_flg && (keika >1000*5)) {
                    text(p_name + "はレベルが" + Lv + "になった", 440, 710);

                    Lvup_event = true;
//------------------------                    myimage.draw();
//------------------------                        mysound.main();

                }

                if (keika > 1000 * 10) {   //経過が１０秒以上なら
                    mysave.main();
                    p_attack = Lvup_p_attack;
                    waigoma.Main.state = 2;
                    exit();    //処理終了
                }
            }
            if(keika > 1000*20) {
                battle = false;    //バトル終了
                tap_a = false;    //tap_a終了
                tap_b = false;
                tap_i = false;
                tap_y = false;
                tap_f = false;
                tap_l = false;
            }
        }                                                                                               //一連終了

        if (tap_e) {     //もしtap_eがtrueなら
            if((e_random < 3) && (keika < 1000*20)){
                if(keika < 1000*5) {
                    text("逃げ出せなかった", 440, 560);

                    escape_event = true;
//------------------------                    myimage.draw();
//------------------------                        mysound.main();

                }
                if ((1000 * 5 < keika) && (keika < 1000 * 15))    //１２～２０秒で敵体力が０じゃないとき                                                                    //ここから新しく
                    text(m_name + "の攻撃", 440, 560);

                    m_attack_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();

                if ((1000 * 10 < keika) && (keika < 1000 * 15)) {
                    if (m_random < 3) {
                        text("痛恨の一撃！プレイヤーに" + m_attack * 2 + "ダメージ", 440, 590);

                        p_damage_event = true;
//------------------------                        myimage.draw();
//------------------------                        mysound.main();

                    }
                    if (m_random >= 3) {
                        text("プレイヤーに" + m_attack + "ダメージ", 440, 590);

                        p_damage_event = true;
//------------------------                        myimage.draw();
//------------------------                        mysound.main();

                    }
                    if (p_hit) {    //もしp_hitがtrueなら（一回実行）
                        if (m_random < 3) {
                            p_hp = p_hp - m_attack;
                        }
                        p_hp = p_hp - m_attack;    //体力－１０
                        if(p_hp < 0)
                            p_hp = 0;
                        p_hit = false;    //終了
                    }
                }

                if ((p_hp <= 0) && (keika < 1000 * 16)) {
                    text(p_name + "は倒れた", 440, 620);

                    finish_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();

                    if (keika > 1000*15) {

                        mysave.main();
                        waigoma.Main.state = 2;
                        exit();
                    }
                }

                if(keika > 1000*15) {
                    tap_e = false;
                    battle = false;
                }
            }
            if(e_random >= 3) {
                text(p_name + "は逃げ出した", 440, 560);    //実行する

                escape_event = true;
//------------------------                myimage.draw();
//------------------------                        mysound.main();



                if(keika > 1000*4) {    //経過が２秒以上なら

                    mysave.main();
                    waigoma.Main.state = 2;
                    exit();    //処理終了
                }
            }
        }

        if(tap_i) {
            fill(255, 255, 255, 100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
            rect(320, 250, 200, 150);    //四角形（x座標、y座標、横の長さ、縦の長さ）
            stroke(0);    //枠線、（）内は色
            fill(0);
            text("＜ 爆弾 " + bom_count + "個 (B) ＞",320,300);
            text("＜ 薬草 " + y_count +  "個 (Y) ＞",320,350);

            if(tap_b) {
                item = "爆弾";
                tap_i = false;
            }

            if(tap_y){
                item = "薬草";
                tap_i = false;
            }
        }
        if(tap_m) {
            fill(255, 255, 255, 100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
            rect(320, 300, 250, 150);    //四角形（x座標、y座標、横の長さ、縦の長さ）
            stroke(0);    //枠線、（）内は色
            fill(0);
            text("＜ ファイヤー (F) ＞",320,350);
            text("＜ ライトニング (L) ＞",320,400);

            if(tap_f) {
                magic = "ファイヤー";
                tap_m = false;
            }

            if(tap_l){
                magic = "ライトニング";
                tap_m = false;
            }
        }
    }

        @Override
        public void keyPressed () {    //キーボード対応
            if ((key == 'A' || key == 'a') && (!tap_i) && (!tap_m) && (!battle)) {   //もしAが押されバトルじゃないとき
                tap_a = true;    //tap_aはtrue
                p_hit = true;
                m_hit = true;
                battle = true;    //バトル中
                total_exp_flg = true;
                p_random = (int) random(1,10);
                m_random = (int) random(1,10);
                press_time = millis();    //押された時間の取得

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }

            if ((key == 'E' || key == 'e') && (!tap_i) && (!tap_m) && (!battle)) {     //もしEが押されバトルじゃないとき
                tap_e = true;    //tap_eはtrue　　
                battle = true;    //バトル中
                p_hit = true;
                escape_random = true;
                e_random = (int) random(1,10);
                m_random = (int) random(1,10);
                press_time = millis();    //押された時間の取得

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }

            if ((key == 'I' || key == 'i') && (!tap_m) && (!battle)) {
                tap_i = true;
            }
            if ((key == 'Y' || key == 'y') && (!battle) && (tap_i)) {
                tap_y = true;
                battle = true;//バトル中
                p_hit = true;
                m_hit = true;
                total_exp_flg = true;
                m_random = (int) random(1,10);
                press_time = millis();    //押された時間の取得
                y_count = y_count - 1;
                if(y_count < 0){
                    item_no = true;
                    y_count = y_count + 1;
                }

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }
            if ((key == 'B' || key == 'b') && (tap_i) && (!battle)) {
                tap_b = true;
                battle = true;//バトル中
                p_hit = true;
                m_hit = true;
                total_exp_flg = true;
                m_random = (int) random(1,10);
                press_time = millis();
                bom_count = bom_count - 1;
                if(bom_count < 0){
                    item_no = true;
                    bom_count = bom_count + 1;
                }

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }

            if(key == BACKSPACE){
                tap_i = false;
                tap_m = false;
            }

            if ((key =='M' || key == 'm') && (!battle) && (!tap_i)){
                tap_m = true;
            }
            if ((key == 'F' || key == 'f') && (!battle) && (tap_m)) {
                tap_f = true;
                battle = true;//バトル中
                p_hit = true;
                m_hit = true;
                total_exp_flg = true;
                m_random = (int) random(1,10);
                press_time = millis();
                mp = mp - 10;
                if(mp < 0){
                    mp_no = true;
                    mp = mp + 10;
                }

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }
            if ((key == 'L' || key == 'l') && (!battle) && (tap_m)) {
                tap_l = true;
                battle = true;//バトル中
                p_hit = true;
                m_hit = true;
                total_exp_flg = true;
                m_random = (int) random(1,10);
                press_time = millis();
                mp = mp - 20;
                if(mp < 0){
                    mp_no = true;
                    mp = mp + 20;
                }

                p_attack_event = false;
                m_damage_event = false;
                m_attack_event = false;
                p_damage_event = false;
                finish_event = false;
                Lvup_event = false;
                escape_event = false;
                item_event = false;         //
                magic_event = false;
                heal_event = false;
            }
        }

        public static void main (String[]args){    //ここを消す
            PApplet.main("hibino.Main");
        }
    }