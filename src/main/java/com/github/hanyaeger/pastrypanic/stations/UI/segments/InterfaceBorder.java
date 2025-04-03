package com.github.hanyaeger.pastrypanic.stations.UI.segments;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class InterfaceBorder extends RectangleEntity {

    public InterfaceBorder(Coordinate2D initialLocation, Size size) {
        super(initialLocation);

        this.setWidth(size.width());
        this.setHeight(size.height());
        this.setFill(Color.WHITE);
        this.setStrokeWidth(20);
        this.setStrokeColor(Color.BLACK);
    }
}
