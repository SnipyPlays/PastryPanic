package com.github.hanyaeger.pastrypanic;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

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
    }
}
