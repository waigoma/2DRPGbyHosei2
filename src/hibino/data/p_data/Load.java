package hibino.data.p_data;

import hibino.Main;
import processing.core.PApplet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class Load {

    PApplet pApplet;//--------------------------------読み込む文言
    public Load(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public static void main() {
        Properties properties = new Properties();

        // プロパティファイルのパスを指定する
        String strpass = "src/hibino/data/p_data/p_java.properties";

        try {


            // 読み込みa
            InputStream istream = new FileInputStream(strpass);
            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.p_name = properties.getProperty("p_name");    //文字列
        (Main.p_hp) = parseInt(properties.getProperty("p_hp"));   //数値
        (Main.p_hp_max) = parseInt(properties.getProperty("p_hp_max"));
        (Main.p_attack) = parseInt(properties.getProperty("p_attack"));
        (Main.total_exp) = parseInt(properties.getProperty("total_exp"));
        (Main.Lv) = parseInt(properties.getProperty("Lv"));
        (Main.total_money) = parseInt(properties.getProperty("total_money"));
        (Main.fire_damage) = parseInt(properties.getProperty("fire_damage"));
        (Main.lightning_damage) = parseInt(properties.getProperty("lightning_damage"));
        (Main.mp) = parseInt(properties.getProperty("mp"));
        (Main.y_count) = parseInt(properties.getProperty("y_count"));
        (Main.bom_count) = parseInt(properties.getProperty("bom_count"));
     //   (Main.Lvup_p_attack) = Integer.parseInt(properties.getProperty("Lvup_p_attack"));


    }

}