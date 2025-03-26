package com.github.hanyaeger.pastrypanic.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Button extends TextEntity implements MouseExitListener, MouseEnterListener, MouseButtonPressedListener {


    public Button(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setFill(Color.WHITE);
        setFont(Font.font("Helvetica", FontWeight.BOLD, 70));
        setStrokeColor(Color.BLACK);
        setStrokeWidth(3);
    }

    @Override
    public abstract void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);

    @Override
    public void onMouseEntered() {
        setFill(Color.GRAY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.WHITE);
        setCursor(Cursor.DEFAULT);
    }
}
