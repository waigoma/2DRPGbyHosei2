package kotone;

import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Presentation extends PApplet {


    @Override
    public void settings(){
        size(600,400);
    }

    @Override
    public void setup(){
        background(255);
        paint(Graphics );

    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(10,10,100,50);


    }
    public static void main(String[] args){
        PApplet.main("kotone.Presentation");
    }
}
