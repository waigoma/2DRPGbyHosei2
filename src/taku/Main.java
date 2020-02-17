package taku;

import processing.core.PApplet;

public class Main extends PApplet {
    public static int random;
    @Override
    public void settings(){

    }

    @Override
    public void setup(){
        random = (int) random(1,6);
        if(random < 3)
            hibino.Combat.m_name = "モンスターA";
        if(random >=3)
            hibino.Combat.m_name = "モンスターB";
        waigoma.Main.state = 3;

    }

    @Override
    public void draw(){

    }

    public static void main(String[] args){
        PApplet.main("taku.Main");
    }
}
