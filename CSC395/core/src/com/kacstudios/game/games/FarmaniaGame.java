package com.kacstudios.game.games;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kacstudios.game.screens.MainMenu;

public class FarmaniaGame extends BaseGame {

	private Viewport viewport;
	private PerspectiveCamera camera;

	public void create () {
		super.create();

		setActiveScreen( new MainMenu() );
		camera = new PerspectiveCamera();
		viewport = new FitViewport(1280,720, camera);


	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}
