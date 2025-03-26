package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import javafx.scene.paint.Color;

public class EndScene extends StaticScene {

    PastryPanic game;


    public EndScene(PastryPanic game) {
        this.game = game;
    }


    @Override
    public void setupScene() {
        setBackgroundColor(Color.GREEN);
    }

    @Override
    public void setupEntities() {

    }
}
