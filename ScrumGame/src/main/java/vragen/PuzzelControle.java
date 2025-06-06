package vragen;

import utils.SpelerInputHandler;

public class PuzzelControle implements VraagControleStrategie{
    private String goedAntwoord;

    public PuzzelControle (String goedAntwoord) {
        this.goedAntwoord = goedAntwoord;
    }

    @Override
    public boolean checkGoedAntwoord() {
        return SpelerInputHandler.spelerAntwoord().trim().equalsIgnoreCase(goedAntwoord);
    }
    public String getCorrectAntwoord () {
        return goedAntwoord;
    }
}
