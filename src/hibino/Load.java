package hibino;
import processing.core.PApplet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Load  {

    PApplet pApplet;//--------------------------------読み込む文言
    public Load(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public static void main() {
        Properties properties = new Properties();

        // プロパティファイルのパスを指定する
        String strpass = "E:\\Git\\2DRPGbyHosei2\\src\\hibino\\java.properties";

        try {


            // 読み込み
            InputStream istream = new FileInputStream(strpass);
            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hibino.Main.m_name = properties.getProperty("p_name");    //文字列
        (hibino.Main.p_hp) = Integer.parseInt(properties.getProperty("p_hp"));   //数値
        (hibino.Main.p_hp_max) = Integer.parseInt(properties.getProperty("p_hp_max"));
        (hibino.Main.p_attack) = Integer.parseInt(properties.getProperty("p_attack"));
        (hibino.Main.total_exp) = Integer.parseInt(properties.getProperty("total_exp"));
        (hibino.Main.Lv) = Integer.parseInt(properties.getProperty("Lv"));
        (Main.total_money) = Integer.parseInt(properties.getProperty("total_money"));
        (Main.fire_damage) = Integer.parseInt(properties.getProperty("fire_damage"));
        (Main.lightning_damage) = Integer.parseInt(properties.getProperty("lightning_damage"));
        (hibino.Main.mp) = Integer.parseInt(properties.getProperty("mp"));
        (Main.y_count) = Integer.parseInt(properties.getProperty("y_count"));
        (Main.bom_count) = Integer.parseInt(properties.getProperty("bom_count"));
        (Main.Lvup_p_attack) = Integer.parseInt(properties.getProperty("Lvup_p_attack"));


    }

}