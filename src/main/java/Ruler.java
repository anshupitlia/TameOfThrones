public class Ruler {
    private Kingdom kingdom;

    public Ruler() {
        this.kingdom = new Kingdom();
    }

    public Ruler(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    public String displayAllies() {
        return kingdom.displayAllies();
    }

    public String displayName() {
        return kingdom.displayName();
    }
}
