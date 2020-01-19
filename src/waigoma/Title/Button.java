package waigoma.Title;

import processing.core.PApplet;

public class Button{
    float x, y;
    float sizeX, sizeY;
    private int state;
    private PApplet plet;
    String str;

    public Button(PApplet papplet, float x, float y, float sizeX, float sizeY, String str){
        this.plet = papplet;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.str = str;
    }

    public void run(){
        display();
        logic();
    }

    private void display(){
        changeColor();
        plet.rect(x, y, sizeX, sizeY);
        plet.fill(0, 0, 100);
        plet.textSize(30);
        plet.text(str, x, y);
    }

    private boolean checkInMouse(){
        if (plet.mouseX > x-sizeX/2 && plet.mouseX < x+sizeX/2){
            if (plet.mouseY > y-sizeY/2 && plet.mouseY < y+sizeY/2){
                return true;
            }
        }
        return false;
    }

    private int checkState(){
        if (!checkInMouse()) return 0;
        if (!plet.mousePressed) return 1;
        return 2;
    }

    public boolean isPush(){
        return checkState() == 2;
    }

    private void logic(){
        state = checkState();
    }

    private void changeColor(){
        switch (state){
            case 0:
                plet.fill(100,128,100);
                break;
            case 1:
                plet.fill(100,0,100);
                break;
            case 2:
                plet.fill(100,256,100);
                break;
            default:
                plet.fill(0, 0, 0);
        }
    }

}
