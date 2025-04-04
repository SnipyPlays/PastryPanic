package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;


public class Item extends DynamicSpriteEntity {

    public String naam;
    public String texturePath;

    public Item(String naam, String texturePath) {
        super(texturePath, new Coordinate2D(0, 0));
        this.naam = naam;
        this.texturePath = texturePath;
    }

    public Item(String naam, String texturePath, Size size) {
        super(texturePath, new Coordinate2D(0, 0), size);
        this.naam = naam;
        this.texturePath = texturePath;
    }

}
