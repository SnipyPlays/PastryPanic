package com.github.hanyaeger.pastrypanic.stations.UI.segments;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.CraftingStation;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.Table;
import com.github.hanyaeger.pastrypanic.stations.UI.CraftingInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import com.github.hanyaeger.pastrypanic.stations.UI.TableInterface;
import javafx.scene.input.MouseButton;

public class ResultVakje extends InteractVakje {

    Boolean onVakje = false;

    public ResultVakje(Coordinate2D initialLocation, Station station, Speler speler, GameScene gameScene, StationInterface stationInterface) {
        super(initialLocation, station, speler, 0, gameScene, stationInterface);


        CraftingInterface craftingInterface = (CraftingInterface) stationInterface;
        this.item = craftingInterface.getResultItem();

    }


    @Override
    public void explicitUpdate(long l) {

    }

    @Override
    protected void setupEntities() {
        addEntity(vakje);
        CraftingInterface craftingInterface = (CraftingInterface) stationInterface;
        if (craftingInterface.getResultItem() != null) {
            addEntity(item);
        };
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (item != null) {
            if (speler.getItem(0) == null) {
                speler.setItemLinks(item);
                item.remove();
                station.resetItemList();

            } else if (speler.getItem(1) == null) {
                speler.setItemRechts(item);
                item.remove();
                station.resetItemList();
            }
            game.spawnInterface(new CraftingInterface(location, (CraftingStation) station, speler, game));
            stationInterface.remove();
        }
    }

    @Override
    public void onMouseEntered() {
        onVakje = true;
    }

    @Override
    public void onMouseExited() {
        onVakje = false;
    }
}
