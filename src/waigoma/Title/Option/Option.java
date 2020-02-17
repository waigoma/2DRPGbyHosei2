package waigoma.Title.Option;

import processing.core.PApplet;
import taku.Encounter;

public class Option {
    String difficulty;

    public Option(String difficulty) {
            this.difficulty = difficulty;
        }

    public void properties(){
        switch (difficulty){
            case "easy":
                Encounter.difficulty = 1200;
                break;
            case "normal":
                Encounter.difficulty = 600;
                break;
            case "hard":
                Encounter.difficulty = 300;
                break;
        }
    }
}
