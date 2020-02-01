package waigoma.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class TSXLoader {
    public TSXLoader(String source) {//mapで用いる画像読み込み
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(source));
            Element element = doc.getDocumentElement();

            String name = element.getAttribute("name");//画像名入手
            String sTilewidth = element.getAttribute("tilewidth");//タイル画像の横幅
            String sTileheight = element.getAttribute("tileheight");//タイル画像の縦幅

            //cast to int
            int tileWidth = Integer.parseInt(sTilewidth);
            int tileHeight = Integer.parseInt(sTileheight);

            imageSplit("src/waigoma/data/img/mapChip/"+name+".png", tileWidth, tileHeight);

//            NodeList nodeList = element.getElementsByTagName("image");
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element1 = (Element) node;
//                    String sWidth = element1.getAttribute("width");
//                    String sHeight = element1.getAttribute("height");
//                    //cast to int
//                    int width = Integer.parseInt(sWidth);
//                    int height = Integer.parseInt(sHeight);
//                }
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void imageSplit(String filePath, int chunkWidth, int chunkHeight){
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedImage image = ImageIO.read(fis);

            int cols = image.getWidth() / chunkWidth; //横幅
            int rows = image.getHeight() / chunkHeight; //縦幅
            int chunks = cols * rows; //総数
            int count = 0;
            BufferedImage[] imgs = new BufferedImage[chunks];
            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    //Initialize the image array with image chunks
                    imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                    // draws the image chunk
//                    Graphics2D gr = imgs[count++].createGraphics();
//                    gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
//                    gr.dispose();
                }
            }
            System.out.println("Splitting done");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
