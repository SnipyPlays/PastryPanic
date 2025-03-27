package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.pastrypanic.entities.characters.Speler;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var speler = new Speler("sprites/hanny.png", new Coordinate2D(getWidth()/2, getHeight()/2));
        addEntity(speler);
    }
}
