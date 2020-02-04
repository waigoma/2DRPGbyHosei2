package kotone.test;

import processing.core.PApplet;

public class Test extends PApplet{
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
        drawStar(width / 2, height / 2);
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
        text("Click Screen and you start game", width / 2, height * 2 / 3);
    }

    void goGame(){
    if(startWordCount >= startWord.length){
        aboutBall();
        game();
    }else{
        areYouReady();
        startWordCount++;
    }
    }

    void areYouReady(){
        frameRate(1);
        textSize(100);
        textAlign(CENTER);
        text(startWord[startWordCount], width / 2, height / 2);

    }

    void game(){
        frameRate(100);

        if (a == 0) boll_x += speedx;
        if (boll_x >= width - 5) {
            a = 1;
            speedx = random(3);

        }
        if (a == 1) boll_x -= speedx;
        if (boll_x <= 5) {
            a = 0;
            speedx = random(3);
        }
        if (b == 0) boll_y += speedy;
        if (boll_y >= height) {
            boll_y = 0;
            GAMEOVER_count++;
        }

        if (b == 1) boll_y -= speedy;
        if (boll_y <= 5) {
            b = 0;
            speedy = random(3, 5);
        }

        if (boll_x >= mouseX - 30 && boll_y >= 565 && boll_y <= 575 && boll_x <= mouseX + 30) {
            b = 1;

            if (GAMEOVER_count <= GAMEOVER_number) {
                point += 100;
                speedx = random(3);
                speedy = random(3, 5);
            }
        }

        if (boll_x >= mouseX - 30 && boll_y >= 565 && boll_y <= 585 && boll_x < mouseX - 10) a = 1;

        if (boll_x > mouseX + 10 && boll_y >= 565 && boll_y <= 585 && boll_x <= mouseX + 30) a = 0;

        if (boll_y >= 575 && boll_x == mouseX - 30 && boll_y <= 585){
            a = 0;
            b = 1;
            if (GAMEOVER_count <= GAMEOVER_number) point += 100;
        }
        if (boll_y >= 575 && boll_x == mouseX + 30 && boll_y <= 585) {
            a = 1;
            b = 1;
            if (GAMEOVER_count <= GAMEOVER_number) point += 100;
        }
        GAMEOVER();
     }

    void aboutBall(){
        noStroke();
        ellipse(boll_x,boll_y,10,10);
        fill(255);
        rect(mouseX,580,50,10);
    }

    void drawStar(int px,int py){
    noStroke();
    smooth();
    fill(255,255,0);
    beginShape();
    vertex(px    ,py - 20);
    vertex(px - 12,py + 15);
    vertex(px + 18,py - 8);
    vertex(px - 18 , py - 8);
    vertex(px + 12 , py + 15);
   endShape(CLOSE);
    }

    void beforeGAMEOVER_Display(){
            LIFE = GAMEOVER_number - (GAMEOVER_count - 1);
            textSize(16);
            text("POINT:", 40, 20);
            text(point, 100, 20);
            text("LIFE:", 140, 20);
            text(LIFE, 170, 20);
    }

    void afterGAMEOVER(){
            background(0);
            GAMEOVER_Comment();
            finishStar();
            reStartGame();
        }

    void GAMEOVER(){
            if(GAMEOVER_count > GAMEOVER_number) afterGAMEOVER();
            else beforeGAMEOVER_Display();
        }

    void GAMEOVER_Comment(){
      textAlign(CENTER);
      textSize(30);
      text("GAME OVER",width/2,height/3);
      text("GET",width/2-100,height/3+28);
      text(point,width/2,height/3+28);
      text("point",width/2+100,height/3+28);
    }

    void reStartGame(){
      fill(255);
      textAlign(CENTER);
      textSize(12);
      text("You click screen and finish this game",width/2,height*2/3);
      quiteNumber=1;
    }

    void finishStar(){
       frameRate(60);
       drawStar(width/2,height/2);
    }

    @Override
    public void mouseClicked(){
       mouseClickCount++;
       println(mouseClickCount);
       if(quiteNumber==1){
           exit();
       }
    }

    public static void main(String[] args){
        PApplet.main("kotone.test.Test");
    }
}