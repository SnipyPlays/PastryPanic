package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.items.Product;

public class Klant extends Character {
    private Product wiltProduct;

    protected Klant (String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }


}
