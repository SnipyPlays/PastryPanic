package com.github.hanyaeger.pastrypanic.entities.characters.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class PlayerSprite extends SpriteEntity {
    protected PlayerSprite(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
