package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.Product;

public class KlantItem extends Item {
    private Product item;

    public KlantItem(Product item) {
        super(item.naam, item.texturePath);
        this.item = item;
    }

    public Product getItem() {
        return item;
    }
}
