package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Speler extends Character implements KeyListener {
    public Speler(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setMotion(3,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(3,90d);
        } else if(pressedKeys.contains(KeyCode.UP)){
            setMotion(3,180d);
        } else if(pressedKeys.contains(KeyCode.DOWN)){
            setMotion(3,0d);
        }  else if(pressedKeys.contains(KeyCode.D)){
            setMotion(3,90d);
        }
        else if(pressedKeys.contains(KeyCode.A)){
            setMotion(3,270d);
        }
        else if(pressedKeys.contains(KeyCode.W)){
            setMotion(3,180d);
        }
        else if(pressedKeys.contains(KeyCode.S)){
            setMotion(3,0d);
        }
        else if (pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }
}
