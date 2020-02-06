package nagai;

import processing.core.PApplet;

public class Zikken2 extends PApplet  {
    int gamemode = 0;
    boolean W = false;
    boolean D = false;
    boolean S = false;
    boolean A = false;
    boolean Dash = false;  //shiftを定義するか、Wで定義するか
    float x = 450;
    float y = 270;
    double xspeed = 3.0;
    double yspeed = 3.0;
    double DashSpeed = 6.0;
    int Life = 1;


    @Override
    public void settings(){
        size(1000,600);
    }
    @Override
    public void setup(){
    }

    @Override
    public void keyPressed(){
        if (key == 'w') W = true;   //キーボードのときはkeyCodeはダメ
        if (key == 'a') A = true;
        if (key == 's') S = true;
        if (key == 'd') D = true;
        if(keyCode == SHIFT) Dash = true;
    }
    @Override
    public void keyReleased(){
        if (key == 'w') W = false;
        if (key == 'a') A = false;
        if (key == 's') S = false;
        if (key == 'd') D = false;
        if(keyCode == SHIFT) Dash = false;
    }
    public void draw(){
        background(0);
        if(gamemode == 0){
            title();
        }else if(gamemode == 1){
            PlayerMove();
            PlayerDisp();
            EnemyDisp();
            EnemyMove();
            LifeCount();
            if(Life == 0){
                gamemode = 2;
            }
        }else if(gamemode == 2){
            GameOver();
        }
    }
    void title(){
        textSize(100);
        fill(100,200,150);
        textAlign(CENTER);
        text("Press Key",500,300);

        if(keyPressed==true){
            gamemode=1;
        }
    }
    void PlayerMove(){
        if(D && Dash){
            x += DashSpeed;
        }
        if(A && Dash){
            x -= DashSpeed;
        }
        if(W && Dash){
            y -= DashSpeed;
        }
        if(S && Dash){
            y += DashSpeed;
        }
        if (D){
            x += xspeed;
        }
        if (A){
            x -= xspeed;
        }
        if (W){
            y -= yspeed;
        }
        if (S){
            y += yspeed;
        }
        if(y>height-30){
            y=570;
        }
        if(y<0) {
            y=0;
        }
        if(x<0){
            x=0;
        }
        if(x>width-50){
            x=950;
        }
    }
    void PlayerDisp(){
        noStroke();
        rect(x,y,50,30);
    }
    void EnemyDisp(){
        rect(900,300,30,15);
    }
    void EnemyMove(){
    }
    void LifeCount() {
        if((x < 930) && ((x+50) > 900) && (y < 315) && ((y+30) > 300)){
            Life = Life-1;
        }
        }

        void GameOver(){
            text("Game Over", 500, 200);
            textAlign(CENTER);
            textSize(100);
        }
        public static void main(String[]args){
            PApplet.main("nagai.Zikken2");
        }
    }