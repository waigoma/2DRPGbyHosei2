package waigoma.Title.Option;

import processing.core.PApplet;
import taku.Encounter;

public class Option {
    public static final int EASY = 1200;
    public static final int NORMAL = 600;
    public static final int HARD = 300;

    String difficulty;

    public Option(String difficulty) {
            this.difficulty = difficulty;
        }

    public void properties(){
        switch (difficulty){
            case "easy":
                Encounter.difficulty = EASY;
                break;
            case "normal":
                Encounter.difficulty = NORMAL;
                break;
            case "hard":
                Encounter.difficulty = HARD;
                break;
        }
    }
}
