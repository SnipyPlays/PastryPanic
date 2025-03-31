package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Character extends DynamicSpriteEntity {
    protected Character(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void setAnchorLocationX(double x) {
        super.setAnchorLocationX(x);
    }
    public void setAnchorLocationY(double y) {
        super.setAnchorLocationY(y);
    }

    @Override
    public Coordinate2D getAnchorLocation() {
        return super.getAnchorLocation();
    }
}
