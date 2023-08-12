// Class to hold the calculations for each jump. 
// Other methods can then retrieve these calculation values to progress the game. 
// Generally calculates two sets of values: Right and Left. 
// Author: David Sharp
// Verison: 1.0 

import java.lang.Math;

public class JumpCalcs 
{
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpLeftBuildingHeight;
    private int jumpLeftDistance;
    private int jumpLeftHeightDiff;
    private int jumpLeftFuelNeeded;
    private int jumpLeftTargetBuilding;
    private int jumpRightBuildingHeight;
    private int jumpRightDistance;
    private int jumpRightHeightDiff;
    private int jumpRightFuelNeeded;
    private int jumpRightTargetBuilding;

    // default constructor
    public JumpCalcs()
    {
        this.canJumpLeft = false;
        this.canJumpRight = true;
        this.canJumpAtAll = true;
        this.jumpLeftDistance = 0;
        this.jumpLeftFuelNeeded = 0;
        this.jumpLeftTargetBuilding = 0;
        this.jumpLeftBuildingHeight = 0;
        this.jumpLeftHeightDiff = 0;
        this.jumpRightDistance = 0;
        this.jumpRightFuelNeeded = 0;
        this.jumpRightTargetBuilding = 0;
        this.jumpRightBuildingHeight = 0;
        this.jumpRightHeightDiff = 0;
    }

    // // non-default constructor - player always starts at left so some assumptions can be made 
    // public JumpCalcs(int jumpDistance, int jumpRightFuelNeeded)
    // {
    //     this.canJumpLeft = false; // default ok 
    //     this.canJumpRight = false; // default ok 
    //     this.canJumpAtAll = false; // default ok 
    //     this.jumpDistance = jumpDistance; // needed 
    //     this.jumpLeftFuelNeeded = 0; // default ok 
    //     this.jumpRightFuelNeeded = jumpRightFuelNeeded; // needed 
    //     this.jumpLeftTargetBuilding = 0;
    //     this.jumpRightTargetBuilding = 3;
    //     this.jumpRightBuildingHeight = 1;
    //     this.jumpLeftBuildingHeight = 0;
    // }

    // non-default constructor - gigantic so not really used 
    public JumpCalcs(boolean canJumpLeft, boolean canJumpRight, boolean canJumpAtAll, int jumpDistance, 
    int jumpLeftFuelNeeded, int jumpRightFuelNeeded, int jumpLeftTargetBuilding, int jumpRightTargetBuilding,
    int jumpRightBuildingHeight, int jumpLeftBuildingHeight, int jumpLeftHeightDiff, int jumpRightHeightDiff)
    {
        this.canJumpLeft = canJumpLeft;
        this.canJumpRight = canJumpRight;
        this.canJumpAtAll = canJumpAtAll;
        this.jumpLeftDistance = jumpDistance;
        this.jumpLeftFuelNeeded = jumpLeftFuelNeeded;
        this.jumpRightFuelNeeded = jumpRightFuelNeeded;
        this.jumpLeftTargetBuilding = jumpLeftTargetBuilding;
        this.jumpRightTargetBuilding = jumpRightTargetBuilding;
        this.jumpRightBuildingHeight = jumpRightBuildingHeight;
        this.jumpLeftBuildingHeight = jumpLeftBuildingHeight;
        this.jumpLeftHeightDiff = jumpLeftHeightDiff;
        this.jumpRightHeightDiff = jumpRightHeightDiff;
    }

    // displays values 
    public String display()
    {
        // String returnString = "canJumpLeft:" + this.canJumpLeft + ";  canJumpRight:" + this.canJumpRight
        //  + ";  canJumpAtAll:" + this.canJumpAtAll + ";  jumpLeftDistance:" + this.jumpLeftDistance + ";  jumpRightDistance:" + jumpRightDistance
        //  + ";  jumpLeftFuelNeeded:" + this.jumpLeftFuelNeeded + ";  jumpRightFuelNeeded:" + this.jumpRightFuelNeeded 
        //  + ";  jumpLeftTargetBuilding:" + this.jumpLeftTargetBuilding + ";  jumpRightTargetBuilding:" + this.jumpRightTargetBuilding 
        //  + ";  jumpLeftBuildingHeight:" + this.jumpLeftBuildingHeight + ";  jumpRightBuildingHeight:" + this.jumpRightBuildingHeight
        //  + ";  jumpLeftHeightDiff:" + jumpLeftHeightDiff + ";  jumpRightHeightDiff:" + jumpRightHeightDiff;
        
        String returnString = "canJumpLeft:" + this.canJumpLeft + ";  canJumpRight:" + this.canJumpRight + ";  canJumpAtAll:" + this.canJumpAtAll + "\n" 
         + ";  jumpLeftDistance:" + ";  jumpLeftFuelNeeded:" + this.jumpLeftFuelNeeded + ";  jumpLeftTargetBuilding:" + this.jumpLeftTargetBuilding 
         + ";  jumpLeftBuildingHeight:" + this.jumpLeftBuildingHeight + ";  jumpLeftHeightDiff:" + jumpLeftHeightDiff + "\n" 
         + ";  jumpRightDistance:" + jumpRightDistance + ";  jumpRightFuelNeeded:" + this.jumpRightFuelNeeded + ";  jumpRightTargetBuilding:" + this.jumpRightTargetBuilding 
         + ";  jumpRightBuildingHeight:" + this.jumpRightBuildingHeight + ";  jumpRightHeightDiff:" + jumpRightHeightDiff;

        return returnString;

    }

