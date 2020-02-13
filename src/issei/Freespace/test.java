package issei.Freespace;
import processing.core.PApplet;


public class test extends PApplet {

    float x = 0;
    float y = 0;
    int speed = 3;
    boolean right,left,up,down;



    @Override
    public void settings(){
        size(480,480);
    }


    @Override
    public void setup(){
        size(10,10);

    }

    @Override
    public void keyPressed() {// コード化されているキーが押された
        if (keyCode == RIGHT || key == 'd' || key == 'D') right = true;
        if (keyCode == LEFT || key == 'a' || key == 'A') left = true;
        if (keyCode == UP || key == 'w' || key == 'W') up = true;
        if (keyCode == DOWN || key == 's' || key == 'S') down = true;
    }
    @Override
    public void keyReleased() {//キーが離されたら
        if (keyCode == RIGHT || key == 'd' || key == 'D') right = false;
        if (keyCode == LEFT || key == 'a' || key == 'A') left = false;
        if (keyCode == UP || key == 'w' || key == 'W') up = false;
        if (keyCode == DOWN || key == 's' || key == 'S') down = false;
    }
    @Override
    public void draw(){
        background(0);//背景色



        if (right){
            x += speed;
        }
        if (left){
            x -= speed;
        }
        if (up){
            y -= speed;
        }
        if (down){
            y += speed;
            rect(10,10,10,10);
        }

    }


    public static void main(String[] args){
        PApplet.main("issei.Main");
    }
}



