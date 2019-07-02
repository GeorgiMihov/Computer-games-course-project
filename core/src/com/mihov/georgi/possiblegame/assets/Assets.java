package com.mihov.georgi.possiblegame.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
    //Asset loader class
    public AssetManager manager;
    //Insert asset strings here
    public static String player = "player/square.png";
    public static String ground = "ground/tile.png";
    public static String enemy = "enemy/triangle.png";
    public static String menuBackground = "menu/menu.png";

    public Assets() {
        this.manager = new AssetManager();
    }

    public void load() {
        manager.load(player, Texture.class);
        manager.load(ground, Texture.class);
        manager.load(enemy, Texture.class);
        manager.load(menuBackground, Texture.class);
    }

    public void dispose() {
        manager.dispose();
    }

}
