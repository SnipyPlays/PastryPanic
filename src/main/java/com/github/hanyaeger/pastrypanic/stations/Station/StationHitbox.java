package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.pastrypanic.IBlocker;
import javafx.scene.paint.Color;

public class StationHitbox extends RectangleEntity implements Collider, IBlocker {

    public StationHitbox(final Coordinate2D initialPosition) {

        super(initialPosition);
        setWidth(128);
        setHeight(10);
        setFill(Color.TRANSPARENT);
    }

    public boolean getCollision() {
        return true;
    }
}
