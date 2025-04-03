package com.github.hanyaeger.pastrypanic.entities.characters.klant;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class KlantCircle extends DynamicCircleEntity {
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
        switch (happiness) {
            case 0:
                setFill(Color.GREEN);
                break;
            case 1:
                setFill(Color.YELLOW);
                break;
            case 2:
                setFill(Color.BLUE);
                break;
            case 3:
                setFill(Color.RED);
                break;
        }
    }

    public int getHappiness() {
        return happiness;
    }

}
