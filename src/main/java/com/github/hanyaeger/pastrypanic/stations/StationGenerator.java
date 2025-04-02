package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;

import java.util.ArrayList;

public class StationGenerator {

    ArrayList<Station> stations = new ArrayList<>();
    Station errorStation = new Station("error", new Coordinate2D(0, 0), "error");

    public StationGenerator() {
        Station oven = new CraftingStation("stations/oven.png", new Coordinate2D(128,160), "oven");
        stations.add(oven);
//        Station wafelijzer = new CraftingStation("wafelijzer", new Coordinate2D(0, 0), "wafelijzer");
//        stations.add(wafelijzer);
//        Station baguettematic = new CraftingStation("baguettematic", new Coordinate2D(0, 0), "baguettematic");
//        stations.add(baguettematic);
//        Station crafter = new CraftingStation("crafter", new Coordinate2D(0, 0), "crafter");
//        stations.add(crafter);
//        Station roller = new CraftingStation("roller", new Coordinate2D(0, 0), "roller");
//        stations.add(roller);
    }

    public Station getStation(String stationsNaam) {
        for (Station station : stations) {
            if (stationsNaam == station.naam) {
                return station;
            }
        }
        return errorStation;
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

}
