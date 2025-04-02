package com.github.hanyaeger.pastrypanic.entities.characters.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.pastrypanic.stations.IBlocker;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.Station.StationBounding;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Speler extends DynamicCompositeEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {
    private KeyCode lastkey;
    private KeyCode lastNorthKey;

    private PlayerSprite playerSprite;
    private PlayerHitbox playerHitbox;
    private PlayerStationHitbox playerStationHitbox;

    private int playerSpeed;

    public Speler(String resource, Coordinate2D initialLocation) {
        super(initialLocation);
        this.playerSprite = new PlayerSprite(resource, initialLocation);
        this.playerHitbox = new PlayerHitbox(initialLocation);

        double newX = initialLocation.getX() + 40;
        double newY = initialLocation.getY() + 10;
        Coordinate2D newLocation = new Coordinate2D(newX, newY);

        this.playerStationHitbox = new PlayerStationHitbox(newLocation);

        this.playerSpeed = 5;
        System.out.println("speler gemaakt");
    }

    @Override
    protected void setupEntities() {
        addEntity(playerSprite);
        addEntity(playerHitbox);
        addEntity(playerStationHitbox);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A)) {
            lastkey = KeyCode.LEFT;
            setMotion(playerSpeed, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D)) {
            lastkey = KeyCode.RIGHT;
            setMotion(playerSpeed, 90d);
        } else if (pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W)) {
            lastkey = KeyCode.UP;
            setMotion(playerSpeed, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S)) {
            lastkey = KeyCode.DOWN;
            setMotion(playerSpeed, 0d);
        } else if (pressedKeys.contains(KeyCode.F)) {
            for (Collider c : playerStationHitbox.getCollisionList()) {
                if (c instanceof StationBounding s) {
                    Station station = s.getStation();
                    station.doStationAction();
                    break;
                } else {
                    System.out.println(c);
                }
            }
        } else {
            setSpeed(0);
            playerStationHitbox.resetCollisionList();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(-100);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 100);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof IBlocker b) {
                if (b.getCollision()) {
                    setSpeed(0);
                    switch (lastkey) {
                        case LEFT:
                            super.setAnchorLocationX(getAnchorLocation().getX() + playerSpeed);
                            break;
                        case RIGHT:
                            super.setAnchorLocationX(getAnchorLocation().getX() - playerSpeed);
                            break;
                        case UP:
                            super.setAnchorLocationY(getAnchorLocation().getY() + playerSpeed);
                            break;
                        case DOWN:
                            super.setAnchorLocationY(getAnchorLocation().getY() - playerSpeed);
                            break;
                    }
                }
            }
        }

    }
}
