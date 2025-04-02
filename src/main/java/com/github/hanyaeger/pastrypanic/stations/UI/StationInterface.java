package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;

public class StationInterface extends CompositeEntity {

    InterfaceBorder border;

    public StationInterface(Coordinate2D initialLocation) {
        super(initialLocation);

        this.border = new InterfaceBorder(initialLocation, new Size(1000, 800));

    }

    @Override
    protected void setupEntities() {
        addEntity(this.border);
    }
}
