import java.lang.Math;

public class JumpCalcs {
    private boolean canJumpLeft;
    private boolean canJumpRight;
    private boolean canJumpAtAll;
    private int jumpLeftDistance;
    private int jumpRightDistance;
    private int jumpLeftFuelNeeded;
    private int jumpRightFuelNeeded;
    private int jumpLeftTargetBuilding;
    private int jumpRightTargetBuilding;
    private int jumpLeftBuildingHeight;
    private int jumpRightBuildingHeight;
    private int jumpLeftHeightDiff;
    private int jumpRightHeightDiff;


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

    public String display()
    {
        String returnString = "canJumpLeft:" + this.canJumpLeft + ";  canJumpRight:" + this.canJumpRight
         + ";  canJumpAtAll:" + this.canJumpAtAll + ";  jumpLeftDistance:" + this.jumpLeftDistance + ";  jumpRightDistance:" + jumpRightDistance
         + ";  jumpLeftFuelNeeded:" + this.jumpLeftFuelNeeded + ";  jumpRightFuelNeeded:" + this.jumpRightFuelNeeded 
         + ";  jumpLeftTargetBuilding:" + this.jumpLeftTargetBuilding + ";  jumpRightTargetBuilding:" + this.jumpRightTargetBuilding 
         + ";  jumpLeftBuildingHeight:" + this.jumpLeftBuildingHeight + ";  jumpRightBuildingHeight:" + this.jumpRightBuildingHeight
         + ";  jumpLeftHeightDiff:" + jumpLeftHeightDiff + ";  jumpRightHeightDiff:" + jumpRightHeightDiff;
        return returnString;
    }

    public boolean getCanJumpLeft()
    {
        return this.canJumpLeft;
    }

    public boolean getCanJumpRight()
    {
        return this.canJumpRight;
    }

    public boolean getCanJumpAtAll()
    {
        return this.canJumpAtAll;
    }

    public int getJumpLeftDistance()
    {
        return this.jumpLeftDistance;
    }

    public int getJumpRightDistance()
    {
        return this.jumpRightDistance;
    }

    public int getJumpLeftFuelNeeded()
    {
        return this.jumpLeftFuelNeeded;
    }

    public int getJumpRightFuelNeeded()
    {
        return this.jumpRightFuelNeeded;
    }

    public int getJumpLeftTargetBuilding()
    {
        return this.jumpLeftTargetBuilding;
    }



    public int getJumpLeftHeightDiff()
    {
        return this.jumpLeftHeightDiff;
    }

    public int getJumpRightHeightDiff()
    {
        return this.jumpRightHeightDiff;
    }

    public int getJumpRightTargetBuilding()
    {
        return this.jumpRightTargetBuilding;
    }

    public int getJumpLeftBuildingHeight()
    {
        return this.jumpLeftBuildingHeight;
    }

    public int getJumpRightBuildingHeight()
    {
        return this.jumpRightBuildingHeight;
    }

    public void setCanJumpLeft(boolean canJumpLeft)
    {
        this.canJumpLeft = canJumpLeft;
    }

    public void setCanJumpRight(boolean canJumpRight)
    {
        this.canJumpRight = canJumpRight;
    }

    public void setCanJumpAtAll(boolean canJumpAtAll)
    {
        this.canJumpAtAll = canJumpAtAll;
    }

    public void setJumpLeftDistance(int jumpLeftDistance)
    {
        this.jumpLeftDistance = jumpLeftDistance;
    }

    public void setJumpRightDistance(int jumpRightDistance)
    {
        this.jumpRightDistance = jumpRightDistance;
    }

    public void setJumpLeftFuelNeeded(int jumpLeftFuelNeeded)
    {
        this.jumpLeftFuelNeeded = jumpLeftFuelNeeded;
    }

    public void setJumpRightFuelNeeded(int jumpRightFuelNeeded)
    {
        this.jumpRightFuelNeeded = jumpRightFuelNeeded;
    }

    public void setJumpLeftTargetBuilding(int jumpLeftTargetBuilding)
    {
        this.jumpLeftTargetBuilding = jumpLeftTargetBuilding;
    }

    public void setJumpRightTargetBuilding(int jumpRightTargetBuilding)
    {
        this.jumpRightTargetBuilding = jumpRightTargetBuilding;
    }

    public void setJumpLeftBuildingHeight(int jumpLeftBuildingHeight)
    {
        this.jumpLeftBuildingHeight = jumpLeftBuildingHeight;
    }

    public void setJumpRightBuildingHeight(int jumpRightBuildingHeight)
    {
        this.jumpRightBuildingHeight = jumpRightBuildingHeight;
    }

    public void setJumpLeftHeightDiff(int jumpLeftHeightDiff)
    {
        this.jumpLeftHeightDiff = jumpLeftHeightDiff;
    }

    public void setJumpRightHeightDiff(int jumpRightHeightDiff)
    {
        this.jumpRightHeightDiff = jumpRightHeightDiff;
    }







}
