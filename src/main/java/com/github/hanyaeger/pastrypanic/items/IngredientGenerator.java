package com.github.hanyaeger.pastrypanic.items;

import java.util.ArrayList;

public class IngredientGenerator {

    public ArrayList<Ingredient> ingredients = new ArrayList<>();
    private Ingredient errorIngredient = new Ingredient("error", "errorPath");

    public IngredientGenerator() {
        ingredients.add(new Ingredient("suiker", "suikerPath"));
        ingredients.add(new Ingredient("bloem", "bloemPath"));
        ingredients.add(new Ingredient("vlees", "vleesPath"));
        ingredients.add(new Ingredient("kaas", "kaasPath"));
        ingredients.add(new Ingredient("chocola", "chocolaPath"));
        ingredients.add(new Ingredient("appel", "appelPath"));
        ingredients.add(new Ingredient("water", "items/water.png"));
        ingredients.add(new Ingredient("kruiden", "kruidenPath"));

        ingredients.add(new Ingredient("deeg", "deegPath"));
        ingredients.add(new Ingredient("gekruidVlees", "gekruidVleesPath"));
        ingredients.add(new Ingredient("bladerdeeg", "bladerdeegPath"));
    }

    public Ingredient getIngredient(String naam) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.naam == naam) {
                return ingredient;
            }
        }
        return errorIngredient;
    }


}
