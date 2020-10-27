package com.kacstudios.game.inventoryItems;

public abstract class IDepleteableItem extends IInventoryItem {
    private boolean isBreakable = true;
    private float depletionPercentage = 0.00f;

    /**
     * Returns if the object should be disposed of once it is depleted.
     * @return boolean, true if the object should break when depleted.
     */
    public boolean getBreakable(){
        return isBreakable;
    }

    /**
     * Gets how depleted the item is to display its depletion. 100% is completely depleted
     * @return the depletion percentage (0.00-1.00)
     */
    public float getDepletionPercentage(){
        return depletionPercentage;
    }

    /**
     * Sets the depletion percentage of a given item in the inventory.
     */
    public void setDepletionPercentage(float percentage){
        depletionPercentage = percentage;
    }
}
