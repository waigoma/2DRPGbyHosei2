package waigoma.Title;

import processing.core.PApplet;
import waigoma.Main;

public class Title{
    Button button;
    PApplet plet;

    int scene = 0;

    public Title(PApplet papplet){
        this.plet = papplet;

        plet.rectMode(plet.CENTER);
        plet.textAlign(plet.CENTER, plet.CENTER);
        plet.noStroke();
        button = new Button(plet, plet.width/2, plet.height/2, 200, 100, "PUSH!");
    }


    public void display(){
        plet.background(128,128,128);
        plet.fill(0, 0, 0);
        plet.text("scene " + scene, plet.width/2, plet.height/4);

        button.run();
        if (button.isPush()) Main.scene = 1;
    }
}
