package kotone.presentation.damage;

import processing.core.PApplet;
import processing.core.PImage;


public class Damage extends PApplet{
    PImage img0,img1,img2,img3,img4,img5,img6,img7,img8,img9;

    @Override
    public void settings() {
        size(400,400);
        background(255,0,0);

    }

    public void setup(){
        img0 = loadImage("damage(0).png");
        img1 = loadImage("damage(1).png");
        img2 = loadImage("damage(2).png");
        img3 = loadImage("damage(3).png");
        img4 = loadImage("damage(4).png");
        img5 = loadImage("damage(5).png");
        img6 = loadImage("damage(6).png");
        img7 = loadImage("damage(7).png");
        img8 = loadImage("damage(8).png");
        img9 = loadImage("damage(9).png");
    }

    public void draw(){

    }


   // public static void main(String[] args){
       // PApplet.main("kotone.Damage");
    }


