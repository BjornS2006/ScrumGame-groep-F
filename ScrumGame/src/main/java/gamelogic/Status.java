package gamelogic;

import kamers.Kamer;
import utils.SaveSystemInterface;
import utils.SpelerSession;
import vragen.Vraag;

public class Status implements Update {
    private int score;
    private String positie;
    private transient SaveSystemInterface saveSystem;
    private transient Kamer actieveKamer;
    private transient Vraag huidigeVraag;

    public Status(int score, String positie, SaveSystemInterface saveSystem) {
        this.score = score;
        this.positie = positie;
        this.saveSystem = saveSystem;
    }

    @Override
    public void update(boolean goedOfFout) {
        if (goedOfFout) {
            score++;
            save();
            System.out.println("Je hebt een punt verdiend! Je score is nu: " + score);
        }
        else {
            System.out.println("Je hoort het geluid van een monster ergens in de kamer...");
        }
    }

    public int getScore() {
        return score;
    }

    public String getPositie() {
        return positie;
    }

    public void setPositie(String positie) {
        this.positie = positie;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSaveSystem(SaveSystemInterface saveSystem) {
        this.saveSystem = saveSystem;
    }

    public Kamer getActieveKamer() {
        return actieveKamer;
    }

    public void setActieveKamer(Kamer actieveKamer) {
        this.actieveKamer = actieveKamer;
    }

    public Vraag getHuidigeVraag() {
        return huidigeVraag;
    }

    public void setHuidigeVraag(Vraag huidigeVraag) {
        this.huidigeVraag = huidigeVraag;
    }

    public void resetNaarBegin() {
        SpelerSession.clear();
    }
    public void save () {
        saveSystem.saveGame(SpelerSession.getSpeler());
    }
}
