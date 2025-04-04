package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.buttons.QuitButton;
import com.github.hanyaeger.pastrypanic.entities.buttons.SceneButton;

public class MainMenu extends StaticScene {

    private PastryPanic game;

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
                new Coordinate2D(getWidth() / 2, getHeight() / 6 * 2),
                "Play Game",
                1,
                game

        );
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(startButton);

        var endlessButton = new SceneButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 6 * 3),
                "Endless",
                2,
                game

        );
        endlessButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(endlessButton);


        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 6 * 4),
                "Quit Game",
                game
        );
        quitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitButton);
    }
}
