package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.PrullenbakInterface;

public class DeleteStation extends Station {

    public DeleteStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);
    }

    @Override
    public void doStationAction(GameScene game, Speler speler) {
        game.spawnInterface(new PrullenbakInterface(new Coordinate2D(70, 32), speler, game, this));
    }
}
