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

public class TMXLoader {
    String filePath;
    public static void main(String[] args){
        // 1. DocumentBuilderFactoryのインスタンスを取得する
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // 2. DocumentBuilderのインスタンスを取得する
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 3. DocumentBuilderにXMLを読み込ませ、Documentを作る
            Document document = builder.parse(new File("src/waigoma/data/tmx/1village.tmx"));
            // 4. Documentから、ルート要素(1village.tmx)を取得する
            Element element = document.getDocumentElement();
            // 5. map配下にある、子要素を取得する
            NodeList nodeList = element.getChildNodes();

            System.out.println(element.getAttribute("width"));

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element name = (Element) node;
                    switch (name.getNodeName()) {
                        case "tileset":
                            System.out.println(name.getNodeName() + ":" + name.getAttribute("source"));
                            break;
                        case "":
                            break;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
