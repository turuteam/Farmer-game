package com.kacstudios.game.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.kacstudios.game.games.FarmaniaGame;
import com.kacstudios.game.screens.LevelScreen;
import com.kacstudios.game.screens.MainMenu;
import com.kacstudios.game.utilities.Global;
import com.kacstudios.game.utilities.TimeEngine;

public class PauseWindow {
    private Window window;
    private Window windowsetting;
    private Skin skin;

    public PauseWindow(LevelScreen screen){
        super();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        window = new Window("Paused", skin);
        window.setVisible(false);
        window.setMovable(false);

        final TextButton ResumeButton = new TextButton("Resume", skin);
        ResumeButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;

                    TimeEngine.resume();
                    screen.setPaused(false);
                    window.setVisible(false);
                    return true;
                }
        );

        final TextButton SaveButton = new TextButton("Save", skin);
        SaveButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    return ((InputEvent) e).getType().equals(InputEvent.Type.touchDown);
                }
        );

        final TextButton SettingsButton = new TextButton("Settings", skin);
        SettingsButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;
                    window.setVisible(false);
                    windowsetting.setVisible(true);

                    return true;
                }
        );

        final TextButton ExitButton = new TextButton("Exit to Main", skin);
        ExitButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;

                    TimeEngine.resume();
                    screen.setPaused(false);
                    FarmaniaGame.setActiveScreen(new MainMenu());
                    return true;
                }
        );


        //pause menu settings

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        windowsetting = new Window("Paused", skin);
        windowsetting.setVisible(false);
        windowsetting.setMovable(false);

        ////////////sliders
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        final Label Gamelabel = new Label("Game Volume: " + Global.GameVolume, skin);
        Gamelabel.setColor(Color.WHITE);
        //Gamelabel.setScale(1.5f);
        Gamelabel.setSize(1, 1);
        Gamelabel.setPosition(10, 10);

        final Slider Gameslider = new Slider(0, 100, 1, true, skin);
        //slider.setBounds(75,300,500,300);
        Gameslider.setValue(Global.GameVolume);
        Gameslider.setPosition(15, 30);
        Gameslider.addListener(
                (Event e) ->
                {
                    Gamelabel.setText("Game Volume: " + Math.round(Gameslider.getValue()));
                    Global.GameVolume = Math.round(Gameslider.getValue());
                    return true;
                }
        );


        final Label Musiclabel = new Label("Music Volume: " + Global.MusicVolume, skin);
        Musiclabel.setColor(Color.WHITE);
        Musiclabel.setSize(1, 1);
        Musiclabel.setPosition(200, 10);

        final Slider Musicslider = new Slider(0, 100, 1, true, skin);
        //slider.setBounds(75,300,500,300);
        Musicslider.setValue(Global.MusicVolume);
        //Musicslider.setPosition(155,30);
        Musicslider.setPosition(100, 30);
        Musicslider.addListener(
                (Event e) ->
                {
                    Musiclabel.setText("Music Volume: " + Math.round(Musicslider.getValue()));
                    Global.MusicVolume = Math.round(Musicslider.getValue());
                    return true;
                }
        );
        final TextButton SettingsReturnButton = new TextButton("Return", skin);
        //SettingsExitButton.setPosition(400,100);
        SettingsReturnButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    if (!((InputEvent) e).getType().equals(InputEvent.Type.touchDown))
                        return false;
                    windowsetting.setVisible(false);
                    window.setVisible(true);
                    return true;
                }
        );

        final TextButton ApplyButton = new TextButton("Apply", skin);
        //SettingsExitButton.setPosition(400,100);
        ApplyButton.addListener(
                (Event e) ->
                {
                    if (!(e instanceof InputEvent))
                        return false;

                    return ((InputEvent) e).getType().equals(InputEvent.Type.touchDown);
                }
        );


        //adding buttons to windows in pause menu overlay
        window.add(ResumeButton).width(200).row();
        window.add(SaveButton).width(200).row();
        window.add(SettingsButton).width(200).row();
        window.add(ExitButton).width(200).row();
        window.pack();
        float newWidth = 400, newHeight = 200;
        //setting Window Bounds Center on screen.
        window.setBounds((Gdx.graphics.getWidth() - newWidth) / 2, (Gdx.graphics.getHeight() - newHeight) / 2, newWidth, newHeight);

        screen.getUIStage().addActor(window);

        //adding buttons and sliders to settings menu
        windowsetting.addActor(Gamelabel);
        windowsetting.addActor(Gameslider);
        windowsetting.addActor(Musiclabel);
        windowsetting.addActor(Musicslider);
        windowsetting.add(ApplyButton);
        windowsetting.add(SettingsReturnButton);
        windowsetting.pack();
        windowsetting.setBounds((Gdx.graphics.getWidth() - newWidth) / 2, (Gdx.graphics.getHeight() - newHeight) / 2, newWidth, newHeight);
        screen.getUIStage().addActor(windowsetting);
    }

    public boolean keyDown(int keyCode)
    {

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            window.setVisible(true);

        return false;
    }

    public void setVisible(){
        window.setVisible(true);
    }
}
