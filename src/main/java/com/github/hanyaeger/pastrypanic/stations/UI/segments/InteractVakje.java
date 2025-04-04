package com.github.hanyaeger.pastrypanic.stations.UI.segments;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import javafx.scene.input.MouseButton;

public abstract class InteractVakje extends CompositeEntity implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener, UpdateExposer {

    public Coordinate2D location;
    public Station station;
    public Speler speler;
    public Integer nummer;
    public GameScene game;
    public StationInterface stationInterface;
    public ProductGenerator productGenerator = new ProductGenerator();
    public Vakje vakje;
    public Item item;

    public InteractVakje(Coordinate2D initialLocation, Station station, Speler speler, Integer nummer, GameScene gameScene, StationInterface stationInterface) {
        super(initialLocation);

        this.location = initialLocation;
        this.station = station;
        this.speler = speler;
        this.nummer = nummer;
        this.game = gameScene;
        this.stationInterface = stationInterface;
        this.vakje = new Vakje(initialLocation);

    }

    @Override
    public abstract void explicitUpdate(long l);

    @Override
    protected abstract void setupEntities();

    @Override
    public abstract void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);

    @Override
    public abstract void onMouseEntered();

    @Override
    public abstract void onMouseExited();
}
