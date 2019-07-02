package com.mihov.georgi.possiblegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mihov.georgi.possiblegame.PossibleGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 4160 / 2;
		config.height = 2520 / 2;
		new LwjglApplication(new PossibleGame(), config);
	}
}
