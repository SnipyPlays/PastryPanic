package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.SpicerackInterface;

public class GiveStation extends Station {

    private int aantalVakjes;

    protected GiveStation(String resource, Coordinate2D initialLocation, String naam, Integer aantalVakjes) {
        super(resource, initialLocation, naam);
        this.aantalVakjes = aantalVakjes;

    }

    public int getAantalVakjes() {
        return aantalVakjes;
    }

    @Override
    public void doStationAction(GameScene game, Speler speler) {
        game.spawnInterface(new SpicerackInterface(new Coordinate2D(70, 32), speler, game, this));
    }
}
