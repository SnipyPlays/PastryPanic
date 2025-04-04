package com.github.hanyaeger.pastrypanic.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.pastrypanic.PastryPanic;
import com.github.hanyaeger.pastrypanic.entities.buttons.QuitButton;
import com.github.hanyaeger.pastrypanic.entities.buttons.SceneButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndScene extends StaticScene {

    PastryPanic game;


    public EndScene(PastryPanic game) {
        this.game = game;
    }


    @Override
    public void setupScene() {
        setBackgroundColor(Color.GREEN);
    }

    @Override
    public void setupEntities() {

        //quitgame
        var quitButtonEnd = new QuitButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 6 * 4),
               "Quit Game",
                game);
        quitButtonEnd.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(quitButtonEnd);

        //text
        var eindText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/5), "Eind Spel");
        eindText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        eindText.setFill(Color.WHITE);
        eindText.setFont(Font.font("Helvetica", FontWeight.BOLD, 200));
        eindText.setStrokeColor(Color.BLACK);
        addEntity(eindText);

        var puntenText = new TextEntity(new Coordinate2D(getWidth()/2, getHeight()/5 + 200), "Punten: " + game.punten);
        puntenText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        puntenText.setFill(Color.WHITE);
        puntenText.setFont(Font.font("Helvetica", FontWeight.BOLD, 200));
        puntenText.setStrokeColor(Color.BLACK);
        addEntity(puntenText);
    }
}
