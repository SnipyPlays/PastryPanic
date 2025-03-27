package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.pastrypanic.stations.StationGenerator;

import java.util.ArrayList;

public class ReceptenBoek {

    private StationGenerator stationGenerator = new StationGenerator();
    private IngredientGenerator ingredientGenerator = new IngredientGenerator();

    public ArrayList<Recept> recepten = new ArrayList<>();
    public ArrayList<Recept> tussenIngredients = new ArrayList<>();
    public Recept errorRecept = new Recept(stationGenerator.getStation("error"), new ArrayList<Item>(), "error");
    public ArrayList<Product> producten = new ArrayList<>();
    public Product errorProduct = new Product("error", "errorPath", errorRecept, 0);

    public ReceptenBoek() {
        
        //deeg
        ArrayList<Item> deeg = new ArrayList<>();
        deeg.add(ingredientGenerator.getIngredient("bloem"));
        deeg.add(ingredientGenerator.getIngredient("water"));
        tussenIngredients.add(new Recept(stationGenerator.getStation("crafter"), deeg, "muffin"));

        //bladerdeeg
        ArrayList<Item> bladerdeeg = new ArrayList<>();
        bladerdeeg.add(getTussenIngredient("deeg"));
        tussenIngredients.add(new Recept(stationGenerator.getStation("crafter"), bladerdeeg, "bladerdeeg"));

        //gekruidvlees
        ArrayList<Item> gekruidvlees = new ArrayList<>();
        gekruidvlees.add(ingredientGenerator.getIngredient("kruiden"));
        gekruidvlees.add(ingredientGenerator.getIngredient("vlees"));
        tussenIngredients.add(new Recept(stationGenerator.getStation("crafter"), gekruidvlees, "gekruid vlees"));
        
        //muffin
        ArrayList<Item> muffin = new ArrayList<>();
        muffin.add(getTussenIngredient("deeg"));
        muffin.add(ingredientGenerator.getIngredient("suiker"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), muffin, "muffin"));
        producten.add(new Product("muffin", "muffinPath", getRecept("muffin"), 1));

        //wafel
        ArrayList<Item> wafel = new ArrayList<>();
        wafel.add(getTussenIngredient("deeg"));
        wafel.add(ingredientGenerator.getIngredient("suiker"));
        recepten.add(new Recept(stationGenerator.getStation("wafelijzer"), wafel, "wafel"));
        producten.add(new Product("wafel", "wafelPath", getRecept("wafel"), 1));

