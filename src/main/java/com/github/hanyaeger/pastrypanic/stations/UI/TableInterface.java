package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import javafx.stage.PopupWindow;

import java.util.ArrayList;

public class TableInterface extends StationInterface {

    InterfaceBorder interfaceBorder;
    Integer aantalVakjes;
    ArrayList<ItemVakje> vakjes = new ArrayList<>();

    public TableInterface(Coordinate2D initialLocation) {
        super(initialLocation);

        interfaceBorder = new InterfaceBorder(new Coordinate2D(70, 32), new Size(400, 400));

        this.aantalVakjes = 2;
        for (int i = 0; i < aantalVakjes; i++) {

            double xPos = 75 + i*75;

            ItemVakje vakje = new ItemVakje(new Coordinate2D(xPos, 50));
            vakjes.add(vakje);
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(interfaceBorder);
        for (ItemVakje vakje : vakjes) {
            addEntity(vakje);
        }
    }
}
