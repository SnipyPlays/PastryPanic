package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.github.hanyaeger.pastrypanic.entities.buttons.SceneButton;
import javafx.scene.paint.Color;

public class MainMenu extends StaticScene {

    PastryPanic game;

    public MainMenu(PastryPanic game) {
        this.game = game;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/PastryPanic.png");

    }

    @Override
    public void setupEntities() {
        var startButton = new SceneButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Play Game",
                3,
                game

        );
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);
    }
}
