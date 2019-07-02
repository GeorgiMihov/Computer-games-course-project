package com.mihov.georgi.possiblegame;

import com.badlogic.gdx.Game;


import com.mihov.georgi.possiblegame.assets.Assets;
import com.mihov.georgi.possiblegame.screen.GameScreen;
import com.mihov.georgi.possiblegame.screen.SplashScreen;

public class PossibleGame extends Game {

	public enum GAME_STATE{
		PLAYING,
		MENU
	}

	public static float WIDTH = 4160;
	public static float HEIGHT = 2520;

	public static float WORLD_HEIGHT = 10;//meters

	public Assets assets;
	public GAME_STATE gameState;
	
	@Override
	public void create () {
		this.assets = new Assets();
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
