package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.InterfaceBorder;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.PlayerVakje;

import java.util.ArrayList;

public class PrullenbakInterface extends StationInterface{

    private InterfaceBorder border;
    private ArrayList<PlayerVakje> playerVakjes = new ArrayList<>();

    public PrullenbakInterface(Coordinate2D initialLocation, Speler speler, GameScene game, Station station) {
        super(initialLocation);
        this.border  = new InterfaceBorder(new Coordinate2D(70, 32), new Size(400, 400));

        for (int i = 0; i < 2; i++) {
            double xPos = 75 + i*75;

            PlayerVakje vakje = new PlayerVakje(new Coordinate2D(xPos, 120), station, speler, i, game, this);
            playerVakjes.add(vakje);
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(border);
        for (int i = 0; i < playerVakjes.size(); i++) {
            addEntity(playerVakjes.get(i));
        }
    }
}
