package com.kacstudios.game.inventoryItems;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kacstudios.game.screens.LevelScreen;

public abstract class IInventoryItem {
    private Integer amount = 0;
    private String displayName = null;
    private String description = null;
    private Animation<TextureRegion> animation = null;

    /**
     * A function to be called when a given inventory item is deployed onto the map (when the object is
     * equipped and the map is clicked), the deloyer will pass in coordinates
     * and the level onto which the object is being deployed.
     * @param x the x coordinate where the action was deployed
     * @param y the y coordinate where the action was deployed
     * @param screen the screen that the deployment occurred on.
     */
    public abstract void onDeployment(float x, float y, LevelScreen screen);

    /**
     * Returns the sprite for a specific item's icon.
     * @return an icon sprite (can be animated)
     */
    public Animation<TextureRegion> getIconSprite(){
        return animation;
    }

    /**
     * Returns the display name of a given item (hose, for example)
     * @return display name
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * Returns the description of a given inventory item
     * @return the description of the item
     */
    public String getDescription(){
        return description;
    }

    /**
     * Returns the amount of the item in the users' inventory.
     * @return an integer representing the amount.
     */
    public Integer getAmount(){
        return amount;
    }
}
