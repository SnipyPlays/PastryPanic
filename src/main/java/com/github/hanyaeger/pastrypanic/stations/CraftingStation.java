package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;

public class CraftingStation extends Station {

    protected CraftingStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);

    }

    @Override
    public void doStationAction(GameScene game, Speler speler) {
        System.out.println("craft");
    }
}
