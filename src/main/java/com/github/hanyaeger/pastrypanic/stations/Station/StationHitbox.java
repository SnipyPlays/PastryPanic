package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class StationHitbox extends RectangleEntity implements Collider {
    public StationHitbox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(128);
        setHeight(40);
        setFill(Color.TRANSPARENT);
    }
}
