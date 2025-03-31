package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import org.checkerframework.checker.units.qual.C;

public class Item extends DynamicSpriteEntity {

    public String naam;
    public String texturePath;

    public Item(String naam, String texturePath) {
        super(texturePath, new Coordinate2D(0, 0));
        this.naam = naam;
        this.texturePath = texturePath;
    }

    public void move() {
        setMotion(3,90d);
    };
}
