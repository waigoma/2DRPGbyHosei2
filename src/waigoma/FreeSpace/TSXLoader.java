package waigoma.FreeSpace;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TSXLoader {
    public static List<BufferedImage> listImg = new ArrayList<>();//splitした画像を一時的に保存しておく場所

    public static void main(String[] args){
        imageSplit("src/issei/data/img/character/mobu1.png", 32, 32);
    }

//    public static void TsxLoader(String source) {//mapで用いる画像読み込み
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//loadTmxと同様
//        try {
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(new File(source));
//            Element element = doc.getDocumentElement();
//
//            String name = element.getAttribute("name");//画像名入手
//            String sTileWidth = element.getAttribute("tilewidth");//タイル画像の横幅
//            String sTileHeight = element.getAttribute("tileheight");//タイル画像の縦幅
//
//            //cast to int
//            int tileWidth = Integer.parseInt(sTileWidth);
//            int tileHeight = Integer.parseInt(sTileHeight);
//
//            imageSplit("src/waigoma/data/img/mapChip/"+name+".png", tileWidth, tileHeight);
//
////            NodeList nodeList = element.getElementsByTagName("image");
////            for (int i = 0; i < nodeList.getLength(); i++) {
////                Node node = nodeList.item(i);
////                if (node.getNodeType() == Node.ELEMENT_NODE) {
////                    Element element1 = (Element) node;
////                    String sWidth = element1.getAttribute("width");
////                    String sHeight = element1.getAttribute("height");
////                    //cast to int
////                    int width = Integer.parseInt(sWidth);
////                    int height = Integer.parseInt(sHeight);
////                }
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static void imageSplit(String filePath, int chunkWidth, int chunkHeight){//画像を指定px*pxで小分けする
        try {
            File file = new File(filePath);//filePathのファイルを認識(Fileクラスとしておく)
            FileInputStream fis = new FileInputStream(file);//↑ファイル読み込み
            BufferedImage image = ImageIO.read(fis);//↑ファイルをBufferedImageとして読み込み

            int cols = image.getWidth() / chunkWidth; //横幅
            int rows = image.getHeight() / chunkHeight; //縦幅
            int chunks = cols * rows; //総数
            int count = 0;
            int a = 0;
            BufferedImage[] imgs = new BufferedImage[chunks];
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    //Initialize the image array with image chunks
                    imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                    // draws the image chunk//TODO あまり理解できていない部分
                    Graphics2D gr = imgs[count++].createGraphics();
                    gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                    gr.dispose();
                    listImg.add(imgs[a]);
                    a++;
                }
            }
            System.out.println("Splitting done");
            for (int i = 0; i < listImg.size(); i++) {
                ImageIO.write(listImg.get(i), "png", new File("C:\\Users\\waiwa\\Desktop\\test\\" + i + ".png"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
