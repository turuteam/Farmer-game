package com.kacstudios.game.grid;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kacstudios.game.screens.LevelScreen;

public class Grid extends Actor {
    private GridSquare[][] gridSquares;
    private LevelScreen screen;
    private Integer squareSideLength = 135;

    public Grid(LevelScreen levelScreen){
        screen = levelScreen;
        setStage(levelScreen.getMainStage());
        gridSquares = new GridSquare[8][8];
    }

    /**
     * Completes physics calculations regarding grid squares.
     * @param dt deltaTime (seconds)
     */
    @Override
    public void act(float dt){
        super.act(dt);
        for(int x = 0; x < gridSquares.length; x++) {
            for (int y = 0; y < gridSquares[x].length; y++) {
                if(gridSquares[x][y] == null) continue;

                if (gridSquares[x][y].getCollisionSetting()) {
                    screen.getFarmer().preventOverlap(gridSquares[x][y]);
                }
            }
        }
    }

    /**
     * Adds a grid square to the game in the specified <b>GRID COORDINATE</b>. This does not use pixels.
     * Grid coordinates are measured starting from the bottom left of the grid (0,0).
     * @param x the x coordinate of the grid square
     * @param y the y coordinate of the grid square
     * @param square the square to add.
     */
    public void addGridSquare(int x, int y, GridSquare square){
        square.setX(squareSideLength * x);
        square.setY(squareSideLength * y);
        if(gridSquares[x][y] != null) gridSquares[x][y].remove(); // remove old square
        gridSquares[x][y] = square;
        getStage().addActor(square); // register gridSquare
    }

    /**
     * Removes a grid square at a certain grid coordinate
     * @param x the x coordinate of the grid square
     * @param y the y coordinate of the grid square
     */
    public void removeGridSquare(int x, int y){
        if(gridSquares[x][y] != null){
            gridSquares[x][y].remove(); // remove old square
            gridSquares[x][y] = null;
        }
    }
}
