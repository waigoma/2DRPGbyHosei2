package waigoma;

public class Player {
    private int lvl;
    private int exp;
    private int maxExp;
    private int maxHP;
    private int maxMP;
    private int STR;
    private int DEF;
    private int AGL;
    private int INT;

    public void status(int lvl, int exp, int maxExp, int maxHP, int maxMP, int STR, int DEF, int AGL, int INT){
        this.lvl = lvl;
        this.exp = exp;
        this.maxExp = maxExp;
        this.maxHP = maxHP;
        this.maxMP = maxMP;
        this.STR = STR;
        this.DEF = DEF;
        this.AGL = AGL;
        this.INT = INT;
    }

    public int getLvl() {
        return lvl;
    }
    public int getExp() {
        return exp;
    }
    public int getMaxExp() {
        return maxExp;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getMaxMP() {
        return maxMP;
    }
    public int getSTR() {
        return STR;
    }
    public int getDEF() {
        return DEF;
    }
    public int getAGL() {
        return AGL;
    }
    public int getINT() {
        return INT;
    }
}
