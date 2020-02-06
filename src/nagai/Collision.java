package nagai;

public class Collision {
    float x,y,width,height;
    int sizeWidth,sizeHeight;
    float Playerx,Playery;

    public Collision(float x,float y,float width,float height,int sizeWidth,int sizeHeight,float Playerx,float Playery){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sizeWidth = sizeWidth;  //size(width,height)はわかり次第いれてください
        this.sizeHeight = sizeHeight;  //そのとき引数から消す  相談
        this.Playerx = Playerx;
        this.Playery = Playery;
    }
    public void Outside(){
        if(Playery>(sizeHeight-20)){     //PlayerHeightはPlayerの大きさがわかり次第いれてください「定数」
            Playery = sizeHeight-20;
        }
        if(Playery<0) {
            Playery=0;
        }
        if(Playerx<0){
            Playerx=0;
        }
        if(Playerx>(sizeWidth-20)){      //上と同様
            Playerx=sizeWidth-20;
        }
    }
    public void ObjectCollision(){

    }
}
