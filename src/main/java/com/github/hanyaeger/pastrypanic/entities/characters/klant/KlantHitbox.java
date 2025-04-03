package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class KlantHitbox extends RectangleEntity implements Collider {

    protected KlantHitbox(Coordinate2D initialLocation, int width, int height) {
        super(initialLocation);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
    }

}