    // retrieve canJumpLeft boolean 
    public boolean getCanJumpLeft()
    {
        return this.canJumpLeft;
    }

    // retrieve canJumpRight boolean 
    public boolean getCanJumpRight()
    {
        return this.canJumpRight;
    }

    // retrieve canJumpAtAll boolean 
    public boolean getCanJumpAtAll()
    {
        return this.canJumpAtAll;
    }

    // retrieve JumpLeftDistance integer 
    public int getJumpLeftDistance()
    {
        return this.jumpLeftDistance;
    }

    // retrieve JumpRightDistance integer 
    public int getJumpRightDistance()
    {
        return this.jumpRightDistance;
    }

    // retrieve jumpLeftFuelNeeded integer 
    public int getJumpLeftFuelNeeded()
    {
        return this.jumpLeftFuelNeeded;
    }

    // retreive jumpRightFuelNeeded integer 
    public int getJumpRightFuelNeeded()
    {
        return this.jumpRightFuelNeeded;
    }

    // retrieve Target Building when jumping left 
    public int getJumpLeftTargetBuilding()
    {
        return this.jumpLeftTargetBuilding;
    }

    // retrieve height diff between current building and left building 
    public int getJumpLeftHeightDiff()
    {
        return this.jumpLeftHeightDiff;
    }

    // retreive heigh diff between current building and right building 
    public int getJumpRightHeightDiff()
    {
        return this.jumpRightHeightDiff;
    }

    // retrieve target building number when jumping right 
    public int getJumpRightTargetBuilding()
    {
        return this.jumpRightTargetBuilding;
    }

    // retrieve the height of the building to the left jump 
    public int getJumpLeftBuildingHeight()
    {
        return this.jumpLeftBuildingHeight;
    }

    // retrieve the height of the building to the right jump 
    public int getJumpRightBuildingHeight()
    {
        return this.jumpRightBuildingHeight;
    }

    // set boolean flag CanJumpLeft
    public void setCanJumpLeft(boolean canJumpLeft)
    {
        this.canJumpLeft = canJumpLeft;
    }

    // set boolean flag canJumpRight 
    public void setCanJumpRight(boolean canJumpRight)
    {
        this.canJumpRight = canJumpRight;
    }

    // set boolean flag CanJumpAtAll 
    public void setCanJumpAtAll(boolean canJumpAtAll)
    {
        this.canJumpAtAll = canJumpAtAll;
    }
 
    // set integer JumpLeftDistance
    public void setJumpLeftDistance(int jumpLeftDistance)
    {
        this.jumpLeftDistance = jumpLeftDistance;
    }

    // set integer JumpRightDistance 
    public void setJumpRightDistance(int jumpRightDistance)
    {
        this.jumpRightDistance = jumpRightDistance;
    }

    // set integer jumpLeftFuelNeeded
    public void setJumpLeftFuelNeeded(int jumpLeftFuelNeeded)
    {
        this.jumpLeftFuelNeeded = jumpLeftFuelNeeded;
    }

    // set integer jumpRightFuelNeeded 
    public void setJumpRightFuelNeeded(int jumpRightFuelNeeded)
    {
        this.jumpRightFuelNeeded = jumpRightFuelNeeded;
    }

    // set integer jumpLeftTargetBuilding 
    public void setJumpLeftTargetBuilding(int jumpLeftTargetBuilding)
    {
        this.jumpLeftTargetBuilding = jumpLeftTargetBuilding;
    }

    // set integer jumpRightTargetBuilding 
    public void setJumpRightTargetBuilding(int jumpRightTargetBuilding)
    {
        this.jumpRightTargetBuilding = jumpRightTargetBuilding;
    }

    // set integer jumpLeftBuildingHeight 
    public void setJumpLeftBuildingHeight(int jumpLeftBuildingHeight)
    {
        this.jumpLeftBuildingHeight = jumpLeftBuildingHeight;
    }

    // set integer jumpRightBuildingHeight 
    public void setJumpRightBuildingHeight(int jumpRightBuildingHeight)
    {
        this.jumpRightBuildingHeight = jumpRightBuildingHeight;
    }

    // set integer jumpLeftHeightDiff
    public void setJumpLeftHeightDiff(int jumpLeftHeightDiff)
    {
        this.jumpLeftHeightDiff = jumpLeftHeightDiff;
    }

    // set integer jumpRightHeightDiff 
    public void setJumpRightHeightDiff(int jumpRightHeightDiff)
    {
        this.jumpRightHeightDiff = jumpRightHeightDiff;
    }
}
