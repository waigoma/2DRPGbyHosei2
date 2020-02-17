package waigoma.Title.Option;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class OptionFile {
    String difficulty;
    Properties properties;

    public void loadOption(){
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("src/waigoma/data/Option/option.properties");
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            properties.load(isr);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        difficulty = properties.getProperty("difficulty");    //文字列
    }

    public String getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public void saveOption(){
        try {
            properties.setProperty("difficulty", difficulty);
            OutputStream ostream = new FileOutputStream("src/waigoma/data/Option/option.properties");
            OutputStreamWriter osw = new OutputStreamWriter(ostream, StandardCharsets.UTF_8);
            properties.store(osw, "Comments");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
