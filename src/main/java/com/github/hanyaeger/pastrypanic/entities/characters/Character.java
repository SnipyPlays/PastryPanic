package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Character extends DynamicSpriteEntity {
    protected Character(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
