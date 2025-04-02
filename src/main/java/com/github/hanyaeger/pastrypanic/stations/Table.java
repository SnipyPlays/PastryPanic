package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.TableInterface;

public class Table extends Station {

    protected Table(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);

    }

    @Override
    public void doStationAction(GameScene game, Speler speler) {
        System.out.println("tafel");
        game.spawnInterface(new TableInterface(new Coordinate2D(70, 32)));
    }
}
