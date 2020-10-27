package com.kacstudios.game.grid;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kacstudios.game.actors.BaseActor;
import com.kacstudios.game.utilities.TimeEngine;

import java.time.LocalDateTime;

public class GridSquare extends BaseActor {

    private boolean collideWithPlayer;

    public GridSquare(boolean collides)
    {
        super();
        collideWithPlayer = collides;
        loadTexture("soil.png");

        // add event
        this.addListener(
            (Event e) ->
            {
                InputEvent ie = (InputEvent)e;
                if ( ie.getType().equals(InputEvent.Type.touchDown) )
                    this.clickFunction(TimeEngine.getDateTime());
                return false;
            }
        );
    }

    public void setTexture(String path) {
        try {
            Animation<TextureRegion> loadNewTexture = loadTexture(path);
            setAnimation(loadNewTexture);
        }
        catch (Exception ie) {
            System.out.println(ie);
        }
    }

    public void setCollisionSetting(boolean collides) {
        collideWithPlayer = collides;
    }

    public boolean getCollisionSetting() {
        return collideWithPlayer;
    }

    public void clickFunction(LocalDateTime dateTime) {
        System.out.println("I was clicked!");
    }

    @Override
    public void act(float dt) {
        super.act(dt);
    }
}
