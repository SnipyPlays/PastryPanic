package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.pastrypanic.stations.Station.Station;

import java.util.ArrayList;

public class Recept {

    Station station;
    ArrayList<Item> ingredients;
    String naam;

    public Recept(Station station, ArrayList<Item> ingredients, String naam) {
        this.station = station;
        this.ingredients = ingredients;
        this.naam = naam;
    }

    public ArrayList<String> getIngredients() {
        ArrayList<String> itemNamen = new ArrayList<>();
        for (Item ingredient : ingredients) {
            itemNamen.add(ingredient.naam);
        }
        return itemNamen;
    }

}
