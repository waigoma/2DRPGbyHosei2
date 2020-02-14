package waigoma.Map;

import nagai.Collision;
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
//    private List<Integer[]> mapList = new ArrayList<>();//1つのマップのlayer情報をすべて保存
//    private List<BufferedImage> listBufImg = new ArrayList<>();//解析したBufferedImageを加える
//    private List<PImage> PImgList = new ArrayList<>();//BufferedImageをPImgListに変換
//    private List<Collision> colList = new ArrayList<>();
//    private PImage[] imgs;//PImageの配列
    public TSXLoader tsx;

    public TMXLoader(PApplet papplet){//TMX(マップデータ)ファイルを取得
        File dir = new File("src/waigoma/data/tmx");//マップデータのある場所
        File[] list = dir.listFiles();//Fileの配列にマップデータがある分ロード
        if (list != null){//ファイルが存在するかどうか確認、あれば↓
            for (File file : list){//マップデータを1つずつ読み込む
                String path = file.getPath();//ファイルのPathを取得
                String name = file.getName();//ファイルの名前を取得
                loadTmx(path, name, papplet);
            }
        }
    }
    private void loadTmx(String filePath, String mapName, PApplet plet){//TMXファイルを解析
        //きちんと毎回初期化しよう(教訓)
        List<Integer[]> mapList = new ArrayList<>();//1つのマップのlayer情報をすべて保存
        List<BufferedImage> listBufImg = new ArrayList<>();//解析したBufferedImageを加える
        List<PImage> PImgList = new ArrayList<>();//BufferedImageをPImgListに変換
        List<Collision> colList = new ArrayList<>();
        List<MapTrigger> nextList = new ArrayList<>();
        List<MapTrigger> backList = new ArrayList<>();
        PImage[] imgs;//PImageの配列
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

            int mapTileWidth = 0;
            int mapTileHeight = 0;
            int tileWidth = 0;
            int tileHeight = 0;
            //cast to int
            if (!(sWidth.isEmpty())) mapTileWidth = Integer.parseInt(sWidth);
            if (!(sHeight.isEmpty())) mapTileHeight = Integer.parseInt(sHeight);
            if (!(sTilewidth.isEmpty())) tileWidth = Integer.parseInt(sTilewidth);
            if (!(sTileheight.isEmpty())) tileHeight = Integer.parseInt(sTileheight);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);//子要素i番目取得
                if (node.getNodeType() == Node.ELEMENT_NODE) {//Nodeのタイプを選別
                    Element name = (Element) node;//cast to element
                    switch (name.getNodeName()) {//Nodeの名前で選別
                        case "tileset":
                            String sFirstgid = name.getAttribute("firstgid");//タイルの初期値
                            String source = name.getAttribute("source");//タイル画像パス
                            //cast to int
                            int firstgid = Integer.parseInt(sFirstgid);
                            tsx = new TSXLoader(source);//TSXLoaderクラスでsourceのTSXファイルを解析
                            listBufImg.addAll(tsx.listImg);//解析してsplitが完了したらlistBufImgに画像を加える
                            break;
                        case "layer"://layer内の処理
                            Node nd = name.getFirstChild();//layerノード内の最初のNodeを取得
                            List<Integer> list = new ArrayList<>();//配列にするための仮list
                            Integer[] ints;//int配列(MapTemplateのlistへ入れるため)

                            while (nd != null){//layerの中身がnullになるまで処理
                                if (nd.getNodeName().equals("data")){//Nodeがlayerの中のdataの場合

                                    String str = nd.getTextContent();//dataの中の文字列取得
                                    String[] nums = str.split(",");//","ごとに区切り、String配列に区切られた文字ごと入れる
                                    for (String num : nums){//nums配列の中身を1つ取り出し、Stringのnumにいれて下を実行(nums回)
                                        num = num.replaceAll("\\s+","");//改行やスペースを無に置き換え
                                        int n = Integer.parseInt(num);//cast to int
                                        list.add(n);//listにlayer情報(整数)を加える
                                    }
                                    ints = list.toArray(new Integer[0]);//加え終わったら配列に変換
                                    mapList.add(ints);//layer情報を保存
                                }
                                nd = nd.getNextSibling();//次のnodeを読み込む
                            }
                            break;
                        case "objectgroup":
                            String str = name.getAttribute("name");
                            if (str.contains("Collision")) {
                                Node nd1 = name.getFirstChild();//layerノード内の最初のNodeを取得
                                while (nd1 != null) {//objectの中身がnullになるまで処理
                                    if (nd1.getNodeName().equals("object")) {//Nodeがlayerの中のdataの場合
                                        Element el = (Element) nd1;
                                        String objXs = el.getAttribute("x");
                                        String objYs = el.getAttribute("y");
                                        String objWidths = el.getAttribute("width");
                                        String objHeights = el.getAttribute("height");

                                        float objX = 0;
                                        float objY = 0;
                                        float objWidth = 0;
                                        float objHeight = 0;

                                        if (!(objXs.isEmpty())) objX = Float.parseFloat(objXs);
                                        if (!(objYs.isEmpty())) objY = Float.parseFloat(objYs);
                                        if (!(objWidths.isEmpty())) objWidth = Float.parseFloat(objWidths);
                                        if (!(objHeights.isEmpty())) objHeight = Float.parseFloat(objHeights);

                                        colList.add(new Collision(objX, objY, objWidth, objHeight, (mapTileWidth * tileWidth) - 10, (mapTileHeight * tileHeight) - 10));
                                    }
                                    nd1 = nd1.getNextSibling();//次のnodeを読み込む
                                }
                            }
                            if (str.contains("Next")) {
                                Node nd1 = name.getFirstChild();//layerノード内の最初のNodeを取得
                                while (nd1 != null) {//objectの中身がnullになるまで処理
                                    if (nd1.getNodeName().equals("object")) {//Nodeがlayerの中のdataの場合
                                        Element el = (Element) nd1;
                                        String objXs = el.getAttribute("x");
                                        String objYs = el.getAttribute("y");
                                        String objWidths = el.getAttribute("width");
                                        String objHeights = el.getAttribute("height");

                                        float objX = 0;
                                        float objY = 0;
                                        float objWidth = 0;
                                        float objHeight = 0;

                                        if (!(objXs.isEmpty())) objX = Float.parseFloat(objXs);
                                        if (!(objYs.isEmpty())) objY = Float.parseFloat(objYs);
                                        if (!(objWidths.isEmpty())) objWidth = Float.parseFloat(objWidths);
                                        if (!(objHeights.isEmpty())) objHeight = Float.parseFloat(objHeights);

                                        nextList.add(new MapTrigger(objX, objY, objWidth, objHeight, (mapTileWidth * tileWidth) - 10, (mapTileHeight * tileHeight) - 10));
                                    }
                                    nd1 = nd1.getNextSibling();//次のnodeを読み込む
                                }
                            }
                            if (str.contains("Back")) {
                                Node nd1 = name.getFirstChild();//layerノード内の最初のNodeを取得
                                while (nd1 != null) {//objectの中身がnullになるまで処理
                                    if (nd1.getNodeName().equals("object")) {//Nodeがlayerの中のdataの場合
                                        Element el = (Element) nd1;
                                        String objXs = el.getAttribute("x");
                                        String objYs = el.getAttribute("y");
                                        String objWidths = el.getAttribute("width");
                                        String objHeights = el.getAttribute("height");

                                        float objX = 0;
                                        float objY = 0;
                                        float objWidth = 0;
                                        float objHeight = 0;

                                        if (!(objXs.isEmpty())) objX = Float.parseFloat(objXs);
                                        if (!(objYs.isEmpty())) objY = Float.parseFloat(objYs);
                                        if (!(objWidths.isEmpty())) objWidth = Float.parseFloat(objWidths);
                                        if (!(objHeights.isEmpty())) objHeight = Float.parseFloat(objHeights);

                                        backList.add(new MapTrigger(objX, objY, objWidth, objHeight, (mapTileWidth * tileWidth) - 10, (mapTileHeight * tileHeight) - 10));
                                    }
                                    nd1 = nd1.getNextSibling();//次のnodeを読み込む
                                }
                            }
                            break;
                    }
                }
            }
            for (BufferedImage bfi : listBufImg){//BufferedImageをPImageに変換
                PImgList.add(new PImage(bfi));
            }
            imgs = PImgList.toArray(new PImage[0]);//PImageのlistを配列に変換
            MapTemplate.maps.put(mapName, new MapTemplate(mapName, mapTileWidth, mapTileHeight, tileWidth, tileHeight, mapList, colList, nextList, backList, imgs, plet));//map情報を保存
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
