package waigoma.Map;

import issei.PlayerMove;
import nagai.Collision;
import processing.core.PApplet;
import processing.core.PImage;

public class Interact {
    /*
    eventId
    1 = chat
    2 = interact event
    3 = once event
    4 = move map
     */
    private float x,y,width,height;
    int sizeWidth,sizeHeight, eventId;
    String message, direction, name;
    int count, chatCount = 0;
    int time = 0;
    float px, py;
    boolean runChat, runEvent, right, left;

    PApplet plet;

    public Interact(float x, float y, float width, float height, int sizeWidth, int sizeHeight, int eventId, String name, String direction, String message, PApplet papplet){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        this.eventId = eventId;
        this.name = name;
        this.message = message;
        this.direction = direction;
        this.plet = papplet;
    }

    public void fixError(float fx, float fy){
        if (count == 0) {
            x = x - fx;
            y = y - fy;
            count++;
        }
    }

    public boolean trigger(){
        if((Collision.Playerx < (x + width)) && ((Collision.Playerx + Collision.PlayerWidth) > x) && (Collision.Playery < (y + height)) && ((Collision.Playery + Collision.PlayerHeight) > y)){
            if(Collision.Playerx > x + width - 4){
                return true;
            }else if((Collision.Playerx + Collision.PlayerWidth) < x + 4){
                return true;
            }else if(Collision.Playery > y + (height/2)){
                return true;
            }else if((Collision.Playery + Collision.PlayerHeight) < y + (height/2)){
                return true;
            }
        }
        return false;
    }

    public void event(){
        switch (eventId){
            case 1://chat表示
//                System.out.println("event:1");
                if (isDirectionClick()) runChat = true;
                runChat();
                break;
            case 2://イベント内容(ものを拾うとか)
                System.out.println("event:2");
                if (isDirectionClick()) runEvent = true;
                runEvent();
                break;
            case 3://一回きりのイベント
                break;
            case 4://移動イベント
                System.out.println("event:3");
                break;
        }
    }

    public void runChat(){
        if (chatCount == 0 && runChat){
            px = Collision.Playerx;
            py = Collision.Playery;
            chatCount++;
        }
        if (runChat){
            plet.rectMode(plet.CENTER);
            plet.stroke(0);
            plet.strokeWeight(8);
            plet.fill(0,0);
            plet.rect(plet.width/2f, plet.height/1.12f, 400, 150);
            plet.fill(0,230);
            plet.stroke(255);
            plet.strokeWeight(4);
            plet.rect(plet.width/2f, plet.height/1.12f, 400, 150);
            plet.fill(255);
            plet.textAlign(plet.LEFT, plet.TOP);
            plet.textSize(24);
            plet.text("『"+name+"』", plet.width/2f, plet.height/1.115f, 400, 150);
            plet.textSize(18);
            plet.text(message, plet.width/2f, plet.height/1.07f, 400, 150);

            plet.textAlign(plet.RIGHT, plet.BOTTOM);
            if (time < 30) plet.text("▶", plet.width/2f, plet.height/1.12f, 375, 125);
            if (time > 60) time = 0;

            Collision.Playerx = px;
            Collision.Playery = py;

            if (plet.keyCode == plet.ENTER) runChat = false;

            time++;
        }else {
            chatCount = 0;
        }
    }

    public void runEvent(){

    }

    public boolean isDirectionClick(){
        switch (direction){
            case "up":
                if (PlayerMove.up) {
                    return plet.mousePressed;
                }
                return false;
            case "right":
                if (PlayerMove.right) {
                    return plet.mousePressed;
                }
                return false;
            case "down":
                if (PlayerMove.down) {
                    return plet.mousePressed;
                }
                return false;
            case "left":
                if (PlayerMove.left) {
                    return plet.mousePressed;
                }
                return false;
            case "none":
                return plet.mousePressed;
        }
        return false;
    }
}
