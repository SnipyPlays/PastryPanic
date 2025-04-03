package com.github.hanyaeger.pastrypanic.stations.UI.segments;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class Vakje extends RectangleEntity {


    protected Vakje(Coordinate2D initialLocation) {
        super(initialLocation);
        this.setWidth(100);
        this.setHeight(100);
        this.setFill(Color.WHITE);
        this.setStrokeWidth(10);
        this.setStrokeColor(Color.BLACK);
    }
}
