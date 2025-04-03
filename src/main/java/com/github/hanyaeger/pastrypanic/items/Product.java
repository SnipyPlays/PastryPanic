package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.api.Size;

public class Product extends Item{

    private Recept recept;
    private int unlockDay;

    public Product(String naam, String texturePath, Recept recept, Integer unlockDay) {
        super(naam, texturePath);
        this.recept = recept;
        this.unlockDay = unlockDay;
    }

    public Product(String naam, String texturePath, Recept recept, Integer unlockDay, Size size) {
        super(naam, texturePath, size);
        this.recept = recept;
        this.unlockDay = unlockDay;
    }

    public int getUnlockDay() {
        return unlockDay;
    }
}
