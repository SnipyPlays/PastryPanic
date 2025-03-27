package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Station extends SpriteEntity {

    String naam;

    protected Station(String resource, Coordinate2D initialLocation, String naam) {
        super(resource, initialLocation);

        this.naam = naam;

    }
}
