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
import com.github.hanyaeger.pastrypanic.stations.DeleteStation;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.Table;
import com.github.hanyaeger.pastrypanic.stations.UI.CraftingInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.TableInterface;
import javafx.scene.input.MouseButton;

public class PlayerVakje extends InteractVakje {

    Boolean opVakje = false;
    int slot;

    public PlayerVakje(Coordinate2D initialLocation, Station station, Speler speler, int slot, GameScene gameScene, StationInterface stationInterface) {
        super(initialLocation, station, speler, slot, gameScene, stationInterface);

        this.slot = slot;

        loadItem();

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
            if(item != null) {
                if (station instanceof Table) {
                    if (station.getItemList().size() < station.aantalVakjes) {
                        station.addToItemList(item.naam);
                        removePlayerItem();
                    }
                    game.spawnInterface(new TableInterface(location, speler, (Table) station, game));
                    stationInterface.remove();
                } else if (station instanceof DeleteStation) {
                    removePlayerItem();
                } else if (station instanceof CraftingStation) {
                    if (station.getItemList().size() < station.aantalVakjes) {
                        station.addToItemList(item.naam);
                        removePlayerItem();
                    }
                    game.spawnInterface(new CraftingInterface(location, (CraftingStation) station, speler, game));
                    stationInterface.remove();
                }
            }

        }
    }

    public void removePlayerItem() {
        item.remove();
        item = null;
        speler.getItem(slot).remove();
        speler.removeItem(slot);

        if (slot == 0) {
            speler.setItemLinks(null);
        }
        if (slot == 1) {
            speler.setItemRechts(null);
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

    public void loadItem() {
        if (slot == 0) {
            if (speler.getItem(0) != null) {
                String itemString = speler.getItem(0).naam;
                this.item = productGenerator.createProduct(itemString, new Size(75, 75));
                item.setAnchorLocationX(location.getX() + 10);
                item.setAnchorLocationY(location.getY() + 10);
            }
        } else if (slot == 1) {
            if (speler.getItem(1) != null) {
                String itemString = speler.getItem(1).naam;
                this.item = productGenerator.createProduct(itemString, new Size(75, 75));
                item.setAnchorLocationX(location.getX() + 10);
                item.setAnchorLocationY(location.getY() + 10);
            }
        }
    }
}
