package com.github.hanyaeger.pastrypanic.items;

import com.github.hanyaeger.pastrypanic.stations.StationGenerator;

import java.util.ArrayList;

public class ProductGenerator {

    private StationGenerator stationGenerator = new StationGenerator();
    private IngredientGenerator ingredientGenerator = new IngredientGenerator();

    public ArrayList<Recept> recepten = new ArrayList<>();
    public ArrayList<Recept> tussenIngredients = new ArrayList<>();
    public Recept errorRecept = new Recept(stationGenerator.getStation("error"), new ArrayList<Item>(), "error");
    public ArrayList<Product> producten = new ArrayList<>();
    public Product errorProduct = new Product("error", "errorPath", errorRecept, 0);

    public ProductGenerator() {
        
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
        producten.add(new Product("muffin", "items/muffin.png", getRecept("muffin"), 1));

        //wafel
        ArrayList<Item> wafel = new ArrayList<>();
        wafel.add(getTussenIngredient("deeg"));
        wafel.add(ingredientGenerator.getIngredient("suiker"));
        recepten.add(new Recept(stationGenerator.getStation("wafelijzer"), wafel, "wafel"));
        producten.add(new Product("wafel", "items/wafel.png", getRecept("wafel"), 1));

        //hard broodje
        ArrayList<Item> broodje = new ArrayList<>();
        broodje.add(getTussenIngredient("deeg"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), broodje, "broodje"));
        producten.add(new Product("broodje", "items/broodje.png", getRecept("broodje"), 1));

        //worstenbroodje
        ArrayList<Item> worstenbroodje = new ArrayList<>();
        worstenbroodje.add(getTussenIngredient("deeg"));
        worstenbroodje.add(ingredientGenerator.getIngredient("vlees"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), worstenbroodje, "worstenbroodje"));
        producten.add(new Product("worstenbroodje", "items/worstenbroodje.png", getRecept("worstenbroodje"), 1));

        //brood
        ArrayList<Item> brood = new ArrayList<>();
        brood.add(getTussenIngredient("deeg"));
        brood.add(getTussenIngredient("deeg"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), brood, "brood"));
        producten.add(new Product("brood", "items/brood.png", getRecept("brood"), 1));

        //chocolademuffin
        ArrayList<Item> chocoladeMuffin = new ArrayList<>();
        chocoladeMuffin.add(getTussenIngredient("deeg"));
        chocoladeMuffin.add(ingredientGenerator.getIngredient("suiker"));
        chocoladeMuffin.add(ingredientGenerator.getIngredient("chocolade"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), chocoladeMuffin, "chocolade muffin"));
        producten.add(new Product("chocolade muffin", "items/chocolademuffin.png", getRecept("chocolade muffin"), 2));

        //croissant
        ArrayList<Item> croissant = new ArrayList<>();
        croissant.add(getProduct("hard broodje"));
        recepten.add(new Recept(stationGenerator.getStation("baguettematic"), croissant, "croissant"));
        producten.add(new Product("croissant", "items/croissant.png", getRecept("croissant"), 2));

        //baguette
        ArrayList<Item> baguette = new ArrayList<>();
        baguette.add(getProduct("brood"));
        recepten.add(new Recept(stationGenerator.getStation("baguettematic"), baguette, "baguette"));
        producten.add(new Product("baguette", "items/baguette.png", getRecept("baguette"), 2));

        //kaascroissant
        ArrayList<Item> kaasCroissant = new ArrayList<>();
        kaasCroissant.add(ingredientGenerator.getIngredient("kaas"));
        kaasCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), kaasCroissant, "kaas croissant"));
        producten.add(new Product("kaas croissant", "items/kaascroissant.png", getRecept("kaas croissant"), 3));

        //chocoladecroissant
        ArrayList<Item> chocoladeCroissant = new ArrayList<>();
        chocoladeCroissant.add(ingredientGenerator.getIngredient("chocola"));
        chocoladeCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), chocoladeCroissant, "chocolade croissant"));
        producten.add(new Product("chocolade croissant", "items/chocoladecroissant.png", getRecept("chocolade croissant"), 3));

        //koekje
        ArrayList<Item> koekje = new ArrayList<>();
        koekje.add(getTussenIngredient("deeg"));
        koekje.add(ingredientGenerator.getIngredient("chocola"));
        recepten.add(new Recept(stationGenerator.getStation("roller"), koekje, "koekje"));
        producten.add(new Product("koekje", "items/koekje.png", getRecept("koekje"), 3));

        //hamkaascroissant
        ArrayList<Item> hamKaasCroissant = new ArrayList<>();
        hamKaasCroissant.add(ingredientGenerator.getIngredient("vlees"));
        hamKaasCroissant.add(ingredientGenerator.getIngredient("kaas"));
        hamKaasCroissant.add(getProduct("croissant"));
        recepten.add(new Recept(stationGenerator.getStation("crafter"), hamKaasCroissant, "ham kaas croissant"));
        producten.add(new Product("ham kaas croissant", "items/hamkaascroissant.png", getRecept("ham kaas croissant"), 4));

        //frikandelbroodje
        ArrayList<Item> frikandelBroodje = new ArrayList<>();
        frikandelBroodje.add(getTussenIngredient("bladerdeeg"));
        frikandelBroodje.add(getTussenIngredient("gekruid vlees"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), frikandelBroodje, "frikandelbroodje"));
        producten.add(new Product("frikandelbroodje", "items/frikandelbroodje.png", getRecept("frikandelbroodje"), 4));

        //pizzabroodje
        ArrayList<Item> pizzabroodje = new ArrayList<>();
        pizzabroodje.add(getTussenIngredient("deeg"));
        pizzabroodje.add(ingredientGenerator.getIngredient("kaas"));
        pizzabroodje.add(ingredientGenerator.getIngredient("vlees"));
        pizzabroodje.add(ingredientGenerator.getIngredient("kruiden"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), pizzabroodje, "pizzabroodje"));
        producten.add(new Product("pizzabroodje", "items/pizzabroodje.png", getRecept("frikandelbroodje"), 5));

        //appelflap
        ArrayList<Item> appelflap = new ArrayList<>();
        appelflap.add(getTussenIngredient("bladerdeeg"));
        appelflap.add(ingredientGenerator.getIngredient("appel"));
        appelflap.add(ingredientGenerator.getIngredient("kruiden"));
        appelflap.add(ingredientGenerator.getIngredient("suiker"));
        recepten.add(new Recept(stationGenerator.getStation("oven"), appelflap, "appelflap"));
        producten.add(new Product("appelflap", "items/appelflap.png", getRecept("appelflap"), 5));
        

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

    public ArrayList<Product> getProducten() {
        return producten;
    }

    public Ingredient getTussenIngredient(String naam) {
        for (Recept recept : tussenIngredients) {
            if (naam == recept.naam) {
                return ingredientGenerator.getIngredient(naam);
            }
        }
        return ingredientGenerator.getIngredient("error");
    }

    public Product createProduct(String naam) {
        String path = "items/" + naam + ".png";
        Product product = new Product(naam, path, getRecept(naam), 1);
        return product;
    }
}
