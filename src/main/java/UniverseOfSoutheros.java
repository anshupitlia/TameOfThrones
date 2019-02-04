import java.util.ArrayList;

public class UniverseOfSoutheros {
    private ArrayList<Kingdom> kingdoms;
    private ARuler ruler;
    public static final int WINNING_CRITERIA = 3;

    public UniverseOfSoutheros(ArrayList<Kingdom> kingdoms) {
        this.kingdoms = kingdoms;
        this.ruler = new Pandemonium();
    }

    public String rulerDisplay() {
        return ruler.displayName();
    }

    public String alliesDisplay() {
        return ruler.displayAllies();
    }

    public void sends(Kingdom receiver, String msg) {
        if(receiver.isAlly(msg)) {
            ruler.addAlly(receiver);
        }
    }

    public void findRuler() {
        if (ruler.isWinningRuler() && ruler instanceof Pandemonium) {
            ruler = new Ruler((Pandemonium) ruler);
        }
    }
}
