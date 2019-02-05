import java.util.ArrayList;

public class Pandemonium extends ARuler {

    public Pandemonium() {
        allies = new ArrayList<>();
        king = "Shan";
    }

    public String getKing() {
        return king;
    }

    public ArrayList<Kingdom> getAllies() {
        return allies;
    }

    @Override
    public String displayName() {
        return "None";
    }

    @Override
    public String displayAllies() {
        return "None";
    }

}
