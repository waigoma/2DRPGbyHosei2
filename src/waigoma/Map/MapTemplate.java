package waigoma.Map;

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.HashMap;
import java.util.List;

public class MapTemplate {
    public static HashMap<String, MapTemplate> maps = new HashMap<>();

    private List<BufferedImage> listImg;
    private List<Integer[]> list;
    private String mapName;
    private int mapTileWidth, mapTileHeight, tileWidth, tileHeight;
    private PApplet plet;
    private PImage img;
    private WritableRaster wr;

    public MapTemplate(String name, int mapTileWidth, int mapTileHeight, int tileWidth, int tileHeight, List<Integer[]> list, List<BufferedImage> listImg, PApplet plet) {
        this.mapName = name;
        this.mapTileWidth = mapTileWidth;
        this.mapTileHeight = mapTileHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.list = list;
        this.listImg = listImg;
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
    public List<BufferedImage> getListImg() {
        return listImg;
    }

    public void display(){
        int count = 0;
        for (Integer[] mapNums : getList()) {
            int x = 0;
            int y = 0;
            count++;
            if (count != getList().size()) {
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

    public void topDisplay(){
        int count = 0;
        for (Integer[] mapNums : getList()) {
            int x = 0;
            int y = 0;
            count++;
            if (count == getList().size()) {
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

    public void displayImages(int index, int x, int y){
        float imgX = x * getTileWidth();
        float imgY = y * getTileHeight();
        List<BufferedImage> bufImgList = getListImg();
        if (index == 0){
            img = new PImage();
        }else {
            BufferedImage bufImg = bufImgList.get(index - 1);
            img = new PImage(bufImg);
        }
//        if (img == null){
//            img = new PImage(bufImg);
//            DataBufferInt dbi = new DataBufferInt(img.pixels, img.pixels.length);
//            wr = Raster.createWritableRaster(bufImg.getSampleModel(), dbi, new Point(0,0));
//        } else {
//            bufImg.copyData(wr);
//            img.updatePixels();
//        }
        plet.image(img, imgX, imgY);
    }
}
