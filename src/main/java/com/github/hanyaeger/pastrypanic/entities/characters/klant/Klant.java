package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.pastrypanic.items.Product;
import javafx.scene.paint.Color;

public class Klant extends CompositeEntity {
    private boolean geholpen;
    private boolean active;
    private final static int Radius = 32;

    private KlantCircle klantCircle;
    private KlantItem item;

    public Klant(Coordinate2D initialLocation, Product product, boolean active) {
        super(initialLocation);
        this.active = active;
        geholpen = false;
        this.klantCircle = new KlantCircle(initialLocation);
        this.item = new KlantItem(product);
    }

    @Override
    public void setupEntities() {
        addEntity(klantCircle);
        addEntity(item);
    }

    public static double getStaticRadius() {
        return Radius;
    }

    public void geholpen(Product product) {
        if (item.getItem() == product) {
            geholpen = true;
        }
    }

    public Product getWantsProduct(){
        return item.getItem();
    }

    public void sethappiness(int happiness) {
        klantCircle.setHappiness(happiness);
    }

    public void klantHappiness() {
        klantCircle.klantHappiness();
    }

    public void setactive(boolean active) {
        this.active = active;
    }

    public void Visible(){
        klantCircle.setVisible(active);
        item.setVisible(active);
    }
}
