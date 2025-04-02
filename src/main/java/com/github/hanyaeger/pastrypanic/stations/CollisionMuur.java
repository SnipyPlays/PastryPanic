package com.github.hanyaeger.pastrypanic.stations;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class CollisionMuur extends RectangleEntity implements Collider {
    public CollisionMuur(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }

    @Override
    public void setFill(Color fill) {
        super.setFill(fill);
    }




}
