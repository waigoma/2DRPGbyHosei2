package hibino.data.m_data;

import hibino.Main;
import processing.core.PApplet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Load {

    PApplet pApplet;//--------------------------------読み込む文言
    public Load(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public static void main() {
        Properties properties = new Properties();

        // プロパティファイルのパスを指定する
        String strpass = "src/hibino/data/m_data/m_java.properties";


        try {


            // 読み込み
            InputStream istream = new FileInputStream(strpass);

            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(hibino.Main.m_name) {
            case "モンスターA":
                //Main.m_name = properties.getProperty("m_name");    //文字列
                (hibino.Main.m_hp) = Integer.parseInt(properties.getProperty("a_m_hp"));   //数値a
                (Main.m_hp_max) = Integer.parseInt(properties.getProperty("a_m_hp_max"));
                (Main.m_attack) = Integer.parseInt(properties.getProperty("a_m_attack"));
                (Main.m_exp) = Integer.parseInt(properties.getProperty("a_m_exp"));
                (Main.m_money) = Integer.parseInt(properties.getProperty("a_m_money"));
                break;
            case "モンスターB":
                //Main.m_name = properties.getProperty("b_m_name");    //文字列
                (Main.m_hp) = Integer.parseInt(properties.getProperty("b_m_hp"));   //数値
                (Main.m_hp_max) = Integer.parseInt(properties.getProperty("b_m_hp_max"));
                (Main.m_attack) = Integer.parseInt(properties.getProperty("b_m_attack"));
                (Main.m_exp) = Integer.parseInt(properties.getProperty("b_m_exp"));
                (Main.m_money) = Integer.parseInt(properties.getProperty("b_m_money"));
                break;
            case "モンスターC":
                //Main.m_name = properties.getProperty("c_m_name");    //文字列
                (Main.m_hp) = Integer.parseInt(properties.getProperty("c_m_hp"));   //数値
                (Main.m_hp_max) = Integer.parseInt(properties.getProperty("c_m_hp_max"));
                (Main.m_attack) = Integer.parseInt(properties.getProperty("c_m_attack"));
                (Main.m_exp) = Integer.parseInt(properties.getProperty("c_m_exp"));
                (Main.m_money) = Integer.parseInt(properties.getProperty("c_m_money"));
                break;
        }

    }

}