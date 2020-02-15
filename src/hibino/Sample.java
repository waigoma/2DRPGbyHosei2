package hibino;

import hibino.Main;
import processing.core.PApplet;

//import static hibino.Main.item_event;
import static hibino.Main.start_event;

public class Sample extends PApplet {


    PApplet pApplet;//--------------------------------読み込む文言
    public Sample(PApplet pApplet) {
        this.pApplet = pApplet;
    }


    @Override
    public void settings(){
        size(1280,750);
    }

    @Override
    public void setup(){

    }
    @Override
    public  void draw(){
       // background(0, 255, 0);

        //if(start_event) {

            //pApplet.fill(200);
            rect(500,500,500,500);

           // start_event = false;
           // a_event = false;
         //   fill(255, 255, 255, 100);    //～の色（４つ目は透明度）    　　　　　　　　　ここはプレイヤーの四角
         //   text("a",500,500);

       // }


    }

    public static void main(String[] args){
        PApplet.main("hibino.Sample");
    }
}
