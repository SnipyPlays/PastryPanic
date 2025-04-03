package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.InterfaceBorder;

public class CraftingInterface extends StationInterface{

    InterfaceBorder border;

    public CraftingInterface(Coordinate2D initialLocation) {
        super(initialLocation);

        border = new InterfaceBorder(new Coordinate2D(70, 32), new Size(1000, 400));
    }

    @Override
    protected void setupEntities() {
        addEntity(border);
    }
}
