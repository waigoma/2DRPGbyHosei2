package kotone.presentation.damage;

import kotone.presentation.Main;
import processing.core.PApplet;
import processing.core.PImage;


public class Damage {
    PApplet pApplet;
    public static PImage img0,img1,img2,img3,img4,img5,img6,img7,img8,img9;

    public Damage(PApplet pApplet){ this.pApplet = pApplet;}


    public void setup(){
        img0 = pApplet.loadImage("damage(0).png");
        img1 = pApplet.loadImage("damage(1).png");
        img2 = pApplet.loadImage("damage(2).png");
        img3 = pApplet.loadImage("damage(3).png");
        img4 = pApplet.loadImage("damage(4).png");
        img5 = pApplet.loadImage("damage(5).png");
        img6 = pApplet.loadImage("damage(6).png");
        img7 = pApplet.loadImage("damage(7).png");
        img8 = pApplet.loadImage("damage(8).png");
        img9 = pApplet.loadImage("damage(9).png");
    }

    public void draw(){

    }


   // public static void main(String[] args){
       // PApplet.main("kotone.Damage");
    }


