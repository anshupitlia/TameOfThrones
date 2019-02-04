import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ruler {
    private final String king;
    private final ArrayList<Kingdom> allies;

    public Ruler(String king, ArrayList<Kingdom> allies) {
        this.king = king;
        this.allies = allies;
    }

    public String displayName() {
        return king;
    }

    public String displayAllies() {
        return allies.stream().map(Kingdom::displayName).collect(Collectors.joining(", "));
    }
}
