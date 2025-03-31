package com.github.hanyaeger.pastrypanic.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Speler extends Character implements KeyListener, SceneBorderTouchingWatcher, Collided {
    private KeyCode lastkey;

    public Speler(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            lastkey = KeyCode.LEFT;
            setMotion(3, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            lastkey = KeyCode.RIGHT;
            setMotion(3, 90d);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            lastkey = KeyCode.UP;
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            lastkey = KeyCode.DOWN;
            setMotion(3, 0d);
        } else if (pressedKeys.contains(KeyCode.D)) {
            lastkey = KeyCode.RIGHT;
            setMotion(3, 90d);
        } else if (pressedKeys.contains(KeyCode.A)) {
            lastkey = KeyCode.LEFT;
            setMotion(3, 270d);
        } else if (pressedKeys.contains(KeyCode.W)) {
            lastkey = KeyCode.UP;
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            lastkey = KeyCode.DOWN;
            setMotion(3, 0d);
        } else {
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        setSpeed(0);
        switch (lastkey) {
            case LEFT:
                super.setAnchorLocationX(getAnchorLocation().getX() + 3);
                break;
            case RIGHT:
                super.setAnchorLocationX(getAnchorLocation().getX() - 3);
                break;
            case UP:
                super.setAnchorLocationY(getAnchorLocation().getY() + 3);
                break;
            case DOWN:
                super.setAnchorLocationY(getAnchorLocation().getY() - 3);
                break;
        }
    }
}
