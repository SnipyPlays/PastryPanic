package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.Speler;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.stations.Station;
import com.github.hanyaeger.pastrypanic.stations.StationGenerator;
import com.github.hanyaeger.pastrypanic.stations.Toonbank;

public class GameScene extends DynamicScene {

    ProductGenerator productGenerator = new ProductGenerator();
    StationGenerator stationGenerator = new StationGenerator();

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameScene background.png");
    }

    @Override
    public void setupEntities() {

        //render stations
        for (Station station : stationGenerator.getStations()) {
            addEntity(station);
        }
//        var oven = stationGenerator.getStation("oven");
//        addEntity(oven);

        //bakker maken en toevoeging
        var speler = new Speler("items/bakkerman.png", new Coordinate2D(getWidth()/2, getHeight()/4));
        addEntity(speler);

        //toonbank delen maken
        var toonbank = new Toonbank(new Coordinate2D(0, getHeight()*0.70), new Size(getWidth(), 120));
        toonbank.setVisible(false);
        var toonbank2 = new Toonbank(new Coordinate2D(0, getHeight()*0.55), new Size(getWidth()/11, 130));
        toonbank2.setVisible(false);
        var toonbank3 = new Toonbank(new Coordinate2D(getWidth()*0.91, getHeight()*0.55), new Size(getWidth()/11, 130));
        toonbank3.setVisible(false);
        //toonbank adds
        addEntity(toonbank);
        addEntity(toonbank2);
        addEntity(toonbank3);

        var croissant = productGenerator.createProduct("apple");
        addEntity(croissant);

        croissant.move();

        var croissant2 = productGenerator.getProduct("broodje");
        addEntity(croissant2);



    }
}
