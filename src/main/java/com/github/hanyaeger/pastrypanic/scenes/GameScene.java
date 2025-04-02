package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.Product;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.stations.Station;
import com.github.hanyaeger.pastrypanic.stations.StationGenerator;
//import com.github.hanyaeger.pastrypanic.stations.Toonbank;
import com.github.hanyaeger.pastrypanic.stations.CollisionMuur;

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
        var speler = new Speler("sprites/bakkerman.png", new Coordinate2D(getWidth()/2, getHeight()/4));
        addEntity(speler);

        //collisionMuur delen maken
        var collisionMuurDown = new CollisionMuur(new Coordinate2D(0, getHeight()*0.70), new Size(getWidth(), 120));
        collisionMuurDown.setVisible(false);
        var collisionMuurDownLeft= new CollisionMuur(new Coordinate2D(0, getHeight()*0.55), new Size(getWidth()/11, 130));
        collisionMuurDownLeft.setVisible(false);
        var collisionMuurDownRight = new CollisionMuur(new Coordinate2D(getWidth()*0.91, getHeight()*0.55), new Size(getWidth()/11, 130));
        collisionMuurDownRight.setVisible(false);
        var collisionMuurTop = new CollisionMuur(new Coordinate2D(0, getHeight()/11), new Size(getWidth(), getHeight()/10));
        collisionMuurTop.setVisible(false);
        //collisionMuur adds
        addEntity(collisionMuurDown);
        addEntity(collisionMuurDownLeft);
        addEntity(collisionMuurDownRight);
        addEntity(collisionMuurTop);

        var croissant = productGenerator.createProduct("apple");
        addEntity(croissant);

        croissant.move();

        var croissant2 = productGenerator.getProduct("broodje");
        addEntity(croissant2);


    }
}
