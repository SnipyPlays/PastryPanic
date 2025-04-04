package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.klant.Klant;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.characters.speler.Speler;
import com.github.hanyaeger.pastrypanic.items.Product;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.StationGenerator;
import com.github.hanyaeger.pastrypanic.stations.CollisionMuur;
import com.github.hanyaeger.pastrypanic.stations.UI.StationInterface;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class GameScene extends DynamicScene implements UpdateExposer{
    public int dayCounter = 1;

    PastryPanic game;

    ProductGenerator productGenerator = new ProductGenerator();
    StationGenerator stationGenerator = new StationGenerator();

    StationInterface currentInterface;

    public GameScene(PastryPanic game) {
        this.game = game;
    }

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

        //bakker maken en toevoeging
        var speler = new Speler("items/bakkertje.png", new Coordinate2D(100, 200), this);
        addEntity(speler);

        //collisionMuur delen maken
        var collisionMuurDown = new CollisionMuur(new Coordinate2D(0, getHeight() * 0.70), new Size(getWidth(), 120));
        collisionMuurDown.setVisible(false);
        var collisionMuurDownLeft = new CollisionMuur(new Coordinate2D(0, getHeight() * 0.55), new Size(getWidth() / 11, 130));
        collisionMuurDownLeft.setVisible(false);
        var collisionMuurDownRight = new CollisionMuur(new Coordinate2D(getWidth() * 0.91, getHeight() * 0.55), new Size(getWidth() / 11, 130));
        collisionMuurDownRight.setVisible(false);
        var collisionMuurTop = new CollisionMuur(new Coordinate2D(0, getHeight() / 11), new Size(getWidth(), getHeight() / 10));
        collisionMuurTop.setVisible(false);
        //collisionMuur adds
        addEntity(collisionMuurDown);
        addEntity(collisionMuurDownLeft);
        addEntity(collisionMuurDownRight);
        addEntity(collisionMuurTop);

        //klanten

        ArrayList<Product> producten = productGenerator.getProducten();
        ArrayList<Product> dayProducts = new ArrayList<>();
        for (Product product : producten) {
            if (dayCounter >= product.getUnlockDay()) {
                dayProducts.add(product);
            }
        }

        Klant[] klanten = new Klant[8];
        Random rand = new Random();
        for (int i = 0; i < klanten.length; i++) {
            klanten[i] = new Klant(new Coordinate2D(160 + i * 128, getHeight() / 1.15),
                    dayProducts.get(rand.nextInt(dayProducts.size())),
                    true,
                    game);
        }

        for (Klant klant : klanten) {
            klant.klantHappiness();
            klant.Visible();
            klant.statusKlant();
            addEntity(klant);
        }

    }

    public void spawnInterface(StationInterface stationInterface) {
        currentInterface = stationInterface;
        addEntity(currentInterface);
    }

    public void removeInterface() {
        currentInterface.remove();
    }

    public void updatePunten() {
        game.punten++;
    }

    @Override
    public void explicitUpdate(long l) {
        if (game.punten >= 5) { //punten op 5 gezet zodat winst laten zien kan worden
            game.setActiveScene(3);

        }
    }
}
