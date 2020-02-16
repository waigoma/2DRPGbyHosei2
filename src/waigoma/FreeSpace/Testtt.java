package waigoma.FreeSpace;

import gifAnimation.Gif;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Testtt extends PApplet {

    int price = 100;//このクラスにpriceというint型の変数を作る
    int count = 0;
    Gif gif;
    List<String> list = new ArrayList<>();
    String str;
    boolean stop = false;

    @Override
    public void settings(){
        size(1280, 720);
    }

    @Override
    public void setup(){
//        noStroke();
//        int price = 0;//ここのメソッドにpriceというint型の変数を作る
//        println("setupメソッド");
//        println("setup()のprice: "+price);//これだとこのメソッド内のpriceが使われる。
//        //このクラスのpriceを使うにはどうすればいいのか
//        println("このクラス内のprice: "+this.price);//こうするとthis.(このクラスの)priceを使います。ということになる。
//        //thisを使うメリットは、メソッド内に作った変数はそのメソッド内でしか使えないが
//        //クラスに作った変数はどこのメソッドからでもアクセスできる。
        gif = new Gif(this, "src/kotone/deta/lightning2.gif");
        gif.play();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");
    }

    @Override
    public void draw(){
//        if (count == 0) {
//            background(255);
//            fill(128);
//            rect(100,100,100,100);
//            fill(0);
//            rect(100.999f, 100.999f, 50, 50);
//            println("drawメソッド");
//            println("このクラスのprice: "+this.price);//ここでもクラスの変数なら使える
//            println("このクラスのprice: "+price);//このメソッド内にはpriceという変数は存在しなので自動的にクラスの変数が呼ばれている
//            count++;
//        }
        background(255);
        image(gif,0,0);
        fill(0);
        if (count > list.size() - 1){
            count = 0;
            stop = true;
        }
        if (!stop) {
            if (str != null) {
                str = str + list.get(count);
            } else {
                str = list.get(count);
            }
        }
        text(str, width / 2f, height / 2f);
        delay(100);
        count++;
    }

    public static void main(String[] args){
        PApplet.main("waigoma.FreeSpace.Testtt");
    }
}
