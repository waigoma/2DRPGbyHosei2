package waigoma.Map;

import nagai.Collision;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.HashMap;
import java.util.List;

public class MapTemplate {
    public static HashMap<String, MapTemplate> maps = new HashMap<>();//マップデータをHashMapで保存

    private PImage[] imgs;//mapChipが入った配列
    private List<Integer[]> list;//mapのlayerが入った配列
    private String mapName;//mapの名前
    private int mapTileWidth, mapTileHeight, tileWidth, tileHeight;//map作るのに必要な基本情報
    private List<Collision> colList;
    private PApplet plet;
    private PImage img;

    public MapTemplate(String name, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight, List<Integer[]> list, List<Collision> colList, PImage[] imgs, PApplet plet) {//マップデータ保存
        this.mapName = name;
        this.mapTileWidth = mapTileWidth;
        this.mapTileHeight = mapTileHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.list = list;
        this.colList = colList;
        this.imgs = imgs;
        this.plet = plet;
    }
    public String getMapName(){
        return mapName;
    }
    public int getMapTileWidth() {
        return mapTileWidth;
    }
    public int getMapTileHeight() {
        return mapTileHeight;
    }
    public int getTileWidth() {
        return tileWidth;
    }
    public int getTileHeight() {
        return tileHeight;
    }
    public List<Integer[]> getList() {
        return list;
    }
    public List<Collision> getColList() {
        return colList;
    }
    public PImage[] getPImg() {
        return imgs;
    }

    public void display(){//マップの一番手前に出てこないところの描写
        int count = 0;//layerカウント
        for (Collision col : getColList()){
            col.ObjectCollision();
            col.Outside();
        }
        for (Integer[] mapNums : getList()) {//Listからlayerの情報を引き出す(下のlayerから順に)
            int x = 0;//x座標(何個目か)
            int y = 0;//y座標(↑)
            count++;
            if (count != getList().size()) {//一番上のlayer以外なら
                for (int num : mapNums) {//layer情報を1つずつ取り出す
                    displayImages(num, x, y);
                    if (x < getMapTileWidth()) {//横幅が所定タイル数までなら
                        x++;//x座標を+1
                    }
                    if (x >= getMapTileWidth()) {//横幅が所定タイル数を超えたら
                        x = 0;//x座標リセット
                        y++;//y座標+1
                    }
                }
            }
        }
    }

    public void topDisplay(){//マップの1番手前に来るlayerの描写
        int count = 0;
        for (Integer[] mapNums : getList()) {
            int x = 0;
            int y = 0;
            count++;
            if (count == getList().size()) {//一番上のlayerなら
                for (int num : mapNums) {
                    displayImages(num, x, y);
                    if (x < getMapTileWidth()) {
                        x++;
                    }
                    if (x >= getMapTileWidth()) {
                        x = 0;
                        y++;
                    }
                }
            }
        }
    }

    public void displayImages(int index, int x, int y){//数字の情報から写真を描写する
        float imgX = x * getTileWidth();//x座標
        float imgY = y * getTileHeight();//y座標
        PImage[] PImgs = getPImg();//PImageの配列をget
        if (index == 0){//もし何もない場所だったら(layer内画像なし)
            return;//処理終了
        }else {//画像あり
            img = PImgs[index - 1];//配列は0からスタートでlayer情報は1からスタートなので-1
        }
        plet.image(img, imgX, imgY);//実際に画像を描写
    }
}
