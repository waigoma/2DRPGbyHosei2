package kotone;

import processing.core.PApplet;

public class Test extends PApplet{



    @Override
    public void settings(){size(1280,720);}

    @Override
    public void setup(){

//        gif = new Gif(this,"src/kotone/deta/bakuhatsu2.gif");
//        gif.play();
    }

    @Override
    public void draw(){

        background(255);
//        image(gif,0,0);
    }

    public static void main(String[] args){
        PApplet.main("kotone.Test");
    }
}
