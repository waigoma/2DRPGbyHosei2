package hibino.data.p_data;
import hibino.Main;
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

public class Save {

    PApplet pApplet;//--------------------------------読み込む文言a
    public Save(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public static  void main() {
        Properties properties = new Properties();

        // プロパティファイルのパスを指定する
        String strpass = "src/hibino/data/p_data/p_java.properties";

        try {
            // 書き込み
//            properties.setProperty("id", "日比野");
//            properties.setProperty("pass", "エンジニア");
            properties.setProperty("p_name", "プレイヤー名");
            properties.setProperty("p_hp", java.lang.String.valueOf(Main.p_hp));
            properties.setProperty("p_hp_max", String.valueOf(Main.p_hp_max));
            properties.setProperty("p_attack", String.valueOf(Main.p_attack));
            properties.setProperty("total_exp", String.valueOf(Main.total_exp));
            properties.setProperty("Lv", String.valueOf(Main.Lv));
            properties.setProperty("total_money", String.valueOf(Main.total_money));
            properties.setProperty("fire_damage", String.valueOf(Main.fire_damage));
            properties.setProperty("lightning_damage", String.valueOf(Main.lightning_damage));
            properties.setProperty("mp", String.valueOf(Main.mp));
            properties.setProperty("y_count", String.valueOf(Main.y_count));
            properties.setProperty("bom_count", String.valueOf(Main.bom_count));
            properties.setProperty("Lvup_p_attack", String.valueOf(Main.Lvup_p_attack));


            OutputStream ostream = new FileOutputStream(strpass);
            OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            properties.store(osw, "Comments");


        } catch (IOException e) {
            e.printStackTrace();
        }




        // Mapに格納
        Map<String, String> propMap = new HashMap<>();
        for(Entry<Object, Object> e : properties.entrySet()) {
            propMap.put(e.getKey().toString(), e.getValue().toString());
        }

        System.out.println(propMap);
    }

}