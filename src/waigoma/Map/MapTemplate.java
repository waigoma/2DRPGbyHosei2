package waigoma.Map;

import nagai.Collision;
import processing.core.PApplet;
import processing.core.PImage;
import waigoma.Main;
import waigoma.StateType;

import java.util.LinkedHashMap;
import java.util.List;

public class MapTemplate {
    public static LinkedHashMap<String, MapTemplate> maps = new LinkedHashMap<>();//マップデータをHashMapで保存

    private PImage[] imgs;//mapChipが入った配列
    private List<Integer[]> list;//mapのlayerが入った配列
    private String mapName, nextMap, previousMap;//mapの名前
    private int mapTileWidth, mapTileHeight, tileWidth, tileHeight, nextX, nextY, previousX, previousY;//map作るのに必要な基本情報
    private List<Collision> colList;
    private List<MapTrigger> nextList, backList;
    private List<Interact> interactList;
    private PApplet plet;
    private PImage img;

    public MapTemplate(String name, String nextMap, String previousMap, int nextX, int nextY, int previousX, int previousY, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight, List<Integer[]> list, List<Collision> colList, List<MapTrigger> nextList, List<MapTrigger> backList, List<Interact> interactList, PImage[] imgs, PApplet plet) {//マップデータ保存
        this.mapName = name;
        this.nextMap = nextMap;
        this.previousMap = previousMap;
        this.nextX = nextX;
        this.nextY = nextY;
        this.previousX = previousX;
        this.previousY = previousY;
        this.mapTileWidth = mapTileWidth;
        this.mapTileHeight = mapTileHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.list = list;
        this.colList = colList;
        this.nextList = nextList;
        this.backList = backList;
        this.interactList = interactList;
        this.imgs = imgs;
        this.plet = plet;
    }
    public String getMapName(){
        return mapName;
    }
    public String getNextMap() {
        return nextMap;
    }
    public String getPreviousMap() {
        return previousMap;
    }
    public int getNextX() {
        return nextX;
    }
    public int getNextY() {
        return nextY;
    }
    public int getPreviousX() {
        return previousX;
    }
    public int getPreviousY() {
        return previousY;
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
    public List<MapTrigger> getNextList(){
        return nextList;
    }
    public List<MapTrigger> getBackList() {
        return backList;
    }
    public List<Interact> getInteractList() {
        return interactList;
    }
    public PImage[] getPImg() {
        return imgs;
    }

    public void display(){//マップの一番手前に出てこないところの描写
        int count = 0;//layerカウント
        for (Collision col : getColList()){
            if (Main.state == StateType.LOCAL_STATE) col.fixError(-6, -3);
            if (Main.state == StateType.WORLD_STATE) col.fixError(4, 4);
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

    public void event(){
        for (Interact interact : getInteractList()){
            if (Main.state == StateType.LOCAL_STATE) interact.fixError(-6, -3);
            if (Main.state == StateType.WORLD_STATE) interact.fixError(4, 4);
            if (interact.trigger()){
                interact.event();
            }
        }
    }

    public boolean isNext(){
        for (MapTrigger nmt : getNextList()){
            if (Main.state == StateType.LOCAL_STATE) nmt.fixError(-6, -3);
            if (Main.state == StateType.WORLD_STATE) nmt.fixError(4, 4);
            if(nmt.mapTrigger()) return true;
        }
        return false;
    }

    public boolean isBack(){
        for (MapTrigger bmt : getBackList()){
            if (Main.state == StateType.LOCAL_STATE) bmt.fixError(-6, -3);
            if (Main.state == StateType.WORLD_STATE) bmt.fixError(4, 4);
            if (bmt.mapTrigger()) return true;
        }
        return false;
    }
}
