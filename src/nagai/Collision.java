package nagai;

public class Collision {
    float x,y,width,height;
    int sizeWidth,sizeHeight;
    public static float Playerx,Playery;
    public static int PlayerWidth,PlayerHeight;
    int count = 0;

    public Collision(float x,float y,float width,float height,int sizeWidth,int sizeHeight){
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

    public void Outside(){
        if(Playery>(sizeHeight-PlayerHeight)){     //PlayerHeightはPlayerの大きさがわかり次第いれてください「定数」
            Playery = sizeHeight-PlayerHeight;
        }
        if(Playery<0) {
            Playery=0;
        }
        if(Playerx<0){
            Playerx=0;
        }
        if(Playerx>(sizeWidth-PlayerWidth)){      //上と同様
            Playerx=sizeWidth-PlayerWidth;
        }
    }
    public void ObjectCollision(){
        if((Playerx < (x + width)) && ((Playerx + PlayerWidth) > x) && (Playery < (y + height)) && ((Playery + PlayerHeight) > y)){
            if(Playerx > x + width - 4){
                Playerx = x + width;
            }else if((Playerx + PlayerWidth) < x + 4){
                Playerx = x - PlayerWidth;
            }else if(Playery > y + (height/2)){
                Playery = y + height;
            }else if((Playery + PlayerHeight) < y + (height/2)){
                Playery = y - PlayerHeight;
            }
        }
    }
}
