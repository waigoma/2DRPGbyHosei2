package takano;

import hibino.Combat;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Takano1 extends Thread{

    String soundName;

    public Takano1(String soundName){
        this.soundName = soundName;
    }

    @Override
    public void run(){
        sound();
    }

    public  void sound() {
        String bgm1 = "src/takano/bgm/キラーズ・シルエット.wav";//ボス戦BGM
        String bgm2 = "src/takano/bgm/彩づく草原.wav";//村BGM
        String bgm3 = "src/takano/bgm/森のいざない.wav";//ダンジョンBGM
        String bgm4 = "src/takano/bgm/Battle_Thema.wav";//敵との闘いBGM
        String bgm5 = "src/takano/bgm/なんとか大作戦.wav";//エンディングBGM
        String bgm6 = "src/takano/bgm/8bit-act01_title.wav";//タイトル画面BGM

        String effect1 = "src/takano/bgm/斬撃音_1.wav";//攻撃当たる効果音
        String effect2 ="src/takano/bgm/始まりを告げる喇叭.wav";//敵に勝った時効果音
        String effect3 ="src/takano/bgm/システムSE_選択音1.wav";
        String effect4 ="src/takano/bgm/serif3.wav";//表示
        String effect5 ="src/takano/bgm/kettei-01.wav";//タイトル選択
        String effect6 ="src/takano/bgm/tousou-01.wav";//逃げる
        String effect7 ="src/takano/bgm/magic-electron2.wav";//雷攻撃
        String effect8 ="src/takano/bgm/magic-flame1.wav";//炎攻撃
        String effect9 ="src/takano/bgm/kaifuku.wav";//回復
        String effect10 ="src/takano/bgm/item-01.wav";//アイテム使用
        String effect11 ="src/takano/bgm/teki-syoumetsu.wav";//敵倒したとき
        String effect12 ="src/takano/bgm/miss.wav";//逃げられなかったとき
        String effect13 ="src/takano/bgm/skill.wav";//魔法唱える
        String effect14 ="src/takano/bgm/sentouhunou.wav";//戦闘不能
        String effect15 ="src/takano/bgm/game_explosion3_1.wav";//爆弾

//        if(hibino.Main.start_event) {
           Clip clip = creatClip(new File(soundName));
           clip.start();//読み込み
           clip.loop(Clip.LOOP_CONTINUOUSLY);//無限ループ
           try {
               Thread.sleep(1000 * 1000);//流れる時間
           }catch (InterruptedException e) {
           e.printStackTrace();
//           }
           clip.close();//読み込み終わり
       }
//        if(hibino.Main.p_attack_event) {
//               Clip clip = creatClip(new File(effect1));
//               clip.start();//読み込み
//               try {
//                    Thread.sleep(1000 * 10);//流れる時間
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               clip.close();//読み込み終わり
//
//        }
//
//        if(hibino.Main.magic_event) {
//        Clip clip = creatClip(new File(effect13));
//               clip.start();//読み込み
//               try {
//                    Thread.sleep(1000 * 10);//流れる時間
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               clip.close();//読み込み終わり
//        }
//        if((hibino.Main.m_damage_event) && (hibino.Main.tap_f)){
//         Clip clip = creatClip(new File(effect8));
//               clip.start();//読み込み
//               try {
//                    Thread.sleep(1000 * 10);//流れる時間
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//               clip.close();//読み込み終わり
//        }
//        if((hibino.Main.m_damage_event) && (hibino.Main.tap_l)){
//            Clip clip = creatClip(new File(effect7));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//
//        if(hibino.Main.m_attack_event) {
//            Clip clip = creatClip(new File(effect1));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//        if(hibino.Main.escape_event) {
//            Clip clip = creatClip(new File(effect6));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//        if((hibino.Main.finish_event) && (Main.m_hp <= 0)){
//            Clip clip = creatClip(new File(effect11));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//        if((hibino.Main.item_event) && (hibino.Main.tap_b)) {
//            Clip clip = creatClip(new File(effect15));//爆弾
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//
//        if((hibino.Main.item_event) && (hibino.Main.tap_y)) {
//            Clip clip = creatClip(new File(effect9));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }
//
//        if((hibino.Main.finish_event) && (Main.p_hp <= 0)) {
//            Clip clip = creatClip(new File(effect14));
//            clip.start();//読み込み
//            try {
//                Thread.sleep(1000 * 10);//流れる時間
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clip.close();//読み込み終わり
//        }


    }



    public static Clip creatClip(File path) {           //バグが起きたときの対処
        try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){

            AudioFormat af = ais.getFormat();

            DataLine.Info dataLine = new DataLine.Info(Clip.class,af);

            Clip c = (Clip)AudioSystem.getLine(dataLine);

            c.open(ais);

            return c;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void main() {
    }
}
