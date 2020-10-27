package com.kacstudios.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.kacstudios.game.actors.BaseActor;
import com.kacstudios.game.games.BaseGame;
import com.kacstudios.game.games.FarmaniaGame;

public class MainMenu extends BaseScreen {



    public void initialize() {

//        set background/map limits
        BaseActor farmBaseActor = new BaseActor(0,0,mainStage);
        farmBaseActor.loadTexture("MainMenu.jpg");
        farmBaseActor.setSize(1280,720);
        BaseActor.setWorldBounds(farmBaseActor);



        TextButton NewButton = new TextButton( "New", BaseGame.textButtonStyle );
        NewButton.setPosition(250,150);
        uiStage.addActor(NewButton);

        NewButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    FarmaniaGame.setActiveScreen( new LevelScreen() );
                    return true;
                }
        );


        TextButton LoadButton = new TextButton( "Load", BaseGame.textButtonStyle );
        LoadButton.setPosition(410,150);
        uiStage.addActor(LoadButton);

        LoadButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    FarmaniaGame.setActiveScreen( new LevelScreen() );
                    return true;
                }
        );

        TextButton SettingsButton = new TextButton( "Settings", BaseGame.textButtonStyle );
        SettingsButton.setPosition(580,150);
        uiStage.addActor(SettingsButton);

        SettingsButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;
                    //new test();
                    FarmaniaGame.setActiveScreen( new Settings() );
                    return true;
                }
        );

        TextButton ExitButton = new TextButton( "Exit", BaseGame.textButtonStyle );
        ExitButton.setPosition(840,150);
        uiStage.addActor(ExitButton);

        ExitButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    System.exit(0);
                    return true;
                }
        );

    }








    public void update(float dt) {

    }







    public boolean keyDown(int keyCode)
    {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
            Gdx.app.exit();
        return false;
    }


}
