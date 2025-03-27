package com.github.hanyaeger.pastrypanic.items;

public class Product extends Item{

    Recept recept;
    int unlockDay;

    public Product(String naam, String texturePath, Recept recept, Integer unlockDay) {
        super(naam, texturePath);
        this.recept = recept;
        this.unlockDay = unlockDay;
    }

}
