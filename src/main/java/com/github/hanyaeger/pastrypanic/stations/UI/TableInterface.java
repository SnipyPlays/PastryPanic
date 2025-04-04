package com.github.hanyaeger.pastrypanic.stations.UI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Table;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.InterfaceBorder;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.ItemVakje;
import com.github.hanyaeger.pastrypanic.stations.UI.segments.PlayerVakje;

import java.util.ArrayList;

public class TableInterface extends StationInterface {

    private InterfaceBorder interfaceBorder;
    private ArrayList<ItemVakje> vakjes = new ArrayList<>();
    private ArrayList<PlayerVakje> playerVakjes = new ArrayList<>();

    //bij spawn van table interface
    public TableInterface(Coordinate2D initialLocation, Speler speler, Table table, GameScene game) {
        super(initialLocation);

        //maak groot vak
        interfaceBorder = new InterfaceBorder(new Coordinate2D(70, 32), new Size(400, 400));

        //bepaal aantal vakjes en maak deze
        table.aantalVakjes = 2;
        for (int i = 0; i < table.aantalVakjes; i++) {

            double xPos = 75 + i*75;

            ItemVakje vakje = new ItemVakje(new Coordinate2D(xPos, 50), table, speler, i, game, this);
            vakjes.add(vakje);
        }

        for (int i = 0; i < 2; i++) {
            double xPos = 75 + i*75;

            PlayerVakje vakje = new PlayerVakje(new Coordinate2D(xPos, 120), table, speler, i, game, this);
            playerVakjes.add(vakje);
        }
    }

    @Override
    protected void setupEntities() {
        addEntity(interfaceBorder);
        for (ItemVakje vakje : vakjes) {
            addEntity(vakje);
        }
        for (PlayerVakje playerVakje : playerVakjes) {
            addEntity(playerVakje);
        }
    }


}
