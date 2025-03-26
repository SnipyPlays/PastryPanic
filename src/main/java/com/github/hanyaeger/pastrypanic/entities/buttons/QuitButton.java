package com.github.hanyaeger.pastrypanic.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import javafx.scene.input.MouseButton;

public class QuitButton extends Button{

    PastryPanic game;

    public QuitButton(Coordinate2D initialLocation, String text, PastryPanic game) {
        super(initialLocation, text);
        this.game = game;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.quit();
    }
}
