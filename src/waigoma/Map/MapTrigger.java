package waigoma.Map;

import nagai.Collision;

public class MapTrigger {
    public float x,y,width,height;
    int sizeWidth,sizeHeight;
    int count = 0;

    public MapTrigger(float x,float y,float width,float height,int sizeWidth,int sizeHeight){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sizeWidth = sizeWidth;  //size(width,height)はわかり次第いれてください
        this.sizeHeight = sizeHeight;  //そのとき引数から消す  相談
    }

    public void fixError(float fx, float fy){
        if (count == 0) {
            x = x - fx;
            y = y - fy;
            count++;
        }
    }

    public boolean mapTrigger(){
        if((Collision.Playerx < (x + width)) && ((Collision.Playerx + Collision.PlayerWidth) > x) && (Collision.Playery < (y + height)) && ((Collision.Playery + Collision.PlayerHeight) > y)){
            if(Collision.Playerx > x + width - 4){
                return true;
            }else if((Collision.Playerx + Collision.PlayerWidth) < x + 4){
                return true;
            }else if(Collision.Playery > y + (height/2)){
                return true;
            }else if((Collision.Playery + Collision.PlayerHeight) < y + (height/2)){
                return true;
            }
        }
        return false;
    }
}
