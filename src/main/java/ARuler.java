import java.util.ArrayList;

public class ARuler {
     protected ArrayList<Kingdom> allies;
     protected String king;


     public void addAlly(Kingdom kingdom) {
          this.allies.add(kingdom);
     }

     public String displayName() {
          return "";
     }

     public String displayAllies() {
          return "";
     }

     public boolean isWinningRuler() {
          return allies.size() >= UniverseOfSoutheros.WINNING_CRITERIA;
     }
}
