package com.github.hanyaeger.pastrypanic.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import javafx.scene.input.MouseButton;

public class SceneButton extends Button{

    private int gekozenScene;
    private PastryPanic game;

    public SceneButton(Coordinate2D initialLocation, String text, Integer gekozenScene, PastryPanic game) {
        super(initialLocation, text);
        this.gekozenScene = gekozenScene;
        this.game = game;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.setActiveScene(gekozenScene);
    }
}
