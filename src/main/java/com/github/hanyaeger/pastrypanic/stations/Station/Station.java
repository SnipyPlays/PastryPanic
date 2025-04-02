package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Station  extends DynamicCompositeEntity {

    private String naam;
    StationSprite sprite;
    StationHitbox stationHitbox;
    StationBounding stationBounding;

    public Station(String resource, Coordinate2D initialLocation, String naam) {
        super(initialLocation);
        this.sprite = new StationSprite(resource, initialLocation);

        double originalY = initialLocation.getY();
        double originalX = initialLocation.getX();
        double newY = originalY + 30;
        Coordinate2D newPosition = new Coordinate2D(originalX, newY);

        this.stationHitbox = new StationHitbox(newPosition);
        this.stationBounding = new StationBounding(initialLocation, this);
        this.naam = naam;

    }

    @Override
    protected void setupEntities() {
        addEntity(sprite);
        addEntity(stationHitbox);
        addEntity(stationBounding);
    }

    public abstract void doStationAction();

    public String getNaam() {
        return naam;
    }

}
