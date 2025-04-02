package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;

public class GiveStation extends Station {

    protected GiveStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);

    }

    @Override
    public void doStationAction() {
        System.out.println("give");
    }
}
