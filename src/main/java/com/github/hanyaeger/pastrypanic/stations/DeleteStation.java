package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;

public class DeleteStation extends Station {

    public DeleteStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);
    }
}
