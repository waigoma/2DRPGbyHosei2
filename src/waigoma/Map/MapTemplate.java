package waigoma.Map;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MapTemplate {
    public static List<Integer[]> list = new ArrayList<>();
    public static List<BufferedImage> listImg = new ArrayList<>();

    private List<Integer[]> lt = new ArrayList<>();

    private String mapName;
    private int mapTileWidth, MapTileHeight, tileWidth, tileHeight;
    public MapTemplate() {

    }
}
