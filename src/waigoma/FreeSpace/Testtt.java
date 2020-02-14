package waigoma.FreeSpace;

import processing.core.PApplet;

public class Testtt extends PApplet {

    int price = 100;//このクラスにpriceというint型の変数を作る
    int count = 0;

    @Override
    public void settings(){
        size(1280, 720);
    }

    @Override
    public void setup(){
        noStroke();
        int price = 0;//ここのメソッドにpriceというint型の変数を作る
        println("setupメソッド");
        println("setup()のprice: "+price);//これだとこのメソッド内のpriceが使われる。
        //このクラスのpriceを使うにはどうすればいいのか
        println("このクラス内のprice: "+this.price);//こうするとthis.(このクラスの)priceを使います。ということになる。
        //thisを使うメリットは、メソッド内に作った変数はそのメソッド内でしか使えないが
        //クラスに作った変数はどこのメソッドからでもアクセスできる。
    }

    @Override
    public void draw(){
        if (count == 0) {
            background(255);
            fill(128);
            rect(100,100,100,100);
            fill(0);
            rect(100.999f, 100.999f, 50, 50);
            println("drawメソッド");
            println("このクラスのprice: "+this.price);//ここでもクラスの変数なら使える
            println("このクラスのprice: "+price);//このメソッド内にはpriceという変数は存在しなので自動的にクラスの変数が呼ばれている
            count++;
        }
    }

    public static void main(String[] args){
        PApplet.main("waigoma.FreeSpace.Testtt");
    }
}
