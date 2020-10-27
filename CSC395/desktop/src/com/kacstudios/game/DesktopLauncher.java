package com.kacstudios.game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kacstudios.game.games.FarmaniaGame;

public class DesktopLauncher {

	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();


		config.width = 1280;
		config.height = 720;

		config.resizable = false;
		//config.fullscreen = true;

		new LwjglApplication(new FarmaniaGame(), config);
	}
}
