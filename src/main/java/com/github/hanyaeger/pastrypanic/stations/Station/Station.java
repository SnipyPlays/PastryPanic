package com.github.hanyaeger.pastrypanic.stations.Station;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;

import java.util.ArrayList;

public abstract class Station extends DynamicCompositeEntity {

    private String naam;
    StationSprite sprite;
    StationHitbox stationHitbox;
    StationBounding stationBounding;
    ArrayList<String> itemList = new ArrayList<>();
    public Integer aantalVakjes;

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

    public abstract void doStationAction(GameScene game, Speler speler);

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void addToItemList(String item) {
        itemList.add(item);
    }

    public void removeItemFromList(Item item) {
        for (String listItem : itemList) {
            if (item.naam == listItem){
                itemList.remove(listItem);
                break;
            }
        }
    }

    public void resetItemList() {
        itemList.clear();
    }

    public String getNaam() {
        return naam;
    }

}
