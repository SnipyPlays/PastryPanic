package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.pastrypanic.items.Product;

public class Klant extends CircleEntity {
    private Product wantsProduct;
    private int happiness;
    private boolean geholpen;
    private final static int Radius = 32;

    public Klant(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(Radius);
        happiness = 0;
        geholpen = false;
    }

    public static double getStaticRadius() {
        return Radius;
    }

    void geholpen(Product product) {
        if (wantsProduct == product) {
            geholpen = true;
        }
    }
}
