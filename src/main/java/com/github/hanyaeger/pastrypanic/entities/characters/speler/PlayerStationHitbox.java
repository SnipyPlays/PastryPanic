package com.github.hanyaeger.pastrypanic.entities.characters.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class PlayerStationHitbox extends RectangleEntity implements Collided {

    private List<Collider> collisionList;

    protected PlayerStationHitbox(Coordinate2D initialLocation) {
        super(initialLocation);
        this.setWidth(5);
        this.setHeight(5);
        this.setVisible(false);
    }

    @Override
    public void onCollision(List<Collider> list) {
        this.collisionList = list;
    }

    public List<Collider> getCollisionList() {
        return collisionList;
    }

    public void resetCollisionList() {
        collisionList.clear();
    }

}
