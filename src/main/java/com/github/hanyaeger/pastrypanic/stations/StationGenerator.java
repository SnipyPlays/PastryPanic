package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;

import java.util.ArrayList;

public class StationGenerator {

    ArrayList<Station> stations = new ArrayList<>();
    Station errorStation = new CraftingStation("error", new Coordinate2D(0, 0), "error");

    public StationGenerator() {
        Station oven = new CraftingStation("stations/oven.png", new Coordinate2D(64,80), "oven");
        stations.add(oven);
        Station wafelijzer = new CraftingStation("stations/wafelijzer.png", new Coordinate2D(128, 80), "wafelijzer");
        stations.add(wafelijzer);
        Station baguettematic = new CraftingStation("stations/baguettematic.png", new Coordinate2D(192, 80), "baguettematic");
        stations.add(baguettematic);
        Station crafter = new CraftingStation("stations/crafter.png", new Coordinate2D(256, 80), "crafter");
        stations.add(crafter);
        Station roller = new CraftingStation("stations/roller.png", new Coordinate2D(320, 80), "roller");
        stations.add(roller);
        Station spicerack = new GiveStation("stations/spicerack.png", new Coordinate2D(384, 80), "spicerack");
        stations.add(spicerack);
        Station orderTable = new OrderStation("stations/besteltafel.png", new Coordinate2D(448, 80), "orderTable");
        stations.add(orderTable);
        Station tafel1 = new Table("stations/tafel.png", new Coordinate2D(192, 160), "tafel1");
        stations.add(tafel1);
        Station tafel2 = new Table("stations/tafel.png", new Coordinate2D(384, 160), "tafel2");
        stations.add(tafel2);
        Station prullenbak = new DeleteStation("stations/prullenbak.png", new Coordinate2D(512, 80), "prullenbak");
        stations.add(prullenbak);
    }

    public Station getStation(String stationsNaam) {
        for (Station station : stations) {
            if (stationsNaam == station.getNaam()) {
                return station;
            }
        }
        return errorStation;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

}
