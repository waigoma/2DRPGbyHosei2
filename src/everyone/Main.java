package everyone;

import processing.core.PApplet;//ここでPAppletをimportしている

//クラス"Main"を作成し、PApplet(processing)を使いますと宣言(継承という)
public class Main extends PApplet {
    //以下processingと同様に書く

    @Override//Overrideは継承したクラスの中身を使う宣言
    public void settings(){
        //processingだとvoid setup()でやっていたがここではsettings()でsize指定
        size(480,480);
    }

    @Override
    public void setup(){
        //processingのsetup()と同様
    }

    @Override
    public void draw(){
        //processingのdraw()と同様
    }

    //Javaは下にある "public static void main(String[] args){}" が必ず最初に呼ばれる
    public static void main(String[] args){
        //PAppletのmain(最初に読み込むところ)はeveryoneフォルダの中のMainっていうファイルですよと指定してあげる
        PApplet.main("everyone.Main");
    }
}
