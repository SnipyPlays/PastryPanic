package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.GiveStation;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.InterfaceBorder;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.ItemVakje;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.PlayerVakje;

import java.util.ArrayList;

public class SpicerackInterface extends StationInterface {

    InterfaceBorder border;
    ArrayList<ItemVakje> vakjes = new ArrayList<>();
    ArrayList<PlayerVakje> playerVakjes = new ArrayList<>();

    public SpicerackInterface(Coordinate2D location, Speler speler, GameScene game, GiveStation giveStation) {
        super(location);

        this.border = new InterfaceBorder(new Coordinate2D(70, 32), new Size(giveStation.getAantalVakjes() * 170 + 50, 400));

        for (int i = 0; i < giveStation.getAantalVakjes(); i++) {

            double xPos = 75 + i*75;

            ItemVakje vakje = new ItemVakje(new Coordinate2D(xPos, 50), giveStation, speler, i, game, this);
            vakjes.add(vakje);
        }

        for (int i = 0; i < 2; i++) {
            double xPos = 75 + i*75;

            PlayerVakje vakje = new PlayerVakje(new Coordinate2D(xPos, 120), giveStation, speler, i, game, this);
            playerVakjes.add(vakje);
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(border);
        for (ItemVakje vakje : vakjes) {
            addEntity(vakje);
        }
        for (PlayerVakje vakje : playerVakjes) {
            addEntity(vakje);
        }
    }
}
