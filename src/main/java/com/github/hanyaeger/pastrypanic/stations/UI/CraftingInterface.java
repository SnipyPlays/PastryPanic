package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.*;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.CraftingStation;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.InterfaceBorder;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.ItemVakje;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.PlayerVakje;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.ResultVakje;

import java.util.ArrayList;

public class CraftingInterface extends StationInterface{

    private InterfaceBorder border;
    private ArrayList<ItemVakje> vakjes = new ArrayList<>();
    private ArrayList<PlayerVakje> playerVakjes = new ArrayList<>();
    private ProductGenerator productGenerator = new ProductGenerator();
    ArrayList<Product> producten;
    Item resultItem;
    private ResultVakje resultVakje;

    public CraftingInterface(Coordinate2D initialLocation, CraftingStation station, Speler speler, GameScene game) {
        super(initialLocation);

        border = new InterfaceBorder(new Coordinate2D(70, 32), new Size(1000, 400));

        for (int i = 0; i < station.aantalVakjes; i++) {

            double xPos = 75 + i*75;

            ItemVakje vakje = new ItemVakje(new Coordinate2D(xPos, 50), station, speler, i, game, this);
            vakjes.add(vakje);
        }

        for (int i = 0; i < 2; i++) {
            double xPos = 75 + i*75;

            PlayerVakje vakje = new PlayerVakje(new Coordinate2D(xPos, 120), station, speler, i, game, this);
            playerVakjes.add(vakje);
        }


        producten = productGenerator.getProducten();
        //ArrayList<Ingredient> tussenIngredienten = productGenerator.tussenIngredients;
        ArrayList<String> itemList = station.getItemList();
        itemList.sort(null);


        for (Product product : producten) {
            Recept huidigRecept = productGenerator.getRecept(product.naam);
            ArrayList<String> currentRecept = huidigRecept.getIngredients();
            currentRecept.sort(null);
            if (currentRecept.equals(itemList)) {
                resultItem = product;
                System.out.println(resultItem.naam);
            }

        }
        resultVakje = new ResultVakje(new Coordinate2D(800, 240), station, speler, game, this);
    }

    public Item getResultItem() {
        return resultItem;
    }

    @Override
    protected void setupEntities() {
        addEntity(border);
        for (ItemVakje vakje : vakjes) {
            addEntity(vakje);
        }
        for (PlayerVakje playerVakje : playerVakjes) {
            addEntity(playerVakje);
        }
        addEntity(resultVakje);
    }
}
