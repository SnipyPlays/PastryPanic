package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;

public class ItemVakje extends CompositeEntity {

    ProductGenerator productGenerator = new ProductGenerator();
    Vakje vakje;
    Item item;

    protected ItemVakje(Coordinate2D initialLocation) {
        super(initialLocation);
        this.vakje = new Vakje(initialLocation);
        this.item = productGenerator.createProduct("croissant");
        item.setAnchorLocationX(75);
        item.setAnchorLocationY(50);
    }

    @Override
    protected void setupEntities() {
        addEntity(vakje);
        if (item != null) {
            addEntity(item);
        }
    }
}
