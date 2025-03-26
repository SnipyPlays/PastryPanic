package com.github.hanyaeger.pastrypanic;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.pastrypanic.scenes.EndScene;
import com.github.hanyaeger.pastrypanic.scenes.EndlessMode;
import com.github.hanyaeger.pastrypanic.scenes.MainGame;
import com.github.hanyaeger.pastrypanic.scenes.MainMenu;

public class PastryPanic extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Pastry Panic");
        setSize(new Size(1280, 720));
    }

    @Override
    public void setupScenes() {
        addScene(0, new MainMenu(this));
        addScene(1, new MainGame(this));
        addScene(2, new EndlessMode(this));
        addScene(3, new EndScene(this));
    }
}
