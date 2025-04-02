package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Station  extends DynamicCompositeEntity {
    private String naam;
    SpiritStation spirit;
    StationHitbox stationHitbox;
    public Station(String resource, Coordinate2D initialLocation, String naam) {
        super(initialLocation);
        this.spirit = new SpiritStation(resource, initialLocation);
        this.stationHitbox = new StationHitbox(initialLocation);
        this.naam = naam;
    }

    @Override
    protected void setupEntities() {
        addEntity(spirit);
        addEntity(stationHitbox);
    }

    public String getNaam() {
        return naam;
    }

}
