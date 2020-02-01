package waigoma.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.nio.file.Paths;

public class TMXLoader {//map情報の読み込み
    String filePath;
    public static void main(String[] args){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// 1. DocumentBuilderFactoryのインスタンスを取得する
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();// 2. DocumentBuilderのインスタンスを取得する
            Document document = builder.parse(new File("src/waigoma/data/tmx/1village.tmx"));// 3. DocumentBuilderにXMLを読み込ませ、Documentを作る
            Element element = document.getDocumentElement();// 4. Documentから、ルート要素(1village.tmx)を取得する
            NodeList nodeList = element.getChildNodes();// 5. map配下にある、子要素を取得する

            String sWidth = element.getAttribute("width");//map横幅
            String sHeight = element.getAttribute("height");//map縦幅
            String sTilewidth = element.getAttribute("tilewidth");//mapタイル横幅
            String sTileheight = element.getAttribute("tileheight");//mapタイル縦幅

            int width = Integer.parseInt(sWidth);//cast to int
            int height = Integer.parseInt(sHeight);//cast to int
            int tileWidth = Integer.parseInt(sTilewidth);//cast to int
            int tileHeight = Integer.parseInt(sTileheight);//cast to int

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);//子要素i番目取得
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element name = (Element) node;//cast to element
                    System.out.println(name.getNodeName());
                    switch (name.getNodeName()) {
                        case "tileset":
                            String sFirstgid = name.getAttribute("firstgid");//タイルの初期値
                            String source = name.getAttribute("source");//タイル画像パス
                            //cast to int
                            int firstgid = Integer.parseInt(sFirstgid);
                            TSXLoader tsx = new TSXLoader(source);
                            break;
                        case "layer":
                            break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
