package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class StationBounding extends RectangleEntity implements Collider {

    private Station station;

    protected StationBounding(Coordinate2D initialLocation, Station station) {
        super(initialLocation);
        this.station = station;

        setWidth(128);
        setHeight(128);
        setFill(Color.TRANSPARENT);
    }

    public Station getStation() {
        return station;
    }
}
