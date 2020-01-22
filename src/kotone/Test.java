package kotone;

import processing.core.PApplet;

public class Test extends PApplet {
float boll_x,boll_y,speedx,speedy;
int a,b,point,GAMEOVER_count,GAMEOVER_number,LIFE,startWordCount,mouseClickCount,quiteNumber;
String[] startWord = {"","ARE","YOU","READY?"};

@Override
public void settings() {
    size(400, 600);
}


    @Override
    public void setup () {
        a = 0;
        b = 0;
        boll_x = 0;
        boll_y = 0;
        point = 0;
        GAMEOVER_count = 0;
        GAMEOVER_number = 0;
        mouseClickCount = 0;
        quiteNumber = 0;
        speedx = 1.0f;
        speedy = 5.0f;
        rectMode(CENTER);
    }
    @Override
    public void draw () {
        background(0);
        if (mouseClickCount == 0) startWindow();
        else goGame();
    }

    public void startWindow () {
        title();
        //drawStar(width / 2, height / 2);
        startWord();
    }

    void title () {
        fill(255);
        textAlign(CENTER);
        textSize(40);
        text("BOARD GAME", width / 2, height / 3);
    }

    void startWord () {
        fill(255);
        textAlign(CENTER);
        textSize(12);
        text("Click Schreen and you start game", width / 2, height * 2 / 3);
    }

    void goGame(){
        frameRate(1);
        textSize(100);
        textAlign(CENTER);
        text(startWord[startWordCount], width / 2, height / 2);
    }

    void game(){
        frameRate(100);

        if(a==0) boll_x+=speedx;
        if(boll_x>=width-5){
            a=1;
            speedx=random(3);

        }
        if(a==1) boll_x-=speedx;
        if(boll_x==5){
            a = 0;
            speedx = random(3);
        }
        if (b==0) boll_y+=speedy;

        }
    public static void main(String[] args){
        PApplet.main("kotone.test");
    }
}