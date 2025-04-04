package com.github.hanyaeger.pastrypanic.entities.characters.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.IBlocker;
import com.github.hanyaeger.pastrypanic.entities.characters.klant.KlantHitbox;
import com.github.hanyaeger.pastrypanic.items.Item;
import com.github.hanyaeger.pastrypanic.items.ProductGenerator;
import com.github.hanyaeger.pastrypanic.scenes.GameScene;
import com.github.hanyaeger.pastrypanic.stations.Station.Station;
import com.github.hanyaeger.pastrypanic.stations.Station.StationBounding;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Speler extends DynamicCompositeEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {
    private KeyCode lastkey;

    private PlayerSprite playerSprite;
    private PlayerHitbox playerHitbox;
    private PlayerStationHitbox playerStationHitbox;

    private PastryPanic game;
    private GameScene gameScene;
    private ProductGenerator productGenerator;

    private int playerSpeed;

    private Item itemLinks;
    private Item itemRechts;

    private boolean interfaceOpen = false;

    public Speler(String resource, Coordinate2D initialLocation, PastryPanic game, GameScene gameScene) {
        super(initialLocation);

        this.game = game;
        this.gameScene = gameScene;
        this.productGenerator = new ProductGenerator();

        //Composite Player
        this.playerSprite = new PlayerSprite(resource, initialLocation);
        this.playerHitbox = new PlayerHitbox(initialLocation);

        double newX = initialLocation.getX() + 40;
        double newY = initialLocation.getY() + 10;
        Coordinate2D newLocation = new Coordinate2D(newX, newY);

        this.playerStationHitbox = new PlayerStationHitbox(newLocation);

        this.itemLinks = productGenerator.createProduct("muffin");
        this.itemLinks.setAnchorLocationX(100);
        this.itemLinks.setAnchorLocationY(240);

        this.itemRechts = productGenerator.createProduct("muffin");
        this.itemRechts.setAnchorLocationX(170);
        this.itemRechts.setAnchorLocationY(240);

        this.playerSpeed = 5;
    }

    @Override
    protected void setupEntities() {
        addEntity(playerSprite);
        addEntity(playerHitbox);
        addEntity(playerStationHitbox);
        if (itemLinks != null) {
            addEntity(itemLinks);
        }
        if (itemRechts != null) {
            addEntity(itemRechts);
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT) || pressedKeys.contains(KeyCode.A) && !interfaceOpen) {
            lastkey = KeyCode.LEFT;
            setMotion(playerSpeed, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT) || pressedKeys.contains(KeyCode.D) && !interfaceOpen) {
            lastkey = KeyCode.RIGHT;
            setMotion(playerSpeed, 90d);
        } else if (pressedKeys.contains(KeyCode.UP) || pressedKeys.contains(KeyCode.W) && !interfaceOpen) {
            lastkey = KeyCode.UP;
            setMotion(playerSpeed, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN) || pressedKeys.contains(KeyCode.S) && !interfaceOpen) {
            lastkey = KeyCode.DOWN;
            setMotion(playerSpeed, 0d);


        } else if (pressedKeys.contains(KeyCode.F)) {
            for (Collider c : playerStationHitbox.getCollisionList()) {
                if (c instanceof StationBounding s && !interfaceOpen) {
                    Station station = s.getStation();
                    interfaceOpen = true;
                    station.doStationAction(gameScene, this); //POLYMORFIE LETS GOOOOO
                    break;
                } else if (c instanceof KlantHitbox k) {
                    if (!k.getklant().getGeholpen()) {
                        if (itemLinks != null) {
                            if (itemLinks.naam == k.getklant().getWantsProduct().naam) {
                                k.getklant().setGeholpen(true);
                                itemLinks.remove();
                                removeItem(0);
                                gameScene.updatePunten();
                            }
                        } else if (itemRechts != null) {
                            if (itemRechts.naam == k.getklant().getWantsProduct().naam) {
                                k.getklant().setGeholpen(true);
                                itemRechts.remove();
                                removeItem(1);
                                gameScene.updatePunten();
                            }
                        }
                    }
                } else {
                    System.out.println(c);
                }
            }
        } else if (pressedKeys.contains(KeyCode.ESCAPE) && interfaceOpen) {
            gameScene.removeInterface();
            interfaceOpen = false;

        } else {
            setSpeed(0);
            if (playerStationHitbox.getCollisionList() != null) {
                playerStationHitbox.resetCollisionList();
            }
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

    public Item getItem(int slot) {
        if (slot == 0) {
            return this.itemLinks;
        } else if (slot == 1) {
            return this.itemRechts;
        }
        return null;
    }

    public void removeItem(int slot) {
        if (slot == 0) {
            this.itemLinks = null;
        } else {
            this.itemRechts = null;
        }
    }

    public void setItemLinks(Item item) {

        if (item != null) {
            this.itemLinks = productGenerator.createProduct(item.naam);
            this.addEntity(this.itemLinks);
        }

    }

    public void setItemRechts(Item item) {
        if (item != null) {
            this.itemRechts = productGenerator.createProduct(item.naam);
            addEntity(this.itemRechts);
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof IBlocker b) {
                if (b.getCollision()) {
                    setSpeed(0);
                    if (lastkey != null) {
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
}