        //hard broodje
        ArrayList<Item> hardBroodje = new ArrayList<>();
        hardBroodje.add(getTussenIngredient("deeg"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), hardBroodje, "hard broodje"));
        producten.add(new Product("hard broodje", "hardbroodjePath", getRecept("hard broodje"), 1));

        //worstenbroodje
        ArrayList<Item> worstenbroodje = new ArrayList<>();
        worstenbroodje.add(getTussenIngredient("deeg"));
        worstenbroodje.add(ingredientGenerator.getIngredient("vlees"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), worstenbroodje, "worstenbroodje"));
        producten.add(new Product("worstenbroodje", "worstenbroodjePath", getRecept("worstenbroodje"), 1));

        //brood
        ArrayList<Item> brood = new ArrayList<>();
        brood.add(getTussenIngredient("deeg"));
        brood.add(getTussenIngredient("deeg"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), brood, "brood"));
        producten.add(new Product("brood", "broodPath", getRecept("brood"), 1));

        //chocolademuffin
        ArrayList<Item> chocoladeMuffin = new ArrayList<>();
        chocoladeMuffin.add(getTussenIngredient("deeg"));
        chocoladeMuffin.add(ingredientGenerator.getIngredient("suiker"));
        chocoladeMuffin.add(ingredientGenerator.getIngredient("chocolade"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), chocoladeMuffin, "chocolade muffin"));
        producten.add(new Product("chocolade muffin", "chocolademuffinPath", getRecept("chocolade muffin"), 2));

        //croissant
        ArrayList<Item> croissant = new ArrayList<>();
        croissant.add(getProduct("hard broodje"));
        recepten.add(new Recept(stationGenerator.getStation("baguettematic"), croissant, "croissant"));
        producten.add(new Product("croissant", "croissantPath", getRecept("croissant"), 2));

        //baguette
        ArrayList<Item> baguette = new ArrayList<>();
        baguette.add(getProduct("brood"));
        recepten.add(new Recept(stationGenerator.getStation("baguettematic"), baguette, "baguette"));
        producten.add(new Product("baguette", "baguettePath", getRecept("baguette"), 2));

        //kaascroissant
        ArrayList<Item> kaasCroissant = new ArrayList<>();
        kaasCroissant.add(ingredientGenerator.getIngredient("kaas"));
        kaasCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), kaasCroissant, "kaas croissant"));
        producten.add(new Product("kaas croissant", "kaascroissantPath", getRecept("kaas croissant"), 3));

        //chocoladecroissant
        ArrayList<Item> chocoladeCroissant = new ArrayList<>();
        chocoladeCroissant.add(ingredientGenerator.getIngredient("chocola"));
        chocoladeCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), chocoladeCroissant, "chocolade croissant"));
        producten.add(new Product("chocolade croissant", "chocoladeCroissantPath", getRecept("chocolade croissant"), 3));

        //koekje
        ArrayList<Item> koekje = new ArrayList<>();
        koekje.add(getTussenIngredient("deeg"));
        koekje.add(ingredientGenerator.getIngredient("chocola"));
        recepten.add(new Recept(stationGenerator.getStation("roller"), koekje, "koekje"));
        producten.add(new Product("koekje", "koekjePath", getRecept("koekje"), 3));

        //hamkaascroissant
        ArrayList<Item> hamKaasCroissant = new ArrayList<>();
        hamKaasCroissant.add(ingredientGenerator.getIngredient("vlees"));
        hamKaasCroissant.add(ingredientGenerator.getIngredient("kaas"));
        hamKaasCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), hamKaasCroissant, "ham kaas croissant"));
        producten.add(new Product("ham kaas croissant", "hamkaascroissantPath", getRecept("ham kaas croissant"), 4));

        //frikandelbroodje
        ArrayList<Item> frikandelBroodje = new ArrayList<>();
        frikandelBroodje.add(getTussenIngredient("bladerdeeg"));
        frikandelBroodje.add(getTussenIngredient("gekruid vlees"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), frikandelBroodje, "frikandelbroodje"));
        producten.add(new Product("frikandelbroodje", "frikandelbroodjePath", getRecept("frikandelbroodje"), 4));

        //pizzabroodje
        ArrayList<Item> pizzabroodje = new ArrayList<>();
        pizzabroodje.add(getTussenIngredient("deeg"));
        pizzabroodje.add(ingredientGenerator.getIngredient("kaas"));
        pizzabroodje.add(ingredientGenerator.getIngredient("vlees"));
        pizzabroodje.add(ingredientGenerator.getIngredient("kruiden"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), pizzabroodje, "pizzabroodje"));
        producten.add(new Product("pizzabroodje", "pizzabroodjePath", getRecept("frikandelbroodje"), 5));

        //appelflap
        ArrayList<Item> appelflap = new ArrayList<>();
        appelflap.add(getTussenIngredient("bladerdeeg"));
        appelflap.add(ingredientGenerator.getIngredient("appel"));
        appelflap.add(ingredientGenerator.getIngredient("kruiden"));
        appelflap.add(ingredientGenerator.getIngredient("suiker"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), appelflap, "appelflap"));
        producten.add(new Product("appelflap", "appelflapPath", getRecept("appelflap"), 5));
        

    }


    public ArrayList<Recept> getRecepten() {
        return recepten;
    }

    public Recept getRecept(String naam) {
        for (Recept recept : recepten) {
            if (naam == recept.naam) {
                return recept;
            }
        }
        return errorRecept;
    }

    public Product getProduct(String naam) {
        for (Product product : producten) {
            if (naam == product.naam) {
                return product;
            }
        }
        return errorProduct;
    }

    public Ingredient getTussenIngredient(String naam) {
        for (Recept recept : tussenIngredients) {
            if (naam == recept.naam) {
                return ingredientGenerator.getIngredient(naam);
            }
        }
        return ingredientGenerator.getIngredient("error");
    } 
}
