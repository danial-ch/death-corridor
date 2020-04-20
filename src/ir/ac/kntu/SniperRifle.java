package ir.ac.kntu;

public class SniperRifle extends Gun {

    private boolean zoom;

    public SniperRifle() {
        this.damage=20;
        this.hitRate=60;
    }

    public boolean isZoom() {
        return zoom;
    }

    public void setZoom(boolean zoom) {
        this.zoom = zoom;
    }
}
