import java.util.stream.Collectors;

public class Ruler extends ARuler {

    public Ruler(Pandemonium pandemonium) {
        this.king = pandemonium.getKing();
        this.allies = pandemonium.getAllies();
    }

    @Override
    public String displayName() {
        return king;
    }

    @Override
    public String displayAllies() {
        return allies.stream().map(Kingdom::displayName).collect(Collectors.joining(", "));
    }
}
