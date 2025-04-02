package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;

public class CraftingStation extends Station {

    protected CraftingStation(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation, naam);
        System.out.println("oven gemaakt");

    }
}
