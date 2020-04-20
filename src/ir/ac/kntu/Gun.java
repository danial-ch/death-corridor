package ir.ac.kntu;

public class Gun {
    protected int damage;
    protected int hitRate;
    protected boolean highCalibre;

    public Gun() {

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitRate() {
        return hitRate;
    }

    public void setHitRate(int hitRate) {
        this.hitRate = hitRate;
    }

    public boolean isHighCalibre() {
        return highCalibre;
    }

    public void setHighCalibre(boolean highCalibre) {
        this.highCalibre = highCalibre;
    }
}
