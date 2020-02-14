package hibino;
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

public class Property {


    public static void main(String[] args) {
        Properties properties = new Properties();

        // プロパティファイルのパスを指定する
        String strpass = "E:\\Git\\2DRPGbyHosei2\\src\\hibino\\java.properties";

        try {
            // 書き込み
//            properties.setProperty("id", "日比野");
//            properties.setProperty("pass", "エンジニア");
            properties.setProperty("p_name", "日比野さん");
            properties.setProperty("m_name", "スライム");
            properties.setProperty("p_hp", java.lang.String.valueOf(Main.p_hp));
            properties.setProperty("m_damage", "10");

            OutputStream ostream = new FileOutputStream(strpass);
            OutputStreamWriter osw = new OutputStreamWriter(ostream, "UTF-8");
            properties.store(osw, "Comments");

            // 読み込み
            InputStream istream = new FileInputStream(strpass);
            InputStreamReader isr = new InputStreamReader(istream, "UTF-8");
            properties.load(isr);
            istream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        hibino.Main.m_name = properties.getProperty("p_name");


   /*     // Mapに格納
        Map<String, String> propMap = new HashMap<>();
        for(Entry<Object, Object> e : properties.entrySet()) {
            propMap.put(e.getKey().toString(), e.getValue().toString());
        }

        System.out.println(propMap); */
    }

}