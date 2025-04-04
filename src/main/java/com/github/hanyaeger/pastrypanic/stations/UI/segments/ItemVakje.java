package com.github.hanyaeger.pastrypanic.stations.UI.segments;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.CraftingStation;
import com.github.hanyaeger.pastrypanic.stations.GiveStation;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.Table;
import com.github.hanyaeger.pastrypanic.stations.UI.CraftingInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.SpicerackInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.TableInterface;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;

public class ItemVakje extends InteractVakje {

    Boolean opVakje = false;

    public ItemVakje(Coordinate2D initialLocation, Station station, Speler speler, Integer nummer, GameScene gameScene, StationInterface stationInterface) {
        super(initialLocation, station, speler, nummer, gameScene, stationInterface);

        ArrayList<String> itemList = station.getItemList();
        if (itemList.size() > nummer) {
            String itemNaam = itemList.get(nummer);

            this.item = productGenerator.createProduct(itemNaam, new Size(75, 75));
            item.setAnchorLocationX(initialLocation.getX() + 10);
            item.setAnchorLocationY(initialLocation.getY() + 10);
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(vakje);
        if (item != null) {
            addEntity(item);
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (opVakje) {
            if (item != null) {
                if (station instanceof Table) {
                    if (speler.getItem(0) == null) {
                        speler.setItemLinks(item);
                        item.remove();
                        station.removeItemFromList(item);

                    } else if (speler.getItem(1) == null) {
                        speler.setItemRechts(item);
                        item.remove();
                        station.removeItemFromList(item);
                    }
                    game.spawnInterface(new TableInterface(location, speler, (Table) station, game));
                    stationInterface.remove();

                } else if (station instanceof GiveStation) {
                    if (speler.getItem(0) == null) {
                        speler.setItemLinks(item);

                    } else if (speler.getItem(1) == null) {
                        speler.setItemRechts(item);
                    }
                    game.spawnInterface(new SpicerackInterface(location, speler, game, (GiveStation) station));
                    stationInterface.remove();
                } else if (station instanceof CraftingStation) {
                    if (speler.getItem(0) == null) {
                        speler.setItemLinks(item);
                        item.remove();
                        station.removeItemFromList(item);

                    } else if (speler.getItem(1) == null) {
                        speler.setItemRechts(item);
                        item.remove();
                        station.removeItemFromList(item);
                    }
                    game.spawnInterface(new CraftingInterface(location, (CraftingStation) station, speler, game));
                    stationInterface.remove();
                }



            }
        }
    }

    @Override
    public void onMouseEntered() {
        opVakje = true;
    }

    @Override
    public void onMouseExited() {
        opVakje = false;
    }

    @Override
    public void explicitUpdate(long l) {
        setupEntities();
    }
}
