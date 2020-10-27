package com.kacstudios.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.kacstudios.game.actors.BaseActor;
import com.kacstudios.game.games.BaseGame;
import com.kacstudios.game.games.FarmaniaGame;
import com.kacstudios.game.screens.BaseScreen;
import com.kacstudios.game.screens.MainMenu;
import com.kacstudios.game.utilities.Global;


//public class Settings extends ApplicationAdapter{
public class Settings extends BaseScreen {
    //private List<Slider> slider;

    private Skin skin;
    private Stage stage;
    private Slider Gameslider;
    private Slider Musicslider;

    public void initialize() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        final Label Gamelabel = new Label("Game Volume: " + Global.GameVolume, skin);
        Gamelabel.setColor(Color.BLACK);
        //Gamelabel.setScale(1.5f);
        Gamelabel.setPosition(225, 200);

        final Slider Gameslider = new Slider(0,100,1,true, skin);
        //slider.setBounds(75,300,500,300);
        Gameslider.setValue(Global.GameVolume);
        Gameslider.setPosition(275,250);
        Gameslider.addListener(
                (Event e) ->
                {
                    Gamelabel.setText("Game Volume: " + Math.round(Gameslider.getValue()));
                    Global.GameVolume = Math.round(Gameslider.getValue());
                    return true;
                }
        );


        final Label Musiclabel = new Label("Music Volume: " + Global.MusicVolume, skin);
        Musiclabel.setColor(Color.BLACK);
        Musiclabel.setPosition(425, 200);

        final Slider Musicslider = new Slider(0,100,1,true, skin);
        //slider.setBounds(75,300,500,300);
        Musicslider.setValue(Global.MusicVolume);
        Musicslider.setPosition(475,250);
        Musicslider.addListener(
                (Event e) ->
                {
                    Musiclabel.setText("Music Volume: " + Math.round(Musicslider.getValue()));
                    Global.MusicVolume = Math.round(Musicslider.getValue());
                    return true;
                }
        );


        uiStage.addActor(Gamelabel);
        uiStage.addActor(Gameslider);
        uiStage.addActor(Musiclabel);
        uiStage.addActor(Musicslider);
        //Gdx.input.setInputProcessor(stage);





//        set background/map limits
        BaseActor farmBaseActor = new BaseActor(0,0,mainStage);
        farmBaseActor.loadTexture("MainMenu.jpg");
        farmBaseActor.setSize(1280,720);
        BaseActor.setWorldBounds(farmBaseActor);



        TextButton ApplyButton = new TextButton( "Apply", BaseGame.textButtonStyle );
        ApplyButton.setPosition(940,0);
        uiStage.addActor(ApplyButton);

        ApplyButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    return true;
                }
        );

        TextButton ExitButton = new TextButton( "Exit", BaseGame.textButtonStyle );
        ExitButton.setPosition(1135,0);
        uiStage.addActor(ExitButton);

        ExitButton.addListener(
                (Event e) ->
                {
                    if ( !(e instanceof InputEvent) )
                        return false;

                    if ( !((InputEvent)e).getType().equals(InputEvent.Type.touchDown) )
                        return false;

                    FarmaniaGame.setActiveScreen( new MainMenu() );
                    return true;
                }
        );

    }


    public void update(float dt) {

    }







    public boolean keyDown(int keyCode)
    {

        return false;
    }


}
