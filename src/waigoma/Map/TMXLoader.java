package waigoma.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import processing.core.PApplet;
import processing.core.PImage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TMXLoader {//map情報の読み込み
    private List<Integer[]> mapList = new ArrayList<>();
    private List<BufferedImage> listBufImg = new ArrayList<>();
    private List<PImage> PImgList = new ArrayList<>();
    private PImage[] imgs;
    public TSXLoader tsx;

    public TMXLoader(PApplet plet){
        File dir = new File("src/waigoma/data/tmx");
        File[] list = dir.listFiles();
        if (list != null){
            for (File file : list){
                String path = file.getPath();
                String name = file.getName();
                loadTmx(path, name, plet);
            }
        }
    }
    public void loadTmx(String filePath, String mapName, PApplet plet){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// 1. DocumentBuilderFactoryのインスタンスを取得する
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();// 2. DocumentBuilderのインスタンスを取得する
            Document document = builder.parse(new File(filePath));// 3. DocumentBuilderにXMLを読み込ませ、Documentを作る
            Element element = document.getDocumentElement();// 4. Documentから、ルート要素(1village.tmx)を取得する
            NodeList nodeList = element.getChildNodes();// 5. map配下にある、子要素を取得する

            String sWidth = element.getAttribute("width");//map横幅
            String sHeight = element.getAttribute("height");//map縦幅
            String sTilewidth = element.getAttribute("tilewidth");//mapタイル横幅
            String sTileheight = element.getAttribute("tileheight");//mapタイル縦幅

            int mapTileWidth = Integer.parseInt(sWidth);//cast to int
            int mapTileHeight = Integer.parseInt(sHeight);//cast to int
            int tileWidth = Integer.parseInt(sTilewidth);//cast to int
            int tileHeight = Integer.parseInt(sTileheight);//cast to int

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);//子要素i番目取得
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element name = (Element) node;//cast to element
                    switch (name.getNodeName()) {
                        case "tileset":
                            String sFirstgid = name.getAttribute("firstgid");//タイルの初期値
                            String source = name.getAttribute("source");//タイル画像パス
                            //cast to int
                            int firstgid = Integer.parseInt(sFirstgid);
                            tsx = new TSXLoader(source);
                            listBufImg.addAll(tsx.listImg);
                            break;
                        case "layer"://layer内の処理
                            Node nd = name.getFirstChild();
                            List<Integer> list = new ArrayList<>();//配列にするための仮list
                            Integer[] ints;//int配列(MapTemplateのlistへ入れるため)

                            while (nd != null){//layerの中身がnullになるまで処理
                                if (nd.getNodeName().equals("data")){//Nodeがlayerの中のdataの場合

                                    String str = nd.getTextContent();//dataの中の文字列取得
                                    String[] nums = str.split(",");//","ごとに区切り、String配列に区切られた文字ごと入れる
                                    for (String num : nums){//nums配列の中身を1つ取り出し、Stringのnumにいれて下を実行(nums回)
                                        num = num.replaceAll("\\s+","");//改行やスペースを無に置き換え
                                        int n = Integer.parseInt(num);//cast to int
                                        list.add(n);
                                    }
                                    ints = list.toArray(new Integer[0]);
                                    mapList.add(ints);
                                }
                                nd = nd.getNextSibling();
                            }
                            break;
                    }
                }
            }
            for (BufferedImage bfi : listBufImg){
                PImgList.add(new PImage(bfi));
            }
            imgs = PImgList.toArray(new PImage[0]);
            MapTemplate.maps.put(mapName, new MapTemplate(mapName, mapTileWidth, mapTileHeight, tileWidth, tileHeight, mapList, imgs, plet));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
