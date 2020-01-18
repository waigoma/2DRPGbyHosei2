package waigoma.Title;

import processing.core.PApplet;

public class Title extends PApplet {
    Button button;
    int scene = 0;

    public void test(){

    }

    @Override
    public void settings(){
        size(1280, 720);
    }

    @Override
    public void setup(){
        rectMode(CENTER);
        textAlign(CENTER, CENTER);
        noStroke();

        button = new Button(this, width/2, height/2, 200, 100, "PUSH!");
    }

    @Override
    public void draw(){
        background(128,128,128);
        fill(0, 0, 0);
        text("scene " + scene, width/2, height/4);

        switch (scene){
            case 0:
                button.run();
                if (button.isPush()) scene = 1;
                break;
            case 1:
                break;
        }
    }

    public static void main(String[] args){
        PApplet.main("waigoma.Title.Title");
    }

}
