package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;

public abstract class StationInterface extends CompositeEntity {

    public StationInterface(Coordinate2D initialLocation) {
        super(initialLocation);

    }

    @Override
    protected abstract void setupEntities();
}
