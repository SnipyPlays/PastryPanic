package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.CraftingInterface;

public class CraftingStation extends Station {

    protected CraftingStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);
        setAantalVakjes();
    }

    @Override
    public void doStationAction(GameScene game, Speler speler) {
        game.spawnInterface(new CraftingInterface(new Coordinate2D(70, 32), this, speler, game));
    }

    private void setAantalVakjes() {
        this.aantalVakjes = 5;
    }
}
