package waigoma;

import processing.core.PApplet;
import waigoma.Title.Title;

public class Main extends PApplet {
    public static int scene = 0;

    Title title;
    Test test;

    @Override
    public void settings(){
        size(1280,720);
    }

    @Override
    public void setup(){
        test = new Test(this);
        title = new Title(this);
        noStroke();
    }

    @Override
    public void keyPressed(){
        if (scene == 1) test.keyPressed();
    }

    @Override
    public void keyReleased(){
        if (scene == 1) test.keyReleased();
    }

    @Override
    public void draw(){
        switch (scene){
            case 0:
                title.display();
                break;
            case 1:
                test.display();
                break;
        }
    }

    public static void main(String[] args){
        PApplet.main("waigoma.Main");
    }
}
