package ir.ac.kntu;

public class Soldier {
    private int number;
    private int health=40;
    private boolean isBlue;
    private Gun gun;
    private boolean dead=false;

    public Soldier(int number, boolean isBlue, Gun gun) {
        this.number = number;
        this.isBlue = isBlue;
        this.gun = gun;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
