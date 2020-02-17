package taku;

import hibino.Combat;
import issei.PlayerMove;
import processing.core.PApplet;
import waigoma.Main;
import waigoma.StateType;

public class Encounter {
    int i, r, q = 0;
    float w;

    PApplet plet;

    public Encounter(PApplet papplet){
        this.plet = papplet;
    }

    public void randomEncounter(){
        if (PlayerMove.up || PlayerMove.right || PlayerMove.down || PlayerMove.left){
            i += plet.random(0, 2);
        }
        
        if (i > 60){
            randomMonster();
        }
    }

    public void randomMonster(){
        w = plet.random(6);
        if (w < 3){
            Combat.m_name = "モンスターA";
        }else{
            Combat.m_name = "モンスターB";
        }
        i = 0;
        PlayerMove.up = false;
        PlayerMove.right = false;
        PlayerMove.down = false;
        PlayerMove.left = false;

        Main.state = StateType.COMBAT_STATE;
    }
}
