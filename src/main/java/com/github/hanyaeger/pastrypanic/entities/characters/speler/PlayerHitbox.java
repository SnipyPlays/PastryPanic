package com.github.hanyaeger.pastrypanic.entities.characters.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class PlayerHitbox extends RectangleEntity implements Collider {

    protected PlayerHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
    }
}
