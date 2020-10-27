package com.kacstudios.game.actors;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kacstudios.game.actors.BaseActor;

public class Farmer extends BaseActor {
    public boolean remove;
    Animation<TextureRegion> leftAnimation;
    Animation<TextureRegion> rightAnimation;
    Animation<TextureRegion> upAnimation;
    Animation<TextureRegion> downAnimation;
    float previousAngle = -1;
    int prevKey = -1;


    public Farmer(float x, float y, Stage s)
    {
        super(x,y,s);

        String[] downAnimationFiles =
                {"farmer-1.png", "farmer-2.png", "farmer-3.png",
                        "farmer-4.png", "farmer-5.png", "farmer-6.png", "farmer-7.png", "farmer-8.png"};

        String[] leftMovementFiles = {"farmer-left-1.png", "farmer-left-2.png", "farmer-left-3.png", "farmer-left-4.png", "farmer-left-5.png", "farmer-left-6.png", "farmer-left-7.png", "farmer-left-8.png"};
        String[] rightMovementFiles = {"farmer-right-1.png", "farmer-right-2.png", "farmer-right-3.png", "farmer-right-4.png", "farmer-right-5.png", "farmer-right-6.png", "farmer-right-7.png", "farmer-right-8.png"};
        String[] upMovementFiles = {"farmer-up-1.png", "farmer-up-2.png", "farmer-up-3.png", "farmer-up-4.png", "farmer-up-5.png", "farmer-up-6.png", "farmer-up-7.png", "farmer-up-8.png"};

        downAnimation = loadAnimationFromFiles(downAnimationFiles, 0.1f, true);
        leftAnimation = loadAnimationUnsetFromFiles(leftMovementFiles, 0.1f, true);
        rightAnimation = loadAnimationUnsetFromFiles(rightMovementFiles, 0.1f, true);
        upAnimation = loadAnimationUnsetFromFiles(upMovementFiles, 0.1f, true);

        setAcceleration(1000);
        setMaxSpeed(200);
        setDeceleration(1000);

        setBoundaryPolygon(8);
    }

//to get coordinates do this.getx()

    public void act(float dt)
    {
        Vector3 cursorLocation =  new Vector3(0 ,0, 0);

        super.act( dt );

        // configure sprite direction
        if(Gdx.input.isKeyPressed(Keys.W)){
            if(prevKey != Keys.W) setAnimation(upAnimation);
            prevKey = Keys.W;
        }
        else if (Gdx.input.isKeyPressed(Keys.D)) {
            if(prevKey != Keys.D) setAnimation(rightAnimation);
            prevKey = Keys.D;
        }
        else if (Gdx.input.isKeyPressed(Keys.A)) {
            if(prevKey != Keys.A) setAnimation(leftAnimation);
            prevKey = Keys.A;
        }
        else if (Gdx.input.isKeyPressed(Keys.S)) {
            if (prevKey != Keys.S) setAnimation(downAnimation);
            prevKey = Keys.S;
        }

        if (remove) {
            addAction( Actions.fadeOut(1) );
            addAction( Actions.after( Actions.removeActor() ) );
            return;
        }

        // configure acceleration
        if (Gdx.input.isKeyPressed(Keys.A))
            accelerateAtAngle(180);//left
        if (Gdx.input.isKeyPressed(Keys.D))
            accelerateAtAngle(0);//right
        if (Gdx.input.isKeyPressed(Keys.W))
            accelerateAtAngle(90);//up
        if (Gdx.input.isKeyPressed(Keys.S))
            accelerateAtAngle(270);//down

/*

        //click to move ability
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            //farmer on mainnstage


            cursorLocation.x = Gdx.input.getX();
            cursorLocation.y = Gdx.input.getY();


            this.mainStage.getWidth();
            this.mainStage.getHeight();

            Vector3 translatedLocation = this.mainStage.getCamera().unproject(cursorLocation);


            float x = translatedLocation.x;
            float y = translatedLocation.y;

            while(x < cursorLocation.x)
            {
                //farmer.setPosition((translatedLocation.x - farmer.getWidth()/2)+5, translatedLocation.y - farmer.getHeight()/2);
                //farmer.setX((float) +0.001);
                accelerateAtAngle(0);
            }
            while(x > cursorLocation.x)
            {
                //farmer.setPosition((translatedLocation.x - farmer.getWidth()/2)-5, translatedLocation.y - farmer.getHeight()/2);
                //farmer.setX((float) -0.001);
                accelerateAtAngle(180);
            }
            while(y < cursorLocation.y)
            {
                //farmer.setPosition(translatedLocation.x - farmer.getWidth()/2, (translatedLocation.y - farmer.getHeight()/2)+5);
                //farmer.setY((float) +0.001);
                accelerateAtAngle(90);
            }
            while(y > cursorLocation.y)
            {
                //farmer.setPosition(translatedLocation.x - farmer.getWidth()/2, (translatedLocation.y - farmer.getHeight()/2)-5);
                //farmer.setY((float) -0.001);
                accelerateAtAngle(270);
            }

        }






 */




        applyPhysics(dt);

        setAnimationPaused( !isMoving() );

//        if ( getSpeed() > 0 )
//            setRotation( getMotionAngle() );

        boundToWorld();

        alignCamera();
    }
}
