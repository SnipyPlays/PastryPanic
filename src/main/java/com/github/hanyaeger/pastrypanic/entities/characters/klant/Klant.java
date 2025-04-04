package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.items.Product;

import java.time.LocalDateTime;

public class Klant extends DynamicCompositeEntity implements UpdateExposer {
    private PastryPanic game;

    private boolean geholpen;
    private boolean active;
    private LocalDateTime begin;
    private final static int Radius = 32;

    private KlantCircle klantCircle;
    private KlantItem klantitem;
    private KlantHitbox klantHitbox;

    public Klant(Coordinate2D initialLocation, Product product, boolean active, PastryPanic pastryPanic) {
        super(initialLocation);
        this.active = active;
        geholpen = false;
        this.klantCircle = new KlantCircle(new Coordinate2D(0, 0));
        this.klantitem = new KlantItem(product);
        this.klantHitbox = new KlantHitbox(new Coordinate2D(0-16, 0-250), 100, 64, this);
        begin = LocalDateTime.now();
        game = pastryPanic;
    }

    @Override
    public void setupEntities() {
        addEntity(klantCircle);
        addEntity(klantitem);
        addEntity(klantHitbox);
    }

    public static double getStaticRadius() {
        return Radius;
    }

    public void statusKlant() {
        if (active) {
            if (!geholpen) {
                LocalDateTime now = LocalDateTime.now();
                if (now.isAfter(begin.plusSeconds(30))) {
                    begin = now;
                    if (getHappiness() <= 3) {
                        sethappiness(getHappiness() + 1);
                    } else {
                        setactive(false);
                        game.setActiveScene(3);
                    }
                }
            }else {
                setactive(false);
            }
        }
    }

    public void setGeholpen(boolean geholpen) {
            this.geholpen = geholpen;
    }

    public boolean getGeholpen(){
        return geholpen;
    }

    public Product getWantsProduct() {
        return klantitem.getItem();
    }

    public void sethappiness(int happiness) {
        klantCircle.setHappiness(happiness);
    }

    public int getHappiness() {
        return klantCircle.getHappiness();
    }


    public void klantHappiness() {
        klantCircle.klantHappiness();
    }

    public void setactive(boolean active) {
        this.active = active;
    }

    public void Visible() {
        klantCircle.setVisible(active);
        klantitem.setVisible(active);
    }

    @Override
    public void explicitUpdate(long l) {
        //klant updates
        Visible();
        statusKlant();
        klantCircle.klantHappiness();
    }
}
