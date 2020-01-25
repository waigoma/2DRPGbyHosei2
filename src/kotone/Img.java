package kotone;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Img {
    public static void main(String[] args){
        String inputname = "heigen3.gif.bmp";
        String outputname = "P.png";
        try{
            BufferedImage bImage = ImageIO.read(new File(inputname));

            ImageIO.write(bImage, "png", new File(outputname));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
