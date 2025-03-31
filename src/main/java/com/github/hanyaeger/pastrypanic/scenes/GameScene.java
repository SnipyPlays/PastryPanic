package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.Speler;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.Product;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.stations.Toonbank;
import javafx.scene.paint.Color;

public class GameScene extends DynamicScene {

    ProductGenerator productGenerator = new ProductGenerator();

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gameScene background.png");
    }

    @Override
    public void setupEntities() {
        var speler = new Speler("sprites/bakkerman.png", new Coordinate2D(getWidth()/2, getHeight()/4));
        addEntity(speler);
        var toonbank = new Toonbank(new Coordinate2D(0, getHeight()*0.70), new Size(getWidth(), 120));
        toonbank.setFill(Color.RED);

        addEntity(toonbank);

        var croissant = productGenerator.createProduct("croissant");
        addEntity(croissant);

        croissant.move();

        var croissant2 = productGenerator.getProduct("croissant");
        addEntity(croissant2);


    }
}
