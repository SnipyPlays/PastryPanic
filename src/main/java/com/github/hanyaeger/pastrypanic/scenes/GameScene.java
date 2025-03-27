package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.Speler;
import com.github.hanyaeger.pastrypanic.stations.Toonbank;
import javafx.scene.paint.Color;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var speler = new Speler("sprites/bakkerman.png", new Coordinate2D(getWidth()/2, getHeight()/4));
        addEntity(speler);
        var toonbank = new Toonbank(new Coordinate2D(0, getHeight()*0.75), new Size(getWidth(), 60));
        toonbank.setFill(Color.RED);

        addEntity(toonbank);
    }
}
