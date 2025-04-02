package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class KlantCircle extends CircleEntity {
    private final static int Radius = 32;

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    private int happiness;

    public KlantCircle(Coordinate2D initialLocation) {
        super(initialLocation);
        setRadius(Radius);
        happiness = 0;
    }


    public void klantHappiness() {
        if (happiness == 0) {
            setFill(Color.GREEN);
        } else if (happiness == 1) {
            setFill(Color.YELLOW);
        } else if (happiness == 2) {
            setFill(Color.BLUE);
        } else if (happiness == 3) {
            setFill(Color.RED);
        }
    }

}
